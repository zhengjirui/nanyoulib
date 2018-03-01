package io.rong.imkit.home.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imkit.NYAppManger;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.Utils.SharedUtil;
import io.rong.imkit.base.BaseActivity;
import io.rong.imkit.dialog.ConversitionOffDialog;
import io.rong.imkit.dialog.EvaluateAlertSatisfied;
import io.rong.imkit.events.ConversationBackLisenter;
import io.rong.imkit.events.EventBusAbstract;
import io.rong.imkit.events.FinishHomeListenter;
import io.rong.imkit.events.LeavSuccessListenter;
import io.rong.imkit.events.RongConnectLisenter;
import io.rong.imkit.events.WaitingBackLisenter;
import io.rong.imkit.home.adapter.RvAdapter;
import io.rong.imkit.home.basebean.AbMenuBean;
import io.rong.imkit.home.bean.MsgTypeAttrs;
import io.rong.imkit.home.bean.MsgTypeBean;
import io.rong.imkit.home.bean.MsgTypeStaffBean;
import io.rong.imkit.leavingmsg.LeavingMsgActivity;
import io.rong.imkit.request.HttpManger;
import io.rong.imkit.waitqueue.activity.WaitQueueActivity;
import io.rong.imlib.RongIMClient;
import okhttp3.Call;
import okhttp3.Response;

import static io.rong.imkit.constant.Constant.REQUEST_CONVERCATION;
import static io.rong.imkit.constant.Constant.REQUEST_HANGUP;
import static io.rong.imkit.constant.Constant.REQUEST_MOVE;
import static io.rong.imkit.constant.Constant.USER_INIT;

public class HomeActivity extends BaseActivity implements OnRefreshListener {

    private static final String TAG = "--HomeActivity";
    //1为请求参数列表的数据，2为请求入队列
    private int requestType = 1;//网络请求的类型，默认为1

    private RecyclerView ny_recycleview;
    private GridLayoutManager gvManger;
    private RvAdapter adapter;
    private MsgTypeAttrs msgTypeAttrs;

    private boolean refreshUp = false;
    private RefreshLayout refreshLayout;
    private ConversitionOffDialog conversitionOffDialog;

    private MsgTypeBean msgTypeBean = new MsgTypeBean();
    private String appId;
    private String user_id;
    private String visitor_img = "";
    private String visitor_name;
    private String visitor_parameters;
    private String appAccessName;

    private String group_id;//首页分类id
    private String rule_id;//分配规则id
    private int start_menu_status;//菜单的状态
    private EvaluateAlertSatisfied evaluateAlertSatisfied;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ny_activity_home);
        //设置沉浸式静态栏
        setColorBarAlpha(this, getResources().getColor(R.color.de_title_bg), 10);
        initCreateContent();
    }

    @Override
    public void initCreateContent() {
        //获取传递的值
        Intent intent = getIntent();
        appId = intent.getStringExtra("appId");
        user_id = intent.getStringExtra("userId");
        visitor_img = intent.getStringExtra("userImgUrl");
        visitor_name = intent.getStringExtra("userName");
        visitor_parameters = intent.getStringExtra("userParameters");
        visitor_parameters = "{\"ANDROID\":\"ANDROID\"}";
        appAccessName = intent.getStringExtra("appAccessName");

        //查找id设置刷新控件
        refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        ny_recycleview = (RecyclerView) findViewById(R.id.ny_recycleview);
        ClassicsHeader classicsHeader = new ClassicsHeader(this);
        refreshLayout.setRefreshHeader(classicsHeader);//设置Header
        refreshLayout.setOnRefreshListener(this);

        gvManger = new GridLayoutManager(this, 3);
        gvManger.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = ny_recycleview.getAdapter().getItemViewType(position);
                if (type == 0) {
                    return gvManger.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        ny_recycleview.setLayoutManager(gvManger);

        //初始化列表数据
        adapter = new RvAdapter(this, msgTypeBean);
        ny_recycleview.setAdapter(adapter);
        //设置间隔
        ny_recycleview.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();

                if (spanSize == 1) {
                    outRect.bottom = 10;
                    if (spanIndex != gvManger.getSpanCount()) {
                        if (spanIndex == 1) {
                            outRect.left = 5;
                        } else if (spanIndex == 2) {
                            outRect.left = 10;
                        } else {
                            outRect.right = 5;
                        }
                    }
                }
            }
        });
        //请求列表和配置文件接口
        requestHttp1();
    }

    /**
     * 请求列表和配置文件接口
     */
    public void requestHttp1() {
        if (appId == null || appId.equalsIgnoreCase("") ||
                user_id == null || user_id.equalsIgnoreCase("") ||
                visitor_name == null || visitor_name.equalsIgnoreCase("") ||
                visitor_parameters == null || visitor_parameters.equalsIgnoreCase("") ||
                appAccessName == null || appAccessName.equalsIgnoreCase("")) {
            NyUtiles.showToast("参数传输错误");
            refreshLayout.finishRefresh(10, false);
            return;
        }

        SharedUtil.put("visitor_name", this.visitor_name);
        NYAppManger.getInstance().setAccessAppName(appAccessName);
        if(visitor_img != null && !visitor_img.equalsIgnoreCase("")){
            SharedUtil.put("vis_icon",visitor_img);
        }

        if (visitor_parameters == null || visitor_parameters.equalsIgnoreCase("")) {
            try {
                visitor_parameters = "ANDROID";//异常时默认为Android{"ANDROID":"ANDROID"}
                visitor_parameters = NyUtiles.getInfoJson();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (!refreshUp) {
            show();
        }
        this.refreshUp = false;
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("appId", this.appId);
            jsonObj.put("from_type", 3);
            jsonObj.put("info", this.visitor_parameters);
            jsonObj.put("visitor_img", this.visitor_img);
            jsonObj.put("visitor_name", this.visitor_name);
            jsonObj.put("visitor_id", this.user_id + NyUtiles.getDeviceId(HomeActivity.this));
            NyUtiles.showLog(TAG,this.user_id + NyUtiles.getDeviceId(HomeActivity.this));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestType = 1;
        HttpManger.getHttpInstance().sendPostJsonRequest(USER_INIT, jsonObj.toString(), this);
    }

    /**
     * 调用后台接口，请求入队列
     *
     * @param group_id 列表对应的组id
     */
    public void requestHttp2(String group_id, String group_name, String msg, String rule_id) {
        this.group_id = group_id;
        this.rule_id = rule_id;

        //保存请求队列的数据
        SharedUtil.put("group_id", this.group_id);
        SharedUtil.put("visitor_name", this.visitor_name);
        SharedUtil.put("group_name", group_name);
        SharedUtil.put("rule_id", this.rule_id);
        SharedUtil.put("greeting", msg);

        if (NYAppManger.getInstance().isRongConnectStateLisenter()) {
            show();
            JSONObject jsonObj = new JSONObject();
            try {
                jsonObj.put("visitor_token", SharedUtil.get("visitor_token", ""));
                jsonObj.put("group_id", this.group_id);
                jsonObj.put("visitor_name", this.visitor_name);
                jsonObj.put("group_name", group_name);
                jsonObj.put("rule_id", this.rule_id);
                jsonObj.put("greeting", msg);
                jsonObj.put("app_sign", (int) SharedUtil.get("app_sign", -1));
                NyUtiles.showLog(TAG,SharedUtil.get("app_sign", -1) + "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            requestType = 2;
            HttpManger.getHttpInstance().sendPostJsonRequest(REQUEST_CONVERCATION, jsonObj.toString(), this);
        } else {
            NyUtiles.showLog(TAG, "网络链接不稳定！");
            NyUtiles.showToast("网络链接不稳定！");
        }
    }

    private void requestHttpWaiting(String session_id) {
        requestType = -1;
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("visitor_token", SharedUtil.get("visitor_token", ""));
            jsonObj.put("group_id", this.group_id);
            jsonObj.put("rule_id", this.rule_id);
            jsonObj.put("session_id", session_id);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpManger.getHttpInstance().sendPostJsonRequest(REQUEST_MOVE, jsonObj.toString(), this);
    }

    public void requestHttpConversation(String kf_id, String mTargetId,String session_id) {
        requestType = -1;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("visitor_token", SharedUtil.get("visitor_token", ""));
            jsonObject.put("kf_id", kf_id);
            jsonObject.put("group_id", mTargetId);
            jsonObject.put("session_id", session_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpManger.getHttpInstance().sendPostJsonRequest(REQUEST_HANGUP, jsonObject.toString(), this);

    }

    @Override
    public void onSuccess(Call call, Response response, String json) {
        Gson gson = new Gson();
        switch (requestType) {
            case 1:
                msgTypeAttrs = gson.fromJson(json, MsgTypeAttrs.class);
                String visitor_token = msgTypeAttrs.getVisitor_token();
                int app_sign = msgTypeAttrs.getApp_sign();
                String rong_code = msgTypeAttrs.getRong_code();
                String rong_Token = msgTypeAttrs.getCustomerToken();

                NyUtiles.showLog(TAG,rong_Token);

                //用户登录喃呱api的token
                SharedUtil.put("visitor_token", visitor_token);

                SharedUtil.put("rong_code", rong_code);
                SharedUtil.put("rong_Token", rong_Token);
                SharedUtil.put("app_sign", app_sign);
                NYAppManger.getInstance().initRongIm((String) SharedUtil.get("rong_code", ""));
//                NYAppManger.getInstance().rongImConnect((String) SharedUtil.get("rong_Token", ""));
                start_menu_status = msgTypeAttrs.getAttr().get(0).getStart_menu_status();
                SharedUtil.put("start_menu_status", start_menu_status);
                msgTypeBean = initMsgTypeBean(msgTypeAttrs);
                adapter.setNotifyDataSetChanged(msgTypeBean);
                super.onSuccess(call, response, json);
                //得到融云token后需要链接融云，链接融云后操作
                connectRongIM();
                break;
            case 2:
                MsgTypeStaffBean msgTypeStaffBean = gson.fromJson(json, MsgTypeStaffBean.class);
                //判断请求的返回值，
                String type = msgTypeStaffBean.getType();

                if(type.equalsIgnoreCase("WAIT")){
                    int wait_count = msgTypeStaffBean.getWait_count();
                    NyUtiles.showLog(TAG,"" + "断点1：" + wait_count);
                    String session_id = msgTypeStaffBean.getSession_id();
                    int msg_rule_status = (int) SharedUtil.get("msg_rule_status",-1);
                    String msg_type2_status = (String) SharedUtil.get("msg_type2_status","");

                    if(msg_rule_status == 1){
                        if(!msg_type2_status.equalsIgnoreCase("") && msg_type2_status.equalsIgnoreCase("1")){
                            if(wait_count > Integer.valueOf((String)SharedUtil.get("msg_type2_count","-1"))){
                                //提示弹出框
                                popuDialog((String) SharedUtil.get("msg_type2_msg", ""));
                                refreshLayout.finishRefresh(10, true);
                                super.onSuccess(call, response, json);
                                return;
                            }
                        }
                    }
                    Intent intent = new Intent(HomeActivity.this, WaitQueueActivity.class);
                    intent.putExtra("visitor_token", (String) SharedUtil.get("visitor_token", ""));
                    intent.putExtra("group_id", this.group_id);
                    intent.putExtra("rule_id", this.rule_id);
                    intent.putExtra("wait_count", wait_count);
                    intent.putExtra("session_id", session_id);
                    NyUtiles.showLog(TAG,"" + "断点2：" + wait_count);
                    startActivity(intent);
                }else if(type.equalsIgnoreCase("INFOM")){
                    String groupId = msgTypeStaffBean.getGroupId();
                    String kf_id = msgTypeStaffBean.getKf_id();
                    String kf_name = msgTypeStaffBean.getKf_name();
                    String session_id = msgTypeStaffBean.getSession_id();
                    String visitor_id = msgTypeStaffBean.getVisitor_id();
                    startGroupChat(groupId,kf_id,visitor_id,session_id,kf_name);
                }



                super.onSuccess(call, response, json);
                break;
            default:
                super.onSuccess(call, response, json);
                break;
        }
        refreshLayout.finishRefresh(10, true);
    }

    @Override
    public void onException(Call call, int code, String codeInfo) {
        super.onException(call, code,codeInfo);
        refreshLayout.finishRefresh(10, false);
        if (code == 1165 ) {
            int msg_rule_status = (int) SharedUtil.get("msg_rule_status",-1);
            if(msg_rule_status ==1){
                popuDialog((String) SharedUtil.get("msg_type1_msg", ""));
            }
        }
        if(code == 1178){
            int msg_rule_status = (int) SharedUtil.get("msg_rule_status",-1);
            String msg_type2_status = (String) SharedUtil.get("msg_type2_status","");
            if(msg_rule_status ==1 && !msg_type2_status.equalsIgnoreCase("") && msg_type2_status.equalsIgnoreCase("1")){
                popuDialog((String) SharedUtil.get("msg_type2_msg", ""));
            }
        }
    }

    @Override
    public void onFailure(Call call, IOException e) {
        super.onFailure(call, e);
        refreshLayout.finishRefresh(10, false);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        this.refreshUp = true;
        requestHttp1();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NYAppManger.getInstance().setRongConnectStateLisenter(false);
        NYAppManger.getInstance().logoutRongIM();
    }

    //链接融云
    private void connectRongIM() {
        if (!NYAppManger.getInstance().isRongConnectStateLisenter()) {
            RongIM.connect((String) SharedUtil.get("rong_Token", ""), new RongIMClient.ConnectCallback() {
                @Override
                public void onTokenIncorrect() {
                    NyUtiles.showLog(TAG, "验证token失败");
                    NyUtiles.showToast(R.string.request_toast + "0003");
                }

                @Override
                public void onSuccess(String s) {
                    if (start_menu_status == 2) {

                        List<MsgTypeAttrs.AttrBean> attr = msgTypeAttrs.getAttr();
                        MsgTypeAttrs.AttrBean attrBean = attr.get(0);
                        MsgTypeAttrs.AttrBean.StartMenu2Bean start_menu2 = attrBean.getStart_menu2();
                        requestHttp2(start_menu2.getGroup_id(), "停用菜单", start_menu2.getMsg(), start_menu2.getRule_id());
//                        requestHttp2(start_menu2.getGroup_id(), start_menu2.getName(), start_menu2.getMsg(), start_menu2.getRule_id());
                    }
                    NyUtiles.showLog(TAG, "登录融云成功" + s);
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    NyUtiles.showLog(TAG, "登录融云失败" + errorCode);
                    NyUtiles.showToast(R.string.request_toast + "0004");
                }
            });
        } else {
            if (start_menu_status == 2) {
                List<MsgTypeAttrs.AttrBean> attr = msgTypeAttrs.getAttr();
                MsgTypeAttrs.AttrBean attrBean = attr.get(0);
                MsgTypeAttrs.AttrBean.StartMenu2Bean start_menu2 = attrBean.getStart_menu2();
                requestHttp2(start_menu2.getGroup_id(), "停用菜单", start_menu2.getMsg(), start_menu2.getRule_id());
//                requestHttp2(start_menu2.getGroup_id(), start_menu2.getName(), start_menu2.getMsg(), start_menu2.getRule_id());
            }
        }
    }

    //数据转换
    private MsgTypeBean initMsgTypeBean(MsgTypeAttrs msgTypeAttrs) {

        //处理首页的列表页
        try {
            List<MsgTypeAttrs.AttrBean> attr = msgTypeAttrs.getAttr();
            setAttrsDate(attr);
            MsgTypeAttrs.AttrBean attrBean = attr.get(0);

            MsgTypeAttrs.AttrBean attrBean15 = attr.get(14);
            String kefu_name = attrBean15.getKefu_name();
            String kefu_icon = attrBean15.getKefu_icon();
            String vis_icon = attrBean15.getVis_icon();
            String title = attrBean15.getTitle();

            SharedUtil.put("kefu_name", kefu_name);//标题
            String vis_iconHttp = (String) SharedUtil.get("vis_icon", "");

            if(vis_iconHttp.equalsIgnoreCase("")){
                SharedUtil.put("vis_icon", vis_icon);//访客头像
            }

            setTitle((String) SharedUtil.get("kefu_name", ""));

            List<AbMenuBean> start_menu1_list = new ArrayList<>();

            MsgTypeBean msgTypeBean = new MsgTypeBean();
            MsgTypeBean.MsgTypeHeaderBean msgTypeHeaderBean = msgTypeBean.getMsgTypeHeaderBean();
            msgTypeHeaderBean.setHeader_img_url(kefu_icon);
            msgTypeHeaderBean.setHeader_text(title);

            if (start_menu_status == 1) {
                MsgTypeAttrs.AttrBean.StartMenu1Bean start_menu1 = attrBean.getStart_menu1();

                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu1Bean menu_1 = start_menu1.getMenu_1();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu2Bean menu_2 = start_menu1.getMenu_2();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu3Bean menu_3 = start_menu1.getMenu_3();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu4Bean menu_4 = start_menu1.getMenu_4();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu5Bean menu_5 = start_menu1.getMenu_5();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu6Bean menu_6 = start_menu1.getMenu_6();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu7Bean menu_7 = start_menu1.getMenu_7();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu8Bean menu_8 = start_menu1.getMenu_8();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu9Bean menu_9 = start_menu1.getMenu_9();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu10Bean menu_10 = start_menu1.getMenu_10();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu11Bean menu_11 = start_menu1.getMenu_11();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu12Bean menu_12 = start_menu1.getMenu_12();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu13Bean menu_13 = start_menu1.getMenu_13();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu14Bean menu_14 = start_menu1.getMenu_14();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu15Bean menu_15 = start_menu1.getMenu_15();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu16Bean menu_16 = start_menu1.getMenu_16();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu17Bean menu_17 = start_menu1.getMenu_17();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu18Bean menu_18 = start_menu1.getMenu_18();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu19Bean menu_19 = start_menu1.getMenu_19();
                MsgTypeAttrs.AttrBean.StartMenu1Bean.Menu20Bean menu_20 = start_menu1.getMenu_20();
                start_menu1_list.add(menu_1);
                start_menu1_list.add(menu_2);
                start_menu1_list.add(menu_3);
                start_menu1_list.add(menu_4);
                start_menu1_list.add(menu_5);
                start_menu1_list.add(menu_6);
                start_menu1_list.add(menu_7);
                start_menu1_list.add(menu_8);
                start_menu1_list.add(menu_9);
                start_menu1_list.add(menu_10);
                start_menu1_list.add(menu_11);
                start_menu1_list.add(menu_12);
                start_menu1_list.add(menu_13);
                start_menu1_list.add(menu_14);
                start_menu1_list.add(menu_15);
                start_menu1_list.add(menu_16);
                start_menu1_list.add(menu_17);
                start_menu1_list.add(menu_18);
                start_menu1_list.add(menu_19);
                start_menu1_list.add(menu_20);


                List<MsgTypeBean.MsgTypeGvBean> msgTypeGvBeenList = msgTypeBean.getMsgTypeGvBeenList();
                for (int i = 0; i < start_menu1_list.size(); i++) {

                    AbMenuBean abMenuBean = start_menu1_list.get(i);
                    if (abMenuBean != null) {
                        if (abMenuBean.getIs_del() != null && "1".equalsIgnoreCase(abMenuBean.getIs_del())
                                && abMenuBean.getStatus() != null && "1".equalsIgnoreCase(abMenuBean.getStatus())) {
                            MsgTypeBean.MsgTypeGvBean msgTypeGvBean = new MsgTypeBean.MsgTypeGvBean();

                            msgTypeGvBean.setType_text(abMenuBean.getName());
                            msgTypeGvBean.setGroup_id(abMenuBean.getGroup_id());
                            msgTypeGvBean.setMsg(abMenuBean.getMsg());
                            msgTypeGvBean.setType_img_url(abMenuBean.getIcon());
                            msgTypeGvBean.setRule_id(abMenuBean.getRule_id());

                            msgTypeGvBeenList.add(msgTypeGvBean);
                        }
                    }
                }
            }

            return msgTypeBean;
        } catch (Exception e) {
            NyUtiles.showLog(TAG, "参数解析异常");
            return new MsgTypeBean();
        }
    }

    private void setAttrsDate(List<MsgTypeAttrs.AttrBean> attr) {

        try {
            for (int i = 0; i < attr.size(); i++) {

                switch (i) {
                    case 0:
                        break;
                    case 1:
                        //无效访客过滤 1 --启动 2 --禁用
                        MsgTypeAttrs.AttrBean attrBean1 = attr.get(1);
                        SharedUtil.put("vain_filtration_status", attrBean1.getVain_filtration_status());
                        break;
                    case 2:
                        MsgTypeAttrs.AttrBean attrBean2 = attr.get(2);
                        SharedUtil.put("msg_rule_status", attrBean2.getQueue_rule_status());
                        SharedUtil.put("queue_rule_msg", attrBean2.getQueue_rule_msg());
                        break;
                    case 3:
                        MsgTypeAttrs.AttrBean attrBean3 = attr.get(3);
                        SharedUtil.put("msg_rule_status", attrBean3.getMsg_rule_status());
                        SharedUtil.put("msg_type1_msg", attrBean3.getMsg_type1_msg());
                        SharedUtil.put("msg_type2_msg", attrBean3.getMsg_type2_msg());
                        SharedUtil.put("msg_type2_count", attrBean3.getMsg_type2_count());
                        SharedUtil.put("msg_type2_status", attrBean3.getmsg_type2_status());
                        break;
                    case 4:
                        MsgTypeAttrs.AttrBean attrBean4 = attr.get(3);
                        SharedUtil.put("session_stop_status", attrBean4.getSession_stop_status());
                        SharedUtil.put("session_stop_msg", attrBean4.getSession_stop_msg());
                        break;
                    case 5:
                        MsgTypeAttrs.AttrBean attrBean5 = attr.get(5);
                        SharedUtil.put("feed_back_status", attrBean5.getFeed_back_status());
                        SharedUtil.put("feed_back_msg", attrBean5.getFeed_back_msg());
                        SharedUtil.put("feed_back_value1", attrBean5.getFeed_back_value1());
                        SharedUtil.put("feed_back_value2", attrBean5.getFeed_back_value2());
                        SharedUtil.put("feed_back_value3", attrBean5.getFeed_back_value3());
                        SharedUtil.put("feed_back_value4", attrBean5.getFeed_back_value4());
                        SharedUtil.put("feed_back_value5", attrBean5.getFeed_back_value5());
                        SharedUtil.put("feed_back_type", attrBean5.getFeed_back_type());
                        SharedUtil.put("feed_back_thank", attrBean5.getFeed_back_thank());
                        break;
                    case 6:
                        MsgTypeAttrs.AttrBean attrBean6 = attr.get(6);
                        SharedUtil.put("dumb_rule_status", attrBean6.getDumb_rule_status());
                        SharedUtil.put("dumb_rule_time", attrBean6.getDumb_rule_time());
                        SharedUtil.put("dump_rule_msg", attrBean6.getDump_rule_msg());
                        break;
                    case 7:
                        MsgTypeAttrs.AttrBean attrBean7 = attr.get(7);
                        SharedUtil.put("res_timeout_status", attrBean7.getRes_timeout_status());
                        SharedUtil.put("res_timeout_time", attrBean7.getRes_timeout_time());
                        break;
                    case 8:
                        break;
                    case 9:
                        MsgTypeAttrs.AttrBean attrBean9 = attr.get(9);
                        SharedUtil.put("network_anomaly_status", attrBean9.getNetwork_anomaly_status());
                        SharedUtil.put("network_anomaly_type", attrBean9.getNetwork_anomaly_type());
                        SharedUtil.put("network_anomaly_msg", attrBean9.getNetwork_anomaly_msg());
                        SharedUtil.put("network_anomaly_time", attrBean9.getNetwork_anomaly_time());
                        break;
                    case 10:
                        MsgTypeAttrs.AttrBean attrBean10 = attr.get(10);
                        SharedUtil.put("cvst_category_status", attrBean10.getCvst_category_status());
                        break;
                    case 11:
                        MsgTypeAttrs.AttrBean attrBean11 = attr.get(11);
                        SharedUtil.put("repetition_session_status", attrBean11.getRepetition_session_status());
                        SharedUtil.put("repetion_session_time", attrBean11.getRepetion_session_time());
                        break;
                    case 12:
                        break;
                    case 13:
                        MsgTypeAttrs.AttrBean attrBean13 = attr.get(13);
                        SharedUtil.put("visitor_switch_status", attrBean13.getVisitor_switch_status());
                        SharedUtil.put("greeting_content_msg", attrBean13.getGreeting_content_msg());
                        break;
                }
            }
        } catch (Exception e) {
            NyUtiles.showLog(TAG, "请求参数设置错误");
        }
    }

    private void popuDialog(String leavingMsg) {
        conversitionOffDialog = new ConversitionOffDialog(this);
        conversitionOffDialog.builder()
                .setTitle("提示！")
                .setMsg(leavingMsg)
                .setPositiveButton("留言", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (group_id == null || group_id.equalsIgnoreCase("")) {
                            return;
                        }
                        Intent intent = new Intent(HomeActivity.this, LeavingMsgActivity.class);
                        intent.putExtra("group_id", group_id);
                        intent.putExtra("session_id","");
                        intent.putExtra("leaveType",false);//留言是否带session_id,false不带，true带
                        startActivity(intent);
                        conversitionOffDialog.dismiss();
                    }
                })
                .setNegativeButton("关闭", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    private void startGroupChat(String group_id, String kf_id, String user_id, String session_id,String Kf_name) {

        Map<String, String> map = new HashMap<>();
        map.put("kf_id", kf_id);
        map.put("session_id", session_id);
        map.put("user_id", user_id);
        map.put("Kf_name", Kf_name);
        NYAppManger.getInstance().startGroupChat(group_id, group_id, map);
    }

    @Override
    public void onEventMainThread(EventBusAbstract eventBus) {
        if (eventBus instanceof RongConnectLisenter) {
            RongConnectLisenter lisenter = (RongConnectLisenter) eventBus;
            boolean connectState = lisenter.getmConnectState();
            NYAppManger.getInstance().setRongConnectStateLisenter(connectState);
            if(connectState){
                dismiss();
            }else {
                show();
            }
        }else if(eventBus instanceof WaitingBackLisenter){
            WaitingBackLisenter lisenter = (WaitingBackLisenter) eventBus;
            requestHttpWaiting(lisenter.getSession_id() );
        }else if(eventBus instanceof ConversationBackLisenter){
            ConversationBackLisenter lisenter = (ConversationBackLisenter) eventBus;
            requestHttpConversation(lisenter.getKf_id(),lisenter.getmTargetId(),lisenter.getSession_id());
        }else if(eventBus instanceof LeavSuccessListenter){
            NyUtiles.showToast("留言成功！");
        }else if(start_menu_status == 2 && eventBus instanceof FinishHomeListenter){
            finish();
        }

    }

}

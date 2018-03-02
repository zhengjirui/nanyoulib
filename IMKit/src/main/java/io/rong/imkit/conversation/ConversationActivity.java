package io.rong.imkit.conversation;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import io.rong.eventbus.EventBus;
import io.rong.imkit.NYAppManger;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.Utils.SharedUtil;
import io.rong.imkit.base.BaseActivity;
import io.rong.imkit.dialog.ConversitionOffDialog;
import io.rong.imkit.dialog.EvaluateAlert;
import io.rong.imkit.dialog.EvaluateAlertSatisfied;
import io.rong.imkit.events.ConverEvaLisenter;
import io.rong.imkit.events.ConversationBackLisenter;
import io.rong.imkit.events.CustomerStateLisenter;
import io.rong.imkit.events.EventBusAbstract;
import io.rong.imkit.events.FinishHomeListenter;
import io.rong.imkit.events.RongReceiveMsgListener;
import io.rong.imkit.messages.WaitMessage;
import io.rong.imkit.request.HttpManger;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import io.rong.message.InformationNotificationMessage;
import io.rong.message.TextMessage;
import okhttp3.Call;
import okhttp3.Response;

import static io.rong.imkit.constant.Constant.REQUEST_EVALUATE;
import static io.rong.imkit.constant.Constant.REQUEST_HANGUP;

public class ConversationActivity extends BaseActivity {
    private final String TAG = "--ConversationActivity";
    private int requestType = 1;//请求类型

    private CusConversationView fragment;
    private ConversitionOffDialog conversitionOffDialog;

    private String mTargetId; //群组 Id
    private String kf_id;
    private String user_id;//用户id,用户设置用户提供者
    private String visitor_img;//用户头像，用户设置用户提供者
    private Intent intent;
    private EvaluateAlert evaluateAlert;
    private String session_id;
    private EvaluateAlertSatisfied evaluateAlertSatisfied;
    private String kf_name;
    private String mEvaluateContent = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ny_activity_conversation);
        setColorBarAlpha(this, getResources().getColor(R.color.de_title_bg), 10);
        SharedUtil.put("CustomerIsLink",true);//保持客服链接为true，断开为false（进入到聊天界面为链接状态）
        SharedUtil.put("CONVERSATION",true);////标记会话是否已连接，true代表链接
        initCreateContent();
        startConversation();
//        insertintoinfo();
    }


    public void initCreateContent() {
        /* 从 intent 携带的数据里获取 targetId 和会话类型*/
        intent = getIntent();
        kf_id = intent.getStringExtra("kf_id");
        user_id = intent.getStringExtra("user_id");
        session_id = intent.getStringExtra("session_id");
        kf_name = intent.getStringExtra("Kf_name");
        mTargetId = intent.getData().getQueryParameter("targetId");//这里获取的是group_id

        NYAppManger.getInstance().setUserInfoProvider(this.user_id, this.user_id,
                (String) SharedUtil.get("vis_icon","http://ng.boy01.com/icon/kefu.png"));

        setTitle((String)SharedUtil.get("kefu_name",""));
    }

    private void startConversation() {

        Conversation.ConversationType mConversationType = Conversation.ConversationType.valueOf(
                intent.getData().getLastPathSegment().toUpperCase(Locale.US));
        /* 新建 CusConversationFragment 实例，通过 setUri() 设置相关属性*/
        fragment = new CusConversationView();
        fragment.setSession_id(this.session_id);
        Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                .appendPath("conversation").appendPath(mConversationType.getName().toLowerCase())
                .appendQueryParameter("targetId", mTargetId).build();
        fragment.setUri(uri);
        UserInfo userInfo = new UserInfo(this.user_id,(String) SharedUtil.get("visitor_name",""),
                Uri.parse((String) SharedUtil.get("vis_icon","http://ng.boy01.com/icon/kefu.png")));
        fragment.setInfo(userInfo);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.rong_content, fragment);
        transaction.commit();
    }

    public void requestHttp() {
        if (requestType == 1) {
            show();

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
        }else {
            EventBus.getDefault().post(new ConversationBackLisenter(this.kf_id,this.mTargetId,this.session_id));
        }

    }

    public void requestHttp2(String mark) {
        if (requestType == 0) {
            show();
        }

        //发起评价的接口
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("visitor_token", SharedUtil.get("visitor_token",""));
            jsonObject.put("evaluate", mark);
            jsonObject.put("session_id", this.session_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpManger.getHttpInstance().sendPostJsonRequest(REQUEST_EVALUATE, jsonObject.toString(), this);

    }

    @Override
    public void onSuccess(Call call, Response response, String json) {
        super.onSuccess(call, response, json);

        if(requestType == 0){
            NyUtiles.showLog(TAG, "评价成功！");
            if(evaluateAlertSatisfied != null){
                evaluateAlertSatisfied.dismiss();
            }
            //通知客服已经
            NyUtiles.showToast((String)SharedUtil.get("feed_back_thank","感谢您的反馈！"));
            // 构造 TextMessage 实例
//            TextMessage textMessage = TextMessage.obtain(mEvaluateContent);
            WaitMessage textMessage = new WaitMessage();
            textMessage.setContent(mEvaluateContent);
            textMessage.setSession_id(session_id);
            textMessage.setGroupId(mTargetId);
            textMessage.setType("evaluate");
            NYAppManger.getInstance().sendPrivateMessage((String) SharedUtil.get("sendUserId",""),textMessage);
            mEvaluateContent = "";
        }
        if (requestType == 1) {
            NyUtiles.showLog(TAG, "挂断成功！");
            finish();
        }
    }

    @Override
    public void onException(Call call, int code, String codeInfo) {
        super.onException(call, code,codeInfo);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        super.onFailure(call, e);
    }

    @Override
    protected void onResume() {
        super.onResume();
        NYAppManger.getInstance().setmUserConversation(true);
        onClickHangUp(fragment);
    }

    private void onClickHangUp(CusConversationFragment conversationFragment) {
        conversationFragment.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestType = 1;
                requestHttp();
//                evaluateAlert();//测试弹出框
            }
        });
    }

    @Override
    public void onHeadLeftButtonClick(View v) {
        popuDialog();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            popuDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(NYAppManger.getInstance().isSuccessStart()){//如果跳转成功，则关闭
            NYAppManger.getInstance().setSuccessStart(false);
            EventBus.getDefault().post(new FinishHomeListenter());
        }
    }

    private void popuDialog() {
        requestType = 2;
        conversitionOffDialog = new ConversitionOffDialog(this);
        conversitionOffDialog.builder()
                .setTitle("提示！")
                .setMsg("确认退出当前界面！")
                .setPositiveButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        requestHttp();
                        conversitionOffDialog.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    //星星评论
    private void evaluateAlertStar() {
        evaluateAlert = new EvaluateAlert(this);
        evaluateAlert.builder()
                .setCancelable(false)
                .setPositiveButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //发起评价接口
//                        NyUtiles.showToast(evaluateAlert.getStarMark() + "");
                        requestType = 0;
                        requestHttp2(evaluateAlert.getStarMark() + "");
                    }
                })
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    //满意度评论
    private void evaluateAlertSatisfied(){
        evaluateAlertSatisfied = new EvaluateAlertSatisfied(this);
        evaluateAlertSatisfied.builder()
                .setCancelable(false)
                .setTitle(this.kf_name)
                .setPositiveButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //发起评价接口
                        NyUtiles.showLog(TAG,evaluateAlertSatisfied.getmStatisfied());
                        requestType = 0;
                        mEvaluateContent = evaluateAlertSatisfied.getmStatisfied();
                        requestHttp2(mEvaluateContent);
                    }
                })
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    //可以废除
    private void insertIncomingMessage(String targetId, String senderUserId) {

        Message.ReceivedStatus receivedStatus = new Message.ReceivedStatus(1);
        receivedStatus.setRead();
        RongIM.getInstance().insertIncomingMessage(Conversation.ConversationType.GROUP, targetId,
                senderUserId, receivedStatus, null, new RongIMClient.ResultCallback<Message>() {
                    @Override
                    public void onSuccess(Message message) {
//                        NyUtiles.showToast("插入消息成功");
                        NyUtiles.showLog(TAG, "插入消息成功");
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
//                        NyUtiles.showToast("插入消息失败");
                        NyUtiles.showLog(TAG, "插入消息失败");
                    }
                });
    }


    @Override
    public void onEventMainThread(EventBusAbstract eventBus) {
        if (eventBus instanceof ConverEvaLisenter) {
            evaluateAlertSatisfied();
        }else if(eventBus instanceof CustomerStateLisenter){
            CustomerStateLisenter customerStateLisenter = (CustomerStateLisenter) eventBus;
            int type = customerStateLisenter.getType();
            if(type == -1){//客服挂断
                SharedUtil.put("CustomerIsLink",false);
                NyUtiles.showLog(TAG,"挂断！");
            }

            if(type == 1){
                boolean isTransfer = customerStateLisenter.ismIsTransfer();
                if(isTransfer){//转接成功
                    this.kf_id = customerStateLisenter.getKf_id();
                    this.session_id = customerStateLisenter.getSession_id();
                    SharedUtil.put("CustomerIsLink",true);//保持客服链接为true，断开为false（进入到聊天界面为链接状态）
                    SharedUtil.put("CONVERSATION",true);//标记会话是否已连接，true代表链接
                    fragment.insertintoinfo("已转接!",this.mTargetId,this.user_id);
                    NyUtiles.showLog(TAG,"已转接");
                }else {//转接中
                    NyUtiles.showLog(TAG,"转接中。。。");
                    SharedUtil.put("CONVERSATION",false);//标记会话是否已连接，false代表未链接
                    fragment.insertintoinfo("转接中。。。",this.mTargetId,this.user_id);
                }
            }

        }
    }

    public String getmTargetId() {
        return mTargetId;
    }

    public String getUser_id() {
        return user_id;
    }
}

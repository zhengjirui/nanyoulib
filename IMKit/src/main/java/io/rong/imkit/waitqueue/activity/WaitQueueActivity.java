package io.rong.imkit.waitqueue.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import io.rong.eventbus.EventBus;
import io.rong.imkit.NYAppManger;
import io.rong.imkit.R;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.Utils.SharedUtil;
import io.rong.imkit.base.BaseActivity;
import io.rong.imkit.events.EventBusAbstract;
import io.rong.imkit.events.FinishHomeListenter;
import io.rong.imkit.events.RongReceiveMsgListener;
import io.rong.imkit.events.WaitingBackLisenter;
import io.rong.imkit.leavingmsg.LeavingMsgActivity;
import io.rong.imkit.messages.WaitMessage;
import io.rong.imkit.view.LoadingView;

public class WaitQueueActivity extends BaseActivity {
    private static final String TAG = "--WaitQueueActivity";

    private int wait_count;//等待的人数
    private LoadingView waiting_num_view;//等待动画
    private TextView waiting_hint_msg_txt;//提示语
    private String group_id;//首页分类id
    private String rule_id;//分配规则id
    private String hint_txt;
    private boolean needHttp;
    private String session_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ny_activity_wait_queue);
        setColorBarAlpha(this, getResources().getColor(R.color.de_title_bg), 10);
        setTitle((String) SharedUtil.get("kefu_name", ""));
        initCreateContent();
    }

    @Override
    public void initCreateContent() {
        waiting_num_view = (LoadingView) findViewById(R.id.waiting_num_view);
        waiting_hint_msg_txt = (TextView) findViewById(R.id.waiting_hint_msg_txt);
        NYAppManger.getInstance().setmUserWaiting(true);

        Intent intent = getIntent();
        group_id = intent.getStringExtra("group_id");
        rule_id = intent.getStringExtra("rule_id");
        session_id = intent.getStringExtra("session_id");
        wait_count = intent.getIntExtra("wait_count", -1);
        NyUtiles.showLog(TAG,"" + "断点3：" + wait_count);
        waiting_num_view.setJumpText(wait_count + "");
        waiting_num_view.setLoadingText("等待人数");

        //提示用语
        hint_txt = (String) SharedUtil.get("queue_rule_msg", "");
        waiting_hint_msg_txt.setText(hint_txt.replace("%", wait_count + ""));
    }

    private void requestHttp() {
        EventBus.getDefault().post(new WaitingBackLisenter(session_id));
    }

    @Override
    public void onHeadLeftButtonClick(View v) {
        needHttp = true;
        finish();
    }

    public void onLeaveMsg(View view) {
        if (group_id == null || group_id.equalsIgnoreCase("")) {
            return;
        }
        Intent intent = new Intent(this, LeavingMsgActivity.class);
        intent.putExtra("group_id", group_id);
        intent.putExtra("session_id", session_id);
        intent.putExtra("leaveType",true);
        startActivity(intent);
        needHttp = true;
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            needHttp = true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!NYAppManger.getInstance().isSuccessStart()){//如果跳转成功，则不关闭；等到聊天界面关闭
            EventBus.getDefault().post(new FinishHomeListenter());
        }
        NYAppManger.getInstance().setmUserWaiting(false);//设置用户在等待界面，跳转的时候也需要
        if(needHttp){
            requestHttp();
        }
    }

    private void startGroupChat(String group_id, String kf_id, String user_id, String session_id,String Kf_name) {

        Map<String, String> map = new HashMap<>();
        map.put("kf_id", kf_id);
        map.put("session_id", session_id);
        map.put("user_id", user_id);
        map.put("Kf_name", Kf_name);
        NYAppManger.getInstance().startGroupChat(group_id, group_id, map);
        int start_menu_status = (int) SharedUtil.get("start_menu_status", -1);
        if(start_menu_status == 2){
            NYAppManger.getInstance().setSuccessStart(true);
        }
        needHttp = false;
        finish();
    }

    @Override
    public void onEventMainThread(EventBusAbstract eventBus) {
        if (eventBus instanceof RongReceiveMsgListener) {
            RongReceiveMsgListener lisenter = (RongReceiveMsgListener) eventBus;
            WaitMessage waitMessage = lisenter.getWaitMessage();
            String type = waitMessage.getType();
            if(type != null && type.equalsIgnoreCase("INFOM")){
                startGroupChat(waitMessage.getGroupId(), waitMessage.getKf_id(),
                        waitMessage.getVisitor_id(), waitMessage.getSession_id(),
                        waitMessage.getKf_name());
            }else if(type != null && type.equalsIgnoreCase("WAIT")){
                String location = waitMessage.getLocation();
                waiting_num_view.setJumpText(location + "");
                waiting_hint_msg_txt.setText(hint_txt.replace("%", location + ""));
            }

        }
    }

}

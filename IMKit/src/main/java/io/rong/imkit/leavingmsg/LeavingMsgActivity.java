package io.rong.imkit.leavingmsg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.Utils.SharedUtil;
import io.rong.imkit.base.BaseActivity;
import io.rong.imkit.events.LeavSuccessListenter;
import io.rong.imkit.request.HttpManger;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.internal.Util;

import static io.rong.imkit.constant.Constant.REQUEST_LEAVEMSG;

public class LeavingMsgActivity extends BaseActivity {

    private String group_id;//首页分类id
    private String name;//留言名字
    private String num;//留言手机号
    private String content;//留言内容
    private EditText et_leaving_name;
    private EditText et_leaving_num;
    private EditText et_leaving_message;
    private String session_id;
    private boolean leaveType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaving_msg);
        setColorBarAlpha(this, getResources().getColor(R.color.de_title_bg), 10);
        String title= (String) SharedUtil.get("kefu_name","喃呱客服");
        setTitle(title);
        initCreateContent();
    }

    @Override
    public void initCreateContent() {
        super.initCreateContent();
        et_leaving_name = (EditText) findViewById(R.id.et_leaving_name);
        et_leaving_num = (EditText) findViewById(R.id.et_leaving_num);
        et_leaving_message = (EditText) findViewById(R.id.et_leaving_message);

        Intent intent = getIntent();
        group_id = intent.getStringExtra("group_id");
        session_id = intent.getStringExtra("session_id");
        leaveType = intent.getBooleanExtra("leaveType",false);
    }

    public void onLeaveMsg(View view){
        name = et_leaving_name.getText().toString();
        num = et_leaving_num.getText().toString();
        content = et_leaving_message.getText().toString();
        if(content == null || content.equalsIgnoreCase("")){
            NyUtiles.showToast("请输入留言内容！");
            return;
        }else if(!NyUtiles.isLength(content)) {
            NyUtiles.showToast("留言内容500字以内！");
            return;
        }

        if(name == null || name.equalsIgnoreCase("")){
            NyUtiles.showToast("请输入姓名！");
            return;
        }else if(!NyUtiles.isNameLength(name)) {
            NyUtiles.showToast("姓名不合法！");
            return;
        }

        if(num == null || num.equalsIgnoreCase("")){
            NyUtiles.showToast("请输入联系方式！");
            return;
        }else if(!NyUtiles.isMobileNum(num)) {
            NyUtiles.showToast("手机号码不合法！");
            return;
        }

        requestHttp();
    }

    private void requestHttp(){
        show();
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("visitor_token", SharedUtil.get("visitor_token",""));
            jsonObj.put("group_id", group_id);
            jsonObj.put("name", name);
            jsonObj.put("contact", num);
            jsonObj.put("content", content);
            if(leaveType){
                jsonObj.put("session_id", session_id);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpManger.getHttpInstance().sendPostJsonRequest(REQUEST_LEAVEMSG, jsonObj.toString(), this);

    }

    @Override
    public void onSuccess(Call call, Response response, String json) {
        super.onSuccess(call, response, json);
        EventBus.getDefault().post(new LeavSuccessListenter());
        finish();
    }

    @Override
    public void onFailure(Call call, IOException e) {
        super.onFailure(call, e);
    }

    @Override
    public void onException(Call call, int code,String codeInfo) {
        super.onException(call, code,codeInfo);
        if(code == 1168){
            NyUtiles.showToast("留言失败，点击重新提交！");
        }
    }
}

package com.nytechnology.nyimlib;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import io.rong.imkit.NYAppManger;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.Utils.StatusBarUtil;
import io.rong.imkit.base.BaseActivity;
import io.rong.imkit.callback.HttpLisenter;
import io.rong.imkit.constant.Constant;
import io.rong.imkit.home.activity.HomeActivity;
import io.rong.imkit.request.HttpManger;
import okhttp3.Call;
import okhttp3.Response;

import static io.rong.imkit.constant.Constant.LOGIN_VERTIFY;


public class MainActivity extends BaseActivity implements HttpLisenter{
    private final String TAG = "--MainActivity";
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private LinearLayout ll_updata_address;
    private EditText et_ip_address;
    private EditText et_ip_address_type;
    private Button find_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ny);
        StatusBarUtil.setTransparent(this);
        initCreateContent();
    }

    @Override
    public void initCreateContent () {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        find_service = (Button) findViewById(R.id.find_service);
        ll_updata_address = (LinearLayout) findViewById(R.id.ll_updata_address);
        et_ip_address = (EditText) findViewById(R.id.et_ip_address);
        et_ip_address_type = (EditText) findViewById(R.id.et_ip_address_type);
        find_service.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(View.GONE == ll_updata_address.getVisibility()){
                    ll_updata_address.setVisibility(View.VISIBLE);
                }else {
                    ll_updata_address.setVisibility(View.GONE);
                }
                return true;
            }
        });
    }

    public void onClickStartHome(View view){
        if(et1.getText().toString().equalsIgnoreCase("") || et2.getText().toString().equalsIgnoreCase("")
                || et3.getText().toString().equalsIgnoreCase("") || et4.getText().toString().equalsIgnoreCase("")
                || et5.getText().toString().equalsIgnoreCase("") || et_ip_address.getText().toString().trim().equalsIgnoreCase("")
                || et_ip_address_type.getText().toString().equalsIgnoreCase("")){
            NyUtiles.showToast("请检查输入框");
            return;
        }
        String ipType = et_ip_address_type.getText().toString().trim();
        Constant.HOST = et_ip_address.getText().toString().trim();
        switch (ipType){
            case "1"://开发
                requestHttp(et1.getText().toString(),et2.getText().toString());
                break;
            case "2"://测试
                requestHttp("c68d893a73916d02d06eb0d8bff3544783745b46","19e5059c5e0867c6edb78e167fb8c934648557b54f7a3e3b14ec88e5c1408e63df3f15690bf936f8");
                break;
            case "3"://生产
                requestHttp("61a3407c1055a086b003311752081989b8feeff8","d02dd9fe42ad7a61c85f191cc6592e76f4cd710b4f7a3e3b14ec88e5c1408e63df3f15690bf936f8");
                break;
        }
    }

    public void requestHttp(String name, String psd) {
        show();
        Map<String, String> tm = new TreeMap<String, String>();
        tm.put("appId", name);
        tm.put("appPsd", psd);
        String sign = NyUtiles.encodeToString(tm);
        NyUtiles.showLog(TAG,sign);

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("appId", name);
            jsonObj.put("sign", sign);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpManger.getHttpInstance().sendPostJsonRequest(LOGIN_VERTIFY, jsonObj.toString(), this);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        Log.e(TAG, "onFailure");
        Log.e(TAG, e.toString());
        super.onFailure(call,e);
    }

    @Override
    public void onSuccess(Call call, Response response, String json) {
        super.onSuccess(call, response, json);
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);


//
//
        String ipType = et_ip_address_type.getText().toString().trim();
        switch (ipType){
            case "1"://开发
                intent.putExtra("appId",et1.getText().toString());
                break;
            case "2"://测试
                intent.putExtra("appId","c68 d893a73916d02d06eb0d8bff3544783745b46");
                break;
            case "3"://生产
                intent.putExtra("appId","61a3407c1055a086b003311752081989b8feeff8");
                break;
        }
        intent.putExtra("userId",et3.getText().toString());
        intent.putExtra("userImgUrl","");
        intent.putExtra("userName",et3. getText().toString());
        intent.putExtra("appAccessName",getPackageName());
//        intent.putExtra("userParameters",et4.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onException(Call call, int code, String codeInfo) {
        super.onException(call, code, codeInfo);
        if(code == 1004){
            NyUtiles.showToast(codeInfo);
        }

    }
}

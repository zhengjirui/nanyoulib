package io.rong.imkit.request;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import io.rong.imkit.RongIM;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.callback.HttpLisenter;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.message.TextMessage;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static io.rong.imkit.constant.Constant.HOST;


/**
 * Created by 18513 on 2017/12/13.
 */

public class HttpManger {
    private final String TAG = "HttpManger";

    private final int CONNECTTIMEOUT = 15;//链接超时
    private final int READTIMEOUT = 15;//读取时间
    private boolean WHILEREQUEST = true;

    //http://blog.csdn.net/qq_31694651/article/details/52254188

    ////构建字符串请求体
    public static final MediaType TEXT = MediaType.parse("text/plain; charset=utf-8");

    // //构建字节请求体和构建文件请求体
    public static final MediaType STREAM = MediaType.parse("application/octet-stream");

    //post上传json
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    private static HttpManger httpManger = null;
    private OkHttpClient mHttpClient = new OkHttpClient();
    private HttpLisenter httpLisenter = null;
    private MyCall myCall = null;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (httpLisenter != null) {
                MyCall call = (MyCall) msg.obj;

                switch (msg.what) {
                    case 0:
                        try {
                            JSONObject jsonObject = new JSONObject(call.getJson());
                            if (call.getResponse().isSuccessful()) {
                                String code = jsonObject.getString("code");
                                if (code.equalsIgnoreCase("1000")) {
                                    if(call.getJson().contains("data")){
                                        JSONObject data = jsonObject.getJSONObject("data");

                                        httpLisenter.onSuccess(call.getCall(), call.getResponse(), data.toString());
                                    }else {
                                        httpLisenter.onSuccess(call.getCall(), call.getResponse(), "");
                                    }
                                } else if (code.equalsIgnoreCase("1001")) {
                                    //参数错误
                                    String error1001 = jsonObject.getString("error");
                                    NyUtiles.showLog(TAG, error1001 + "1001");
                                    httpLisenter.onException(call.getCall(), -1,"1001");
                                } else if(code.equalsIgnoreCase("1002")){
                                    httpLisenter.onException(call.getCall(), -1,"1002");
                                    NyUtiles.showLog(TAG, "用户登录失败");
                                } else if(code.equalsIgnoreCase("1003")){
                                    httpLisenter.onException(call.getCall(), -1,"1003");
                                    NyUtiles.showLog(TAG, "签名验证失败");
                                }else if(code.equalsIgnoreCase("1004")){
                                    String codeMsg = jsonObject.getString("msg");
                                    httpLisenter.onException(call.getCall(), 1004,codeMsg);
                                    NyUtiles.showLog(TAG, codeMsg);
                                }else if (code.equalsIgnoreCase("1050")) {
                                    httpLisenter.onException(call.getCall(), -1,"1050");
                                    NyUtiles.showLog(TAG, "参数验证不通过");
                                } else if (code.equalsIgnoreCase("1053")) {
                                    httpLisenter.onException(call.getCall(), -1,"1053");
                                    NyUtiles.showLog(TAG, "参数不正确");
                                } else if (code.equalsIgnoreCase("1054")) {
                                    httpLisenter.onException(call.getCall(), -1,"1054");
                                    NyUtiles.showLog(TAG, "Token参数有误");
                                } else if (code.equalsIgnoreCase("1153")) {
                                    httpLisenter.onException(call.getCall(), -1,"1153");
                                    NyUtiles.showLog(TAG, "将客服拉入通道失败1153");
                                } else if (code.equalsIgnoreCase("1168")) {
                                    //留言失败
                                    String error = jsonObject.getString("error");
//                                    httpLisenter.onSuccess(call.getCall(), call.getResponse(), error + "!");
                                    httpLisenter.onException(call.getCall(),1168,"");
                                    NyUtiles.showLog(TAG, "留言失败");
                                } else if (code.equalsIgnoreCase("1165")) {
                                    httpLisenter.onException(call.getCall(), Integer.valueOf(code),"");
                                    NyUtiles.showLog(TAG, "暂无在线客服服务！");
                                } else if (code.equalsIgnoreCase("1169")) {
                                    httpLisenter.onException(call.getCall(), -1,"1169");
                                    NyUtiles.showLog(TAG, "退出失败！");
                                }else if (code.equalsIgnoreCase("1178")) {
                                    httpLisenter.onException(call.getCall(), Integer.valueOf(code),"");
                                    NyUtiles.showLog(TAG, "该分组暂无成员服务！");
                                } else if (code.equalsIgnoreCase("1174")) {
                                    httpLisenter.onException(call.getCall(), -1,"1174");
                                    NyUtiles.showLog(TAG, "通道失败！");
                                }else if (code.equalsIgnoreCase("1179")) {
                                    httpLisenter.onException(call.getCall(), -1,"1179");
                                    NyUtiles.showLog(TAG, "通道失败！");
                                } else if (code.equalsIgnoreCase("1191")) {
                                    httpLisenter.onException(call.getCall(), -1,"1191");
                                    NyUtiles.showLog(TAG, "访客会话信息获取失败！");
                                } else {
//                                    NyUtiles.showToast("code = " + code);
                                    httpLisenter.onException(call.getCall(), Integer.valueOf(code),"0000");//未知异常
                                }

                            } else {
                                httpLisenter.onException(call.getCall(), call.getResponse().code(),"0001");//请求失败
                                NyUtiles.showLog(TAG, jsonObject.toString());
//                                NyUtiles.showToast(jsonObject.toString());
                            }
                        } catch (JSONException e) {
                            httpLisenter.onException(call.getCall(), -1,"0002");//数据解析出错
                            NyUtiles.showLog(TAG,"数据解析出错");
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        httpLisenter.onFailure(call.getCall(), call.getE());
                        break;
                }
            } else {
                throw new NullPointerException();
            }
        }
    };

    private HttpManger() {
        mHttpClient.newBuilder()
                .connectTimeout(CONNECTTIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READTIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    public static HttpManger getHttpInstance() {
        if (httpManger == null) {
            httpManger = new HttpManger();
        }
        return httpManger;
    }

    public void removeCallbacksAndMessages() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void cancelAllRequest() {
        if (mHttpClient != null) {
            mHttpClient.dispatcher().cancelAll();
            mHttpClient.connectionPool().evictAll();
        }
    }

    private RequestBody createRequestBody(MediaType JSON, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        return body;
    }

    private Request createRequest(String url, MediaType type, String json) {
        Request request = new Request.Builder()
                .url(url)
//                .method("POST" ,this.createRequestBody(type,json))
                .post(this.createRequestBody(type, json))
                .build();
        return request;
    }

    private void enqueue(final Request request) {
        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                NyUtiles.showLog(TAG,e.toString());
                myCall = new MyCall(call, e);
                Message ms = new Message();
                ms.what = 1;
                ms.obj = myCall;
                handler.sendMessage(ms);
                if(e instanceof SocketTimeoutException || e instanceof ConnectException){
                    cancelAllRequest();
                }
                if(e instanceof SocketException && WHILEREQUEST){
                    WHILEREQUEST = false;
                    cancelAllRequest();
                    mHttpClient.newCall(request).enqueue(this);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                WHILEREQUEST = true;
                Log.e("-----", json);
                myCall = new MyCall(call, response, json);
                Message ms = new Message();
                ms.what = 0;
                ms.obj = myCall;
                handler.sendMessage(ms);
            }
        });
    }

    public void sendPostJsonRequest(String url, String json, HttpLisenter httpLisenter) {
        if (url != null && !url.equalsIgnoreCase("")
                && json != null && !json.equalsIgnoreCase("")) {
            this.httpLisenter = httpLisenter;
            Request request = createRequest(HOST + url, JSON, json);
            enqueue(request);
        } else {
            Log.e(TAG, "请检查url和json");
        }
    }

    public static class MyCall {
        private Call call = null;

        private IOException e = null;

        private Response response = null;

        private String json = "";

        public MyCall(Call call, IOException e) {
            this.call = call;
            this.e = e;
        }

        public MyCall(Call call, Response response, String json) {
            this.call = call;
            this.response = response;
            this.json = json;
        }

        public Call getCall() {
            return call;
        }

        public void setCall(Call call) {
            this.call = call;
        }

        public IOException getE() {
            return e;
        }

        public void setE(IOException e) {
            this.e = e;
        }

        public Response getResponse() {
            return response;
        }

        public void setResponse(Response response) {
            this.response = response;
        }

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }
    }

}

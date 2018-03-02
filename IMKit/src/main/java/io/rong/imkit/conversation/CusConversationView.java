package io.rong.imkit.conversation;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.rong.common.RLog;
import io.rong.imkit.NYAppManger;
import io.rong.imkit.RongIM;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.Utils.SharedUtil;
import io.rong.imkit.callback.HttpLisenter;
import io.rong.imkit.home.activity.HomeActivity;
import io.rong.imkit.home.bean.MsgTypeStaffBean;
import io.rong.imkit.mention.RongMentionManager;
import io.rong.imkit.messages.EmojiTextMessage;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.request.HttpManger;
import io.rong.imkit.waitqueue.activity.WaitQueueActivity;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import io.rong.message.InformationNotificationMessage;
import io.rong.message.TextMessage;
import okhttp3.Call;
import okhttp3.Response;

import static io.rong.imkit.constant.Constant.REQUEST_CONVERCATION;

/**
 * Created by 18513 on 2018/1/3.
 */

public class CusConversationView extends CusConversationFragment implements HttpLisenter{
    private static final String TAG = "--CusConversationView";

    private String session_id = "";
    private UserInfo info;

    public void insertintoinfo(String textInfo,String targetId,String userId) {
        MessageContent messageContent = InformationNotificationMessage.obtain(textInfo);
        RongIM.getInstance().insertIncomingMessage(Conversation.ConversationType.GROUP,
                targetId,userId,new Message.ReceivedStatus(1),messageContent,null);
    }

    @Override
    public void onPluginToggleClick(View v, ViewGroup extensionBoard) {
        //验证是否跟客服链接
        if(vertifyConnect()){
            return;
        }
        super.onPluginToggleClick(v, extensionBoard);

    }

    @Override
    public void onPluginClicked(IPluginModule pluginModule, int position) {
        //验证是否跟客服链接
        if(vertifyConnect()){
            return;
        }
        super.onPluginClicked(pluginModule, position);
    }

    @Override
    public void onSendToggleClick(View v, String text1) {
        //验证是否跟客服链接
        if(vertifyConnect()){
            return;
        }


        String text = regMatcher(text1);//正则过滤
        if (!text.equalsIgnoreCase("") && !TextUtils.isEmpty(text) && !TextUtils.isEmpty(text.trim())) {
            TextMessage textMessage = TextMessage.obtain(text);
            textMessage.setExtra(getSession_id());
            if (getInfo() != null) {
                textMessage.setUserInfo(getInfo());
            }

            MentionedInfo mentionedInfo = RongMentionManager.getInstance().onSendButtonClick();
            if (mentionedInfo != null) {
                textMessage.setMentionedInfo(mentionedInfo);
            }

            Message message = Message.obtain(this.mTargetId, this.mConversationType, textMessage);
            RongIM.getInstance().sendMessage(message, (String) null, (String) null, (IRongCallback.ISendMessageCallback) null);
        } else {
            RLog.e("CusConversationFragment", "text content must not be null");
        }
    }

    private boolean vertifyConnect(){
        if(!(boolean)SharedUtil.get("CONVERSATION",false)){
            ConversationActivity context = (ConversationActivity) getContext();
            insertintoinfo("转接中,请稍后！",context.getmTargetId(),context.getUser_id());
            return true;
        }

        if(!(boolean)SharedUtil.get("CustomerIsLink",false)){
            requestHttp();
            return true;
        }

        return false;
    }

    public String regMatcher(String text){
        Pattern wp = Pattern.compile("<\\?(?:php)*[^>]+?>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = wp.matcher(text);
        String result = m.replaceAll("");
        return result;
    }

    public void requestHttp() {
        if (NYAppManger.getInstance().isRongConnectStateLisenter()) {
            JSONObject jsonObj = new JSONObject();
            try {
                jsonObj.put("visitor_token", SharedUtil.get("visitor_token", ""));
                jsonObj.put("group_id", SharedUtil.get("group_id", ""));
                jsonObj.put("visitor_name", SharedUtil.get("visitor_name", ""));
                jsonObj.put("group_name", SharedUtil.get("group_name", ""));
                jsonObj.put("rule_id", SharedUtil.get("rule_id", ""));
                jsonObj.put("greeting", SharedUtil.get("greeting", ""));
                jsonObj.put("app_sign", (int) SharedUtil.get("app_sign", -1));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            HttpManger.getHttpInstance().sendPostJsonRequest(REQUEST_CONVERCATION, jsonObj.toString(), this);
        }else {
            NyUtiles.showLog(TAG, "网络链接不稳定！");
            NyUtiles.showToast("网络链接不稳定！");
        }
    }

    private String getEmotion(String content) {
        Pattern pattern = Pattern.compile("\\s*\\uD83D\\uDE00|\\uD83D\\uDE01|\\uD83D\\uDE02|\\uD83D\\uDE0A");
        Matcher matcher = pattern.matcher(content);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String replace = matcher.group();
            NyUtiles.showLog("---replace", replace.substring(0, 1));
            try {
                Class nyRegExpBean = Class.forName("io.rong.imkit.conversation.NyEmojiBean");
                Method method = nyRegExpBean.getDeclaredMethod("get" + replace);
                Object obj = nyRegExpBean.newInstance();
                matcher.appendReplacement(sb, (String) method.invoke(obj));
            } catch (Exception e) {
                e.printStackTrace();
            }
//            int inthex = Integer.parseInt(matcher.group(1), 16);
//            String s = String.valueOf(Character.toChars(inthex));
//            NyUtiles.showLog("--s--",s);
//            String strNoBlank = matcher.replaceAll("00");
//            matcher.appendReplacement(sb,"--" );
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public String getEmojiStringByUnicode(int unicode) {
        return new String(Character.toChars(unicode));
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onSuccess(Call call, Response response, String json) {
        ConversationActivity context = (ConversationActivity) getContext();
        Gson gson = new Gson();
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
                        insertintoinfo((String) SharedUtil.get("msg_type2_msg", ""),context.getmTargetId(),context.getUser_id());
                        return;
                    }
                }
            }
            Intent intent = new Intent(context, WaitQueueActivity.class);
            intent.putExtra("visitor_token", (String) SharedUtil.get("visitor_token", ""));
            intent.putExtra("group_id", (String) SharedUtil.get("group_id", ""));
            intent.putExtra("rule_id", (String) SharedUtil.get("rule_id", ""));
            intent.putExtra("wait_count", wait_count);
            intent.putExtra("session_id", session_id);
            NyUtiles.showLog(TAG,"" + "断点2：" + wait_count);
            startActivity(intent);
            context.finish();
        }else if(type.equalsIgnoreCase("INFOM")){
            String groupId = msgTypeStaffBean.getGroupId();
            String kf_id = msgTypeStaffBean.getKf_id();
            String kf_name = msgTypeStaffBean.getKf_name();
            String session_id = msgTypeStaffBean.getSession_id();
            String visitor_id = msgTypeStaffBean.getVisitor_id();
            startGroupChat(groupId,kf_id,visitor_id,session_id,kf_name);
        }

//        insertintoinfo("已链接！",context.getmTargetId(),context.getUser_id());
    }

    private void startGroupChat(String group_id, String kf_id, String user_id, String session_id,String Kf_name) {

        Map<String, String> map = new HashMap<>();
        map.put("kf_id", kf_id);
        map.put("session_id", session_id);
        map.put("user_id", user_id);
        map.put("Kf_name", Kf_name);
        NYAppManger.getInstance().startGroupChat(group_id, group_id, map);
        SharedUtil.put("CustomerState",true);
    }

    @Override
    public void onException(Call call, int code, String infoCode) {
        ConversationActivity context = (ConversationActivity) getContext();
        if (code == 1165 ) {
            int msg_rule_status = (int) SharedUtil.get("msg_rule_status",-1);
            if(msg_rule_status ==1){
                insertintoinfo((String) SharedUtil.get("msg_type1_msg", ""),context.getmTargetId(),context.getUser_id());
            }
        }
        if(code == 1178){
            int msg_rule_status = (int) SharedUtil.get("msg_rule_status",-1);
            String msg_type2_status = (String) SharedUtil.get("msg_type2_status","");
            if(msg_rule_status ==1 && !msg_type2_status.equalsIgnoreCase("") && msg_type2_status.equalsIgnoreCase("1")){
                insertintoinfo((String) SharedUtil.get("msg_type2_msg", ""),context.getmTargetId(),context.getUser_id());
            }
        }
    }
}

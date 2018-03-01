package io.rong.imkit.messages;

import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.rong.common.ParcelUtils;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;

/**
 * Created by Beyond on 2016/12/5.
 */

@MessageTag(value = "NY:SYSTEM", flag = MessageTag.ISCOUNTED | MessageTag.ISPERSISTED)
public class WaitMessage extends MessageContent {
    private final static String TAG = "WaitMessage";

    private String content;
    private String kf_id;
    private String kf_name;
    private String session_id;
    private String visitor_id;
    private String type;
    private String groupId;
    private String location;

    private String group_id;
    private String visitor_name;
    private String group_name;
    private String rule_id;
    private String greeting;

    /**
     * 读取接口，目的是要从Parcel中构造一个实现了Parcelable的类的实例处理。
     */
    public static final Creator<WaitMessage> CREATOR = new Creator<WaitMessage>() {

        @Override
        public WaitMessage createFromParcel(Parcel source) {
            return new WaitMessage(source);
        }

        @Override
        public WaitMessage[] newArray(int size) {
            return new WaitMessage[size];
        }
    };

    /**
     * 将本地消息对象序列化为消息数据。
     *
     * @return 消息数据。
     */
    @Override
    public byte[] encode() {

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("content", getEmotion(getContent()));

            if (!TextUtils.isEmpty(getType()))
                jsonObj.put("type", getType());

            if (!TextUtils.isEmpty(getGroupId()))
                jsonObj.put("groupId", getGroupId());

            if (!TextUtils.isEmpty(getLocation()))
                jsonObj.put("location", getLocation());

            if (!TextUtils.isEmpty(getKf_id()))
                jsonObj.put("kf_id", getKf_id());

            if (!TextUtils.isEmpty(getKf_name()))
                jsonObj.put("kf_name", getKf_name());

            if (!TextUtils.isEmpty(getSession_id()))
                jsonObj.put("session_id", getSession_id());

            if(!TextUtils.isEmpty(getVisitor_id()))
                jsonObj.put("visitor_id", getVisitor_id());




            if(!TextUtils.isEmpty(getGroup_id()))
                jsonObj.put("group_id", getGroup_id());

            if(!TextUtils.isEmpty(getVisitor_name()))
                jsonObj.put("visitor_name", getVisitor_name());

            if(!TextUtils.isEmpty(getGroup_name()))
                jsonObj.put("group_name", getGroup_name());

            if(!TextUtils.isEmpty(getRule_id()))
                jsonObj.put("rule_id", getRule_id());

            if(!TextUtils.isEmpty(getGreeting()))
                jsonObj.put("greeting", getGreeting());

            if (this.getJSONUserInfo() != null)
                jsonObj.putOpt("user", getJSONUserInfo());

            if (this.getJsonMentionInfo() != null) {
                jsonObj.putOpt("mentionedInfo", getJsonMentionInfo());
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSONException " + e.getMessage());
        }

        try {
            return jsonObj.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Android 的表情unicode跟ios不一样，为了做到两个平台统一，android 这边设置了表情映射，根据unicode来映射具体的图片。
     *
     */
    private String getEmotion(String content) {

        Pattern pattern = Pattern.compile("\\[/u([0-9A-Fa-f]+)\\]");
        Matcher matcher = pattern.matcher(content);

        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            int inthex = Integer.parseInt(matcher.group(1), 16);
            matcher.appendReplacement(sb, String.valueOf(Character.toChars(inthex)));
        }

        matcher.appendTail(sb);

        return sb.toString();
    }

    public WaitMessage() {
    }

    public static WaitMessage obtain(String text) {
        WaitMessage model = new WaitMessage();
        model.setContent(text);
        return model;
    }

    public WaitMessage(byte[] data) {
        String jsonStr = null;
        try {
            jsonStr = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObj = new JSONObject(jsonStr);

            if (jsonObj.has("content"))
                setContent(jsonObj.optString("content"));

            if (jsonObj.has("kf_id"))
                setKf_id(jsonObj.optString("kf_id"));

            if (jsonObj.has("kf_name"))
                setKf_name(jsonObj.optString("kf_name"));

            if (jsonObj.has("session_id"))
                setSession_id(jsonObj.optString("session_id"));

            if (jsonObj.has("visitor_id"))
                setVisitor_id(jsonObj.optString("visitor_id"));



            if (jsonObj.has("group_id"))
                setGroup_id(jsonObj.optString("group_id"));

            if (jsonObj.has("visitor_name"))
                setVisitor_name(jsonObj.optString("visitor_name"));

            if (jsonObj.has("group_name"))
                setGroup_name(jsonObj.optString("group_name"));

            if (jsonObj.has("rule_id"))
                setRule_id(jsonObj.optString("rule_id"));

            if (jsonObj.has("greeting"))
                setGreeting(jsonObj.optString("greeting"));


            if (jsonObj.has("type"))
                setType(jsonObj.optString("type"));

            if (jsonObj.has("groupId"))
                setGroupId(jsonObj.optString("groupId"));

            if (jsonObj.has("location"))
                setLocation(jsonObj.optString("location"));

            if (jsonObj.has("user")) {
                setUserInfo(parseJsonToUserInfo(jsonObj.getJSONObject("user")));
            }

            if (jsonObj.has("mentionedInfo")) {
                setMentionedInfo(parseJsonToMentionInfo(jsonObj.getJSONObject("mentionedInfo")));
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSONException " + e.getMessage());
        }

    }

    /**
     * 描述了包含在 Parcelable 对象排列信息中的特殊对象的类型。
     *
     * @return 一个标志位，表明Parcelable对象特殊对象类型集合的排列。
     */
    public int describeContents() {
        return 0;
    }

    /**
     * 将类的数据写入外部提供的 Parcel 中。
     *
     * @param dest  对象被写入的 Parcel。
     * @param flags 对象如何被写入的附加标志，可能是 0 或 PARCELABLE_WRITE_RETURN_VALUE。
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        ParcelUtils.writeToParcel(dest, getContent());
        ParcelUtils.writeToParcel(dest, getKf_id());
        ParcelUtils.writeToParcel(dest, getKf_name());
        ParcelUtils.writeToParcel(dest, getSession_id());
        ParcelUtils.writeToParcel(dest, getVisitor_id());
        ParcelUtils.writeToParcel(dest, getType());
        ParcelUtils.writeToParcel(dest, getGroupId());
        ParcelUtils.writeToParcel(dest, getLocation());

        ParcelUtils.writeToParcel(dest, getGroup_id());
        ParcelUtils.writeToParcel(dest, getVisitor_name());
        ParcelUtils.writeToParcel(dest, getGroup_name());
        ParcelUtils.writeToParcel(dest, getRule_id());
        ParcelUtils.writeToParcel(dest, getGreeting());
        ParcelUtils.writeToParcel(dest, getUserInfo());
        ParcelUtils.writeToParcel(dest, getMentionedInfo());
    }

    /**
     * 构造函数。
     *
     * @param in 初始化传入的 Parcel。
     */
    public WaitMessage(Parcel in) {
        setContent(ParcelUtils.readFromParcel(in));
        setKf_id(ParcelUtils.readFromParcel(in));
        setKf_name(ParcelUtils.readFromParcel(in));
        setSession_id(ParcelUtils.readFromParcel(in));
        setVisitor_id(ParcelUtils.readFromParcel(in));
        setType(ParcelUtils.readFromParcel(in));
        setGroupId(ParcelUtils.readFromParcel(in));
        setLocation(ParcelUtils.readFromParcel(in));
        setGroup_id(ParcelUtils.readFromParcel(in));
        setVisitor_name(ParcelUtils.readFromParcel(in));
        setGroup_name(ParcelUtils.readFromParcel(in));
        setRule_id(ParcelUtils.readFromParcel(in));
        setGreeting(ParcelUtils.readFromParcel(in));
        setUserInfo(ParcelUtils.readFromParcel(in, UserInfo.class));
        setMentionedInfo(ParcelUtils.readFromParcel(in, MentionedInfo.class));
    }

    /**
     * 构造函数。
     *
     *
     * @param content 文字消息的内容。
     */
    public WaitMessage(String content) {
        this.setContent(content);
    }

    /**
     * 获取文字消息的内容。
     *
     * @return 文字消息的内容。
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文字消息的内容。
     *
     * @param content 文字消息的内容。
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKf_id() {
        return kf_id;
    }

    public void setKf_id(String kf_id) {
        this.kf_id = kf_id;
    }

    public String getKf_name() {
        return kf_name;
    }

    public void setKf_name(String kf_name) {
        this.kf_name = kf_name;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(String visitor_id) {
        this.visitor_id = visitor_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getRule_id() {
        return rule_id;
    }

    public void setRule_id(String rule_id) {
        this.rule_id = rule_id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public List<String> getSearchableWord() {
        List<String> words = new ArrayList<>();
        words.add(content);
        return words;
    }
}

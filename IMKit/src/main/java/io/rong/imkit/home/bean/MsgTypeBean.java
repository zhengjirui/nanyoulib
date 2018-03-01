package io.rong.imkit.home.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18513 on 2017/12/14.
 */

public class MsgTypeBean {

    private List<MsgTypeGvBean> msgTypeGvBeenList = new ArrayList<>();

    private MsgTypeHeaderBean msgTypeHeaderBean = new MsgTypeHeaderBean();

    public List<MsgTypeGvBean> getMsgTypeGvBeenList() {
        return msgTypeGvBeenList;
    }

    public void setMsgTypeGvBeenList(List<MsgTypeGvBean> msgTypeGvBeenList) {
        this.msgTypeGvBeenList.addAll(msgTypeGvBeenList);
    }

    public MsgTypeHeaderBean getMsgTypeHeaderBean() {
        return msgTypeHeaderBean;
    }

    public void setMsgTypeHeaderBean(MsgTypeHeaderBean msgTypeHeaderBean) {
        this.msgTypeHeaderBean = msgTypeHeaderBean;
    }

    public static class MsgTypeHeaderBean{
        private String header_img_url = "";
        private String header_text = "";

        public String getHeader_img_url() {
            return header_img_url;
        }

        public void setHeader_img_url(String header_img_url) {
            this.header_img_url = header_img_url;
        }

        public String getHeader_text() {
            return header_text;
        }

        public void setHeader_text(String header_text) {
            this.header_text = header_text;
        }
    }

    public static class MsgTypeGvBean{
        private String type_img_url = "";
        private String type_text = "";
        private String group_id = "";
        private String msg = "";
        private String rule_id = "";

        public String getType_img_url() {
            return type_img_url;
        }

        public void setType_img_url(String type_img_url) {
            this.type_img_url = type_img_url;
        }

        public String getType_text() {
            return type_text;
        }

        public void setType_text(String type_text) {
            this.type_text = type_text;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getRule_id() {
            return rule_id;
        }

        public void setRule_id(String rule_id) {
            this.rule_id = rule_id;
        }
    }


}

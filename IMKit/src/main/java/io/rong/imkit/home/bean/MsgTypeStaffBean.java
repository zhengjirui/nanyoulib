package io.rong.imkit.home.bean;

import java.io.Serializable;

/**
 * Created by 18513 on 2017/12/18.
 */

public class MsgTypeStaffBean implements Serializable{

    /**
     * groupId : KF1001123456qwert
     * customerToken : ETVcdU+oMDqDjtyxEZsahMvT5UbmUT0JbYGWanF3CV69HZpWEMXyMeW6tAXIpxcOO+qTavKEfjmms2tPTiBKjrkm2LdZbLtT
     */

    private String groupId = "";
    private String customerToken = "";
    private int wait_count = 0;
    private int req_type = 0;
    private String kf_id = "";
    private String customerId = "";
    private String kf_name = "";
    private String session_id = "";
    private String visitor_id = "";
    private String type = "";

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCustomerToken() {
        return customerToken;
    }

    public void setCustomerToken(String customerToken) {
        this.customerToken = customerToken;
    }

    public int getWait_count() {
        return wait_count;
    }

    public void setWait_count(int wait_count) {
        this.wait_count = wait_count;
    }

    public String getKf_id() {
        return kf_id;
    }

    public void setKf_id(String kf_id) {
        this.kf_id = kf_id;
    }

    public int getReq_type() {
        return req_type;
    }

    public void setReq_type(int req_type) {
        this.req_type = req_type;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

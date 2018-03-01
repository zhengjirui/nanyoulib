package io.rong.imkit.events;

/**
 * Created by 18513 on 2018/1/22.
 */

public class ConversationBackLisenter extends EventBusAbstract {

    private String kf_id;
    private String mTargetId;
    private String session_id;

    public ConversationBackLisenter(String kf_id, String mTargetId,String session_id) {
        this.kf_id = kf_id;
        this.mTargetId = mTargetId;
        this.session_id = session_id;
    }

    public String getKf_id() {
        return kf_id;
    }

    public void setKf_id(String kf_id) {
        this.kf_id = kf_id;
    }

    public String getmTargetId() {
        return mTargetId;
    }

    public void setmTargetId(String mTargetId) {
        this.mTargetId = mTargetId;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}

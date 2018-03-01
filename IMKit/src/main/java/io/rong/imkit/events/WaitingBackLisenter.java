package io.rong.imkit.events;

/**
 * Created by 18513 on 2018/1/22.
 */

public class WaitingBackLisenter extends EventBusAbstract {
    private String session_id = "";

    public WaitingBackLisenter(String session_id) {
        this.session_id = session_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}

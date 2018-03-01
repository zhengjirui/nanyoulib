package io.rong.imkit.events;

/**
 * Created by 18513 on 2018/1/16.
 */

public class RongConnectLisenter extends EventBusAbstract{

    private boolean mConnectState;

    public RongConnectLisenter(boolean mConnectState) {
        this.mConnectState = mConnectState;
    }

    public boolean getmConnectState() {
        return mConnectState;
    }
}

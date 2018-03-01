package io.rong.imkit.events.lisenter;

import io.rong.eventbus.EventBus;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.events.RongConnectLisenter;
import io.rong.imlib.RongIMClient;

/**
 * Created by 18513 on 2018/1/15.
 */

public class RongConnectionStatusListener implements RongIMClient.ConnectionStatusListener {
    private final String TAG = "RongConnectionStatusListener";



    @Override
    public void onChanged(ConnectionStatus connectionStatus) {
        switch (connectionStatus){

            case CONNECTED://连接成功。
                NyUtiles.showLog(TAG,"链接成功！");
                EventBus.getDefault().post(new RongConnectLisenter(true));
                break;
            case DISCONNECTED://断开连接。
                NyUtiles.showLog(TAG,"断开连接！");
                EventBus.getDefault().post(new RongConnectLisenter(false));
                break;
            case CONNECTING://连接中。
                NyUtiles.showLog(TAG,"连接中！");
                EventBus.getDefault().post(new RongConnectLisenter(false));
                break;
            case NETWORK_UNAVAILABLE://网络不可用。
                NyUtiles.showLog(TAG,"网络不可用！");
//                NyUtiles.showToast("网络不可用！");
                EventBus.getDefault().post(new RongConnectLisenter(false));
                break;
            case KICKED_OFFLINE_BY_OTHER_CLIENT://用户账户在其他设备登录，本机会被踢掉线
                NyUtiles.showLog(TAG,"用户账户在其他设备登录，需要退出重新登录！");
//                NyUtiles.showToast("用户账户在其他设备登录，需要退出重新登录！");
                EventBus.getDefault().post(new RongConnectLisenter(false));
                break;
        }

    }
}

package io.rong.imkit.events;

import io.rong.imkit.messages.WaitMessage;

/**
 * Created by 18513 on 2018/1/16.
 */

public class RongReceiveMsgListener extends EventBusAbstract{

    private WaitMessage waitMessage;//等待界面的消息通知和弹出评价的消息通知

    public RongReceiveMsgListener(WaitMessage waitMessage) {
        this.waitMessage = waitMessage;
    }

    public WaitMessage getWaitMessage() {
        return waitMessage;
    }

    public void setWaitMessage(WaitMessage waitMessage) {
        this.waitMessage = waitMessage;
    }
}

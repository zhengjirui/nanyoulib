package io.rong.imkit.events.lisenter;

import org.json.JSONObject;

import io.rong.eventbus.EventBus;
import io.rong.imkit.NYAppManger;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.Utils.SharedUtil;
import io.rong.imkit.events.ConverEvaLisenter;
import io.rong.imkit.events.CustomerStateLisenter;
import io.rong.imkit.events.RongReceiveMsgListener;
import io.rong.imkit.messages.WaitMessage;
import io.rong.imkit.widget.provider.CustomerServiceConversationProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import io.rong.message.TextMessage;

/**
 * Created by 18513 on 2018/1/12.
 */

public class RongReceiveMessage implements RongIMClient.OnReceiveMessageListener {

    /**
     * 收到消息的处理。
     *
     * @param message 收到的消息实体。
     * @param left    剩余未拉取消息数目。
     * @return 收到消息是否处理完成，true 表示自己处理铃声和后台通知，false 走融云默认处理方式。
     */
    @Override
    public boolean onReceived(Message message, int left) {
        //接收到消息，判断消息是否为服务端发送的，
        // 如果非服务端发送的消息自己处理，返回为true。否则返回为false，融云处理
        Conversation.ConversationType conversationType = message.getConversationType();
        NyUtiles.showLog("---", "收到消息");
        MessageContent messageContent = message.getContent();
        if (conversationType == Conversation.ConversationType.SYSTEM && NYAppManger.getInstance().ismUserWaiting()) {
            //处理系统消息逻辑

            if (messageContent instanceof WaitMessage) {
                WaitMessage textMessage = (WaitMessage) messageContent;
                NyUtiles.showLog("---", "getContent:" + textMessage.getContent() + ",getKf_id:" + textMessage.getKf_id() + ",getLocation:" + textMessage.getLocation() + ",getGroupId" + textMessage.getGroupId());
                NyUtiles.showLog("---", "getKf_name:" + textMessage.getKf_name() + ",getSession_id:" + textMessage.getSession_id() + ",getVisitor_id:" + textMessage.getVisitor_id());

                EventBus.getDefault().post(new RongReceiveMsgListener(textMessage));
            }
        } else if(conversationType == Conversation.ConversationType.GROUP && NYAppManger.getInstance().ismUserConversation()){
//            if (messageContent instanceof TextMessage) {
//                TextMessage textMessage = (TextMessage) messageContent;
//                String senderUserId = null;
//                if(senderUserId != null && !senderUserId.equalsIgnoreCase("")){
//                    senderUserId = message.getSenderUserId();
//                    NyUtiles.showLog("---", senderUserId);
//                }
//                SharedUtil.put("sendUserId",senderUserId);
//            }
        }else if (conversationType == Conversation.ConversationType.PRIVATE && NYAppManger.getInstance().ismUserConversation()) {
            if (messageContent instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) messageContent;
                String senderUserId = message.getSenderUserId();
                if(senderUserId == null || senderUserId.equalsIgnoreCase("")){
                    senderUserId = "";
                }
                NyUtiles.showLog("---", senderUserId);
                SharedUtil.put("sendUserId",senderUserId);

                String extra = textMessage.getExtra();
                if (extra != null && extra.equalsIgnoreCase("NY:SYSTEM|evaluate")) {
                    EventBus.getDefault().post(new ConverEvaLisenter());
                }
            }
        }else if(conversationType == Conversation.ConversationType.SYSTEM && NYAppManger.getInstance().ismUserConversation()){

            if (messageContent instanceof WaitMessage) {
                WaitMessage textMessage = (WaitMessage) messageContent;
                String type = textMessage.getType();
                if(type != null && type.equalsIgnoreCase("SERVICEPAUSE")){//挂断
                    String group_id = textMessage.getGroup_id();
                    String visitor_name = textMessage.getVisitor_name();
                    String group_name = textMessage.getGroup_name();
                    String rule_id = textMessage.getRule_id();
                    String greeting = textMessage.getGreeting();
                    //保存请求队列的数据
                    SharedUtil.put("group_id", group_id);
                    SharedUtil.put("visitor_name", visitor_name);
                    SharedUtil.put("group_name", group_name);
                    SharedUtil.put("rule_id", rule_id);
                    SharedUtil.put("greeting", greeting);
                    NyUtiles.showLog("---","getGroup_id:" + textMessage.getGroup_id() + ",getVisitor_name:" + textMessage.getVisitor_name()
                    + ",getGroup_name:" + textMessage.getGroup_name() + ",getRule_id():" + textMessage.getRule_id() + ",getGreeting():" + textMessage.getGreeting());
                    EventBus.getDefault().post(new CustomerStateLisenter(-1,false));
                }else if(type != null && type.equalsIgnoreCase("CONVERSATING")){//转接中
                    EventBus.getDefault().post(new CustomerStateLisenter(1,false,null,null));
                }else if(type != null && type.equalsIgnoreCase("CONVERSATION")){//转接成功
                    String kf_id = textMessage.getKf_id();
                    String session_id = textMessage.getSession_id();
                    NyUtiles.showLog("---","kf_id:" + kf_id + ",session_id:" + session_id);
                    EventBus.getDefault().post(new CustomerStateLisenter(1,true,kf_id,session_id));
                }

                EventBus.getDefault().post(new RongReceiveMsgListener(textMessage));
            }

        }
        return true;
    }


}

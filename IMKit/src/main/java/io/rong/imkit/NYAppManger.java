package io.rong.imkit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.List;
import java.util.Map;

import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.ImageLoader;
import io.rong.imageloader.core.ImageLoaderConfiguration;
import io.rong.imageloader.core.display.FadeInBitmapDisplayer;
import io.rong.imageloader.core.download.BaseImageDownloader;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.events.lisenter.RongConnectionStatusListener;
import io.rong.imkit.events.lisenter.RongReceiveMessage;
import io.rong.imkit.messages.WaitMessage;
import io.rong.imkit.messages.provider.CusImageMessageItemProvider;
import io.rong.imkit.messages.provider.CusTextMessageItemProvider;
import io.rong.imkit.plugin.NyExtensionModule;
import io.rong.imkit.provider.RongGroupUserInfoProvider;
import io.rong.imkit.provider.RongUserInfoProvider;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.TextMessage;

/**
 * Created by 18513 on 2017/12/19.
 */

public class NYAppManger {

    public final String TAG = "---NYAppManger";
    private String accessAppName = "";

    private static NYAppManger appManger = null;
    private static Context mContext = null;
    private static DisplayImageOptions options;//imgageloader的默认加载配置
    private boolean rongConnectStateLisenter = false;//监听融云的链接状态
    private boolean mUserWaiting = false;//监听用户的等待状态
    private boolean mUserConversation = false;//监听用户的聊天状态
    private boolean isSuccessStart = false;//监听何时关闭首页界面

    private NYAppManger() {
    }

    public static NYAppManger getInstance() {
        if (appManger == null) {
            appManger = new NYAppManger();
        }
        return appManger;
    }

    public static void initNYApp(Context context) {
        if (context != null) {
            mContext = context;
            initImageLoader();
        }
    }

    private static void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext).imageDownloader(
                new BaseImageDownloader(mContext, 60 * 1000, 60 * 1000)) // connectTimeout超时时间
                .build();
        ImageLoader.getInstance().init(config);
    }

    /**
     * 初始化APP内容
     *
     * @param RONG_CLOND_KEY 融云key
     * @return
     */
    public void initRongIm(String RONG_CLOND_KEY) {
        RongIm(RONG_CLOND_KEY)
                .registerMessageTemplate()
                .registerMessageType()
                .setCommentExtend()
                .setOnReceiveMessageListener()
                .setConnectionStatusListener();
    }

    /**
     * 初始化融云
     *
     * @param RONG_CLOND_KEY 融云RONG_CLOND_KEY
     * @return
     */
    private NYAppManger RongIm(String RONG_CLOND_KEY) {
        RongIM.init(getAppContent(), RONG_CLOND_KEY);
        return this;
    }

    /**
     * 链接融云
     *
     * @param RONG_TOKEN 融云用户token
     * @return
     */
    public void rongImConnect(String RONG_TOKEN) {

        if (isRongConnectStateLisenter()) {
            RongIM.connect(RONG_TOKEN, new RongIMClient.ConnectCallback() {
                @Override
                public void onTokenIncorrect() {
                    NyUtiles.showLog(TAG, "验证token失败");
                }

                @Override
                public void onSuccess(String s) {
                    NyUtiles.showLog(TAG, "登录融云成功" + s);
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    NyUtiles.showLog(TAG, "登录融云失败" + errorCode);
                }
            });
        }

    }

    /**
     * 注册自定义消息
     *
     * @return
     */
    private NYAppManger registerMessageType() {
        RongIM.registerMessageType(WaitMessage.class);
        return this;
    }

    /**
     * 注册自定义消息模板
     *
     * @return
     */
    private NYAppManger registerMessageTemplate() {
        RongIM.getInstance().registerMessageTemplate(new CusTextMessageItemProvider());
        RongIM.getInstance().registerMessageTemplate(new CusImageMessageItemProvider());
        return this;
    }

    /**
     * 设置聊天界面的评论
     *
     * @return
     */
    private NYAppManger setCommentExtend() {
        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
        IExtensionModule defaultModule = null;
        if (moduleList != null) {
            for (IExtensionModule module : moduleList) {
                if (module instanceof DefaultExtensionModule) {
                    defaultModule = module;
                    break;
                }
            }
            if (defaultModule != null) {
                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
                RongExtensionManager.getInstance().registerExtensionModule(new NyExtensionModule());
            }
        }
        return this;
    }

    /**
     * 设置接收消息监听
     *
     * @return
     */
    private NYAppManger setOnReceiveMessageListener() {
        RongIM.setOnReceiveMessageListener(new RongReceiveMessage());
        return this;
    }

    /**
     * 销毁接收消息监听设置
     */
    public void removeOnReceiveMessageListener() {
        RongIM.setOnReceiveMessageListener(null);
    }

    /**
     * 设置链接消息监听
     *
     * @return
     */
    private NYAppManger setConnectionStatusListener() {
        RongIM.getInstance().setConnectionStatusListener(new RongConnectionStatusListener());
        return this;
    }

    /**
     * 销毁链接消息监听设置
     */
    public void removeConnectionStatusListener() {
        RongIM.getInstance().setConnectionStatusListener(null);
    }

    /**
     * 设置用户信息提供者
     */
    public void setUserInfoProvider(String userId, String userName, String portraitUri) {
        RongIM.setUserInfoProvider(new RongUserInfoProvider(userId, userName, portraitUri), true);
    }

    /**
     * 设置群组用户信息提供者
     */
    public void setGroupUserInfoProvider(String groupId, String userId, String nackName) {
        RongIM.setGroupUserInfoProvider(new RongGroupUserInfoProvider(userId, userId, nackName), true);
    }

    /**
     * 开启一个群组界面
     *
     * @param targetUserId 开启会话的组名
     * @param title        开启会话的title
     */
    public void startGroupChat(String targetUserId, String title, Map<String, String> map) {
        Uri uri = Uri.parse(getAccessAppName())
                .buildUpon()
                .appendPath("conversation")
                .appendPath(Conversation.ConversationType.GROUP.getName().toLowerCase())
                .appendQueryParameter("targetId", targetUserId)
                .appendQueryParameter("title", title)
                .build();
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        for (String key : map.keySet()) {
            intent.putExtra(key, map.get(key));
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getAppContent().startActivity(intent);
    }

    public void sendPrivateMessage(final String toUserId, WaitMessage textMessage) {
        if (toUserId == null || toUserId.equalsIgnoreCase("")
                || textMessage == null) {
            return;
        }
        Message message = Message.obtain(toUserId, Conversation.ConversationType.PRIVATE, textMessage);
        /**
         * <p>发送消息。
         * 通过 {@link io.rong.imlib.IRongCallback.ISendMessageCallback}
         * 中的方法回调发送的消息状态及消息体。</p>
         *
         * @param message     将要发送的消息体。
         * @param pushContent 当下发 push 消息时，在通知栏里会显示这个字段。
         *                    如果发送的是自定义消息，该字段必须填写，否则无法收到 push 消息。
         *                    如果发送 sdk 中默认的消息类型，例如 RC:TxtMsg, RC:VcMsg, RC:ImgMsg，则不需要填写，默认已经指定。
         * @param pushData    push 附加信息。如果设置该字段，用户在收到 push 消息时，能通过 {@link io.rong.push.notification.PushNotificationMessage#getPushData()} 方法获取。
         * @param callback    发送消息的回调，参考 {@link io.rong.imlib.IRongCallback.ISendMessageCallback}。
         */
        RongIM.getInstance().sendMessage(message, null, null, new IRongCallback.ISendMessageCallback() {

            @Override
            public void onAttached(Message message) {
                //消息本地数据库存储成功的回调
            }

            @Override
            public void onSuccess(Message message) {
                //消息通过网络发送成功的回调
                NyUtiles.showLog(TAG, "发送目标id：" + message.getTargetId() + ",发送内容为：" + message.getContent() + "(" + toUserId + ")");
            }

            @Override
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                //消息发送失败的回调
            }
        });
    }

    public Context getAppContent() {
        return mContext;
    }


    public String getAccessAppName() {
        return accessAppName;
    }

    public void setAccessAppName(String accessAppName) {
        this.accessAppName = accessAppName + "://" + "io.rong.imkit";
    }

    public boolean isRongConnectStateLisenter() {
        return rongConnectStateLisenter;
    }

    public void setRongConnectStateLisenter(boolean rongConnectStateLisenter) {
        this.rongConnectStateLisenter = rongConnectStateLisenter;
    }

    public boolean ismUserWaiting() {
        return mUserWaiting;
    }

    public void setmUserWaiting(boolean mUserWaiting) {
        this.mUserWaiting = mUserWaiting;
    }

    public boolean ismUserConversation() {
        return mUserConversation;
    }

    public void setmUserConversation(boolean mUserConversation) {
        this.mUserConversation = mUserConversation;
    }

    public boolean isSuccessStart() {
        return isSuccessStart;
    }

    public void setSuccessStart(boolean successStart) {
        isSuccessStart = successStart;
    }

    public DisplayImageOptions getOptions() {
        if (options == null) {
            options = new DisplayImageOptions.Builder()
                    .showImageForEmptyUri(R.drawable.ny_loading_error)
                    .showImageOnFail(R.drawable.ny_loading_error)
                    .showImageOnLoading(R.drawable.ny_loading)
                    .displayer(new FadeInBitmapDisplayer(300))
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .build();
        }
        return options;
    }

    public void logoutRongIM() {
        try {
            removeConnectionStatusListener();
            removeOnReceiveMessageListener();
            RongIM.getInstance().logout();
        } catch (Exception e) {
            NyUtiles.showLog(TAG, "融云退出异常");
        }

    }
}

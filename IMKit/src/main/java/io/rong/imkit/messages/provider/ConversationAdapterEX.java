package io.rong.imkit.messages.provider;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.mention.RongMentionManager;
import io.rong.imkit.model.ConversationKey;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.utils.RongDateUtils;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.DebouncedOnClickListener;
import io.rong.imkit.widget.ProviderContainerView;
//import io.rong.imkit.widget.adapter.MessageListAdapter;
import io.rong.imkit.widget.adapter.BaseAdapter;
import io.rong.imkit.widget.adapter.MessageListAdapter;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.ReadReceiptInfo;
import io.rong.imlib.model.UnknownMessage;
import io.rong.imlib.model.UserInfo;
import io.rong.message.TextMessage;

/**
 * Created by 18513 on 2018/1/9.
 */

public class ConversationAdapterEX extends MessageListAdapter {

    private static final String TAG = "ConversationAdapterEX";
    private static long readReceiptRequestInterval = 120L;
    private LayoutInflater mInflater;
    private Context mContext;
    private MessageListAdapter.OnItemHandlerListener mOnItemHandlerListener;
    boolean evaForRobot = false;
    boolean robotMode = true;
    protected boolean timeGone = false;

    public ConversationAdapterEX(Context context) {
        super(context);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        try {
            readReceiptRequestInterval = (long) RongContext.getInstance().getResources().getInteger(R.integer.rc_read_receipt_request_interval);
        } catch (Resources.NotFoundException var3) {
            RLog.e("ConversationAdapterEX", "rc_read_receipt_request_interval not configure in rc_config.xml");
            var3.printStackTrace();
        }
    }

    public void setOnItemHandlerListener(MessageListAdapter.OnItemHandlerListener onItemHandlerListener) {
        this.mOnItemHandlerListener = onItemHandlerListener;
    }

    protected MessageListAdapter.OnItemHandlerListener getItemHandlerListener() {
        return this.mOnItemHandlerListener;
    }

    public long getItemId(int position) {
        UIMessage message = (UIMessage) this.getItem(position);
        return message == null ? -1L : (long) message.getMessageId();
    }

    protected View newView(Context context, int position, ViewGroup group) {
        View result = this.mInflater.inflate(R.layout.rc_item_message, (ViewGroup) null);
        ConversationAdapterEX.ViewHolder holder = new ConversationAdapterEX.ViewHolder();
        holder.leftIconView = (AsyncImageView) this.findViewById(result, R.id.rc_left);
        holder.rightIconView = (AsyncImageView) this.findViewById(result, R.id.rc_right);
        holder.nameView = (TextView) this.findViewById(result, R.id.rc_title);
        holder.contentView = (ProviderContainerView) this.findViewById(result, R.id.rc_content);
        holder.layout = (ViewGroup) this.findViewById(result, R.id.rc_layout);
        holder.progressBar = (ProgressBar) this.findViewById(result, R.id.rc_progress);
        holder.warning = (ImageView) this.findViewById(result, R.id.rc_warning);
        holder.readReceipt = (TextView) this.findViewById(result, R.id.rc_read_receipt);
        holder.readReceiptRequest = (TextView) this.findViewById(result, R.id.rc_read_receipt_request);
        holder.readReceiptStatus = (TextView) this.findViewById(result, R.id.rc_read_receipt_status);
        holder.message_check = (CheckBox) this.findViewById(result, R.id.message_check);
        holder.time = (TextView) this.findViewById(result, R.id.rc_time);
        holder.sentStatus = (TextView) this.findViewById(result, R.id.rc_sent_status);
        holder.layoutItem = (RelativeLayout) this.findViewById(result, R.id.rc_layout_item_message);
        if (holder.time.getVisibility() == 8) {
            this.timeGone = true;
        } else {
            this.timeGone = false;
        }

        result.setTag(holder);
        return result;
    }

    protected boolean getNeedEvaluate(UIMessage data) {
        String extra = "";
        String robotEva = "";
        String sid = "";
        if (data != null && data.getConversationType() != null && data.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE)) {
            if (data.getContent() instanceof TextMessage) {
                extra = ((TextMessage) data.getContent()).getExtra();
                if (TextUtils.isEmpty(extra)) {
                    return false;
                }

                try {
                    JSONObject jsonObj = new JSONObject(extra);
                    robotEva = jsonObj.optString("robotEva");
                    sid = jsonObj.optString("sid");
                } catch (JSONException var6) {
                    ;
                }
            }

            if (data.getMessageDirection() == Message.MessageDirection.RECEIVE && data.getContent() instanceof TextMessage && this.evaForRobot && this.robotMode && !TextUtils.isEmpty(robotEva) && !TextUtils.isEmpty(sid) && !data.getIsHistoryMessage()) {
                return true;
            }
        }

        return false;
    }

    protected void bindView(View v, final int position, final UIMessage data) {
        if (data != null) {
            final ConversationAdapterEX.ViewHolder holder = (ConversationAdapterEX.ViewHolder) v.getTag();
            if (holder == null) {
                RLog.e("ConversationAdapterEX", "view holder is null !");
            } else {
                Object provider;
                ProviderTag tag;
                if (this.getNeedEvaluate(data)) {
                    provider = RongContext.getInstance().getEvaluateProvider();
                    tag = RongContext.getInstance().getMessageProviderTag(data.getContent().getClass());
                } else {
                    if (RongContext.getInstance() == null || data == null || data.getContent() == null) {
                        RLog.e("ConversationAdapterEX", "Message is null !");
                        return;
                    }

                    provider = RongContext.getInstance().getMessageTemplate(data.getContent().getClass());
                    if (provider == null) {
                        provider = RongContext.getInstance().getMessageTemplate(UnknownMessage.class);
                        tag = RongContext.getInstance().getMessageProviderTag(UnknownMessage.class);
                    } else {
                        tag = RongContext.getInstance().getMessageProviderTag(data.getContent().getClass());
                    }

                    if (provider == null) {
                        RLog.e("ConversationAdapterEX", data.getObjectName() + " message provider not found !");
                        return;
                    }
                }

                final View view = holder.contentView.inflate((IContainerItemProvider) provider);
                ((IContainerItemProvider) provider).bindView(view, position, data);
                if (tag == null) {
                    RLog.e("ConversationAdapterEX", "Can not find ProviderTag for " + data.getObjectName());
                } else {
                    if (tag.hide()) {
                        holder.contentView.setVisibility(8);
                        holder.time.setVisibility(8);
                        holder.nameView.setVisibility(8);
                        holder.leftIconView.setVisibility(8);
                        holder.rightIconView.setVisibility(8);
                        holder.layoutItem.setVisibility(8);
                        holder.layoutItem.setPadding(0, 0, 0, 0);
                    } else {
                        holder.contentView.setVisibility(0);
                        holder.layoutItem.setVisibility(0);
                        holder.layoutItem.setPadding(RongUtils.dip2px(8.0F), RongUtils.dip2px(6.0F), RongUtils.dip2px(8.0F), RongUtils.dip2px(6.0F));
                    }

                    UserInfo var13;
                    GroupUserInfo var14;
                    if (data.getMessageDirection() == Message.MessageDirection.SEND) {
                        if (tag.showPortrait()) {
                            holder.rightIconView.setVisibility(0);
                            holder.leftIconView.setVisibility(8);
                        } else {
                            holder.leftIconView.setVisibility(8);
                            holder.rightIconView.setVisibility(8);
                        }

                        if (!tag.centerInHorizontal()) {
                            this.setGravity(holder.layout, 5);
                            holder.contentView.containerViewRight();
                            holder.nameView.setGravity(5);
                        } else {
                            this.setGravity(holder.layout, 17);
                            holder.contentView.containerViewCenter();
                            holder.nameView.setGravity(1);
                            holder.contentView.setBackgroundColor(0);
                        }

                        boolean time = false;

                        try {
                            time = this.mContext.getResources().getBoolean(R.bool.rc_read_receipt);
                        } catch (Resources.NotFoundException var12) {
                            RLog.e("ConversationAdapterEX", "rc_read_receipt not configure in rc_config.xml");
                            var12.printStackTrace();
                        }

                        if (data.getSentStatus() == Message.SentStatus.SENDING) {
                            if (tag.showProgress()) {
                                holder.progressBar.setVisibility(0);
                            } else {
                                holder.progressBar.setVisibility(8);
                            }

                            holder.warning.setVisibility(8);
                            holder.readReceipt.setVisibility(8);
                        } else if (data.getSentStatus() == Message.SentStatus.FAILED) {
                            holder.progressBar.setVisibility(8);
                            holder.warning.setVisibility(0);
                            holder.readReceipt.setVisibility(8);
                        } else if (data.getSentStatus() == Message.SentStatus.SENT) {
                            holder.progressBar.setVisibility(8);
                            holder.warning.setVisibility(8);
                            holder.readReceipt.setVisibility(8);
                        } else if (time && data.getSentStatus() == Message.SentStatus.READ) {
                            holder.progressBar.setVisibility(8);
                            holder.warning.setVisibility(8);
                            if (data.getConversationType().equals(Conversation.ConversationType.PRIVATE) && tag.showReadState()) {
                                holder.readReceipt.setVisibility(0);
                            } else {
                                holder.readReceipt.setVisibility(8);
                            }
                        } else {
                            holder.progressBar.setVisibility(8);
                            holder.warning.setVisibility(8);
                            holder.readReceipt.setVisibility(8);
                        }

                        holder.readReceiptRequest.setVisibility(8);
                        holder.readReceiptStatus.setVisibility(8);
                        if (time && RongContext.getInstance().isReadReceiptConversationType(data.getConversationType()) && (data.getConversationType().equals(Conversation.ConversationType.GROUP) || data.getConversationType().equals(Conversation.ConversationType.DISCUSSION))) {
                            if (this.allowReadReceiptRequest(data.getMessage()) && !TextUtils.isEmpty(data.getUId())) {
                                boolean pre = true;

                                for (int publicServiceProfile = position + 1; publicServiceProfile < this.getCount(); ++publicServiceProfile) {
                                    if (((UIMessage) this.getItem(publicServiceProfile)).getMessageDirection() == Message.MessageDirection.SEND) {
                                        pre = false;
                                        break;
                                    }
                                }

                                long var16 = System.currentTimeMillis() - RongIMClient.getInstance().getDeltaTime();
                                if (var16 - data.getSentTime() < readReceiptRequestInterval * 1000L && pre && (data.getReadReceiptInfo() == null || !data.getReadReceiptInfo().isReadReceiptMessage())) {
                                    holder.readReceiptRequest.setVisibility(0);
                                }
                            }

                            if (this.allowReadReceiptRequest(data.getMessage()) && data.getReadReceiptInfo() != null && data.getReadReceiptInfo().isReadReceiptMessage()) {
                                if (data.getReadReceiptInfo().getRespondUserIdList() != null) {
                                    holder.readReceiptStatus.setText(String.format(view.getResources().getString(R.string.rc_read_receipt_status), new Object[]{Integer.valueOf(data.getReadReceiptInfo().getRespondUserIdList().size())}));
                                } else {
                                    holder.readReceiptStatus.setText(String.format(view.getResources().getString(R.string.rc_read_receipt_status), new Object[]{Integer.valueOf(0)}));
                                }

                                holder.readReceiptStatus.setVisibility(0);
                            }
                        }

                        holder.nameView.setVisibility(8);
                        holder.readReceiptRequest.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                RongIMClient.getInstance().sendReadReceiptRequest(data.getMessage(), new RongIMClient.OperationCallback() {
                                    public void onSuccess() {
                                        ReadReceiptInfo readReceiptInfo = data.getReadReceiptInfo();
                                        if (readReceiptInfo == null) {
                                            readReceiptInfo = new ReadReceiptInfo();
                                            data.setReadReceiptInfo(readReceiptInfo);
                                        }

                                        readReceiptInfo.setIsReadReceiptMessage(true);
                                        holder.readReceiptStatus.setText(String.format(view.getResources().getString(R.string.rc_read_receipt_status), new Object[]{Integer.valueOf(0)}));
                                        holder.readReceiptRequest.setVisibility(8);
                                        holder.readReceiptStatus.setVisibility(0);
                                    }

                                    public void onError(RongIMClient.ErrorCode errorCode) {
                                        RLog.e("ConversationAdapterEX", "sendReadReceiptRequest failed, errorCode = " + errorCode);
                                    }
                                });
                            }
                        });
                        holder.readReceiptStatus.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if (ConversationAdapterEX.this.mOnItemHandlerListener != null) {
                                    ConversationAdapterEX.this.mOnItemHandlerListener.onReadReceiptStateClick(data.getMessage());
                                }

                            }
                        });
                        holder.rightIconView.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if (RongContext.getInstance().getConversationBehaviorListener() != null) {
                                    UserInfo userInfo = null;
                                    if (!TextUtils.isEmpty(data.getSenderUserId())) {
                                        userInfo = RongUserInfoManager.getInstance().getUserInfo(data.getSenderUserId());
                                        userInfo = userInfo == null ? new UserInfo(data.getSenderUserId(), (String) null, (Uri) null) : userInfo;
                                    }

                                    RongContext.getInstance().getConversationBehaviorListener().onUserPortraitClick(ConversationAdapterEX.this.mContext, data.getConversationType(), userInfo);
                                }

                            }
                        });
                        holder.rightIconView.setOnLongClickListener(new View.OnLongClickListener() {
                            public boolean onLongClick(View v) {
                                if (RongContext.getInstance().getConversationBehaviorListener() != null) {
                                    UserInfo userInfo = null;
                                    if (!TextUtils.isEmpty(data.getSenderUserId())) {
                                        userInfo = RongUserInfoManager.getInstance().getUserInfo(data.getSenderUserId());
                                        userInfo = userInfo == null ? new UserInfo(data.getSenderUserId(), (String) null, (Uri) null) : userInfo;
                                    }

                                    return RongContext.getInstance().getConversationBehaviorListener().onUserPortraitLongClick(ConversationAdapterEX.this.mContext, data.getConversationType(), userInfo);
                                } else {
                                    return true;
                                }
                            }
                        });
                        if (!tag.showWarning()) {
                            holder.warning.setVisibility(8);
                        }
                    } else {
                        if (tag.showPortrait()) {
                            holder.rightIconView.setVisibility(8);
                            holder.leftIconView.setVisibility(0);
                        } else {
                            holder.leftIconView.setVisibility(8);
                            holder.rightIconView.setVisibility(8);
                        }

                        if (!tag.centerInHorizontal()) {
                            this.setGravity(holder.layout, 3);
                            holder.contentView.containerViewLeft();
                            holder.nameView.setGravity(3);
                        } else {
                            this.setGravity(holder.layout, 17);
                            holder.contentView.containerViewCenter();
                            holder.nameView.setGravity(1);
                            holder.contentView.setBackgroundColor(0);
                        }

                        holder.progressBar.setVisibility(8);
                        holder.warning.setVisibility(8);
                        holder.readReceipt.setVisibility(8);
                        holder.readReceiptRequest.setVisibility(8);
                        holder.readReceiptStatus.setVisibility(8);
                        holder.nameView.setVisibility(0);
                        if (data.getConversationType() != Conversation.ConversationType.PRIVATE && tag.showSummaryWithName() && data.getConversationType() != Conversation.ConversationType.PUBLIC_SERVICE && data.getConversationType() != Conversation.ConversationType.APP_PUBLIC_SERVICE) {
                            var13 = null;
                            if (data.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE) && data.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                                if (data.getUserInfo() != null) {
                                    var13 = data.getUserInfo();
                                } else if (data.getMessage() != null && data.getMessage().getContent() != null) {
                                    var13 = data.getMessage().getContent().getUserInfo();
                                }

                                if (var13 != null) {
                                    holder.nameView.setText(var13.getName());
                                } else {
                                    holder.nameView.setText(data.getSenderUserId());
                                }
                            } else if (data.getConversationType() == Conversation.ConversationType.GROUP) {
                                var14 = RongUserInfoManager.getInstance().getGroupUserInfo(data.getTargetId(), data.getSenderUserId());
                                if (var14 != null) {
                                    holder.nameView.setText(var14.getNickname());
                                } else {
                                    var13 = RongUserInfoManager.getInstance().getUserInfo(data.getSenderUserId());
                                    if (var13 == null) {
                                        holder.nameView.setText(data.getSenderUserId());
                                    } else {
                                        holder.nameView.setText(var13.getName());
                                    }
                                }
                            } else {
                                var13 = RongUserInfoManager.getInstance().getUserInfo(data.getSenderUserId());
                                if (var13 == null) {
                                    holder.nameView.setText(data.getSenderUserId());
                                } else {
                                    holder.nameView.setText(var13.getName());
                                }
                            }
                        } else {
                            holder.nameView.setVisibility(8);
                        }

                        holder.leftIconView.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if (RongContext.getInstance().getConversationBehaviorListener() != null) {
                                    UserInfo userInfo = null;
                                    if (!TextUtils.isEmpty(data.getSenderUserId())) {
                                        userInfo = RongUserInfoManager.getInstance().getUserInfo(data.getSenderUserId());
                                        userInfo = userInfo == null ? new UserInfo(data.getSenderUserId(), (String) null, (Uri) null) : userInfo;
                                    }

                                    RongContext.getInstance().getConversationBehaviorListener().onUserPortraitClick(ConversationAdapterEX.this.mContext, data.getConversationType(), userInfo);
                                }

                            }
                        });
                    }

                    holder.leftIconView.setOnLongClickListener(new View.OnLongClickListener() {
                        public boolean onLongClick(View v) {
                            UserInfo userInfo = null;
                            if (!TextUtils.isEmpty(data.getSenderUserId())) {
                                userInfo = RongUserInfoManager.getInstance().getUserInfo(data.getSenderUserId());
                                userInfo = userInfo == null ? new UserInfo(data.getSenderUserId(), (String) null, (Uri) null) : userInfo;
                            }

                            if (RongContext.getInstance().getConversationBehaviorListener() != null && RongContext.getInstance().getConversationBehaviorListener().onUserPortraitLongClick(ConversationAdapterEX.this.mContext, data.getConversationType(), userInfo)) {
                                return false;
                            } else if (!RongContext.getInstance().getResources().getBoolean(R.bool.rc_enable_mentioned_message) || !data.getConversationType().equals(Conversation.ConversationType.GROUP) && !data.getConversationType().equals(Conversation.ConversationType.DISCUSSION)) {
                                return false;
                            } else {
                                RongMentionManager.getInstance().mentionMember(data.getConversationType(), data.getTargetId(), data.getSenderUserId());
                                return true;
                            }
                        }
                    });
                    ConversationKey mKey;
                    Uri var15;
                    PublicServiceProfile var17;
                    if (holder.rightIconView.getVisibility() == 0) {
                        if (data.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE) && data.getUserInfo() != null && data.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                            var13 = data.getUserInfo();
                            var15 = var13.getPortraitUri();
                            holder.rightIconView.setAvatar(var15 != null ? var15.toString() : null, 0);
                        } else if ((data.getConversationType().equals(Conversation.ConversationType.PUBLIC_SERVICE) || data.getConversationType().equals(Conversation.ConversationType.APP_PUBLIC_SERVICE)) && data.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                            var13 = data.getUserInfo();
                            if (var13 != null) {
                                var15 = var13.getPortraitUri();
                                holder.rightIconView.setAvatar(var15 != null ? var15.toString() : null, 0);
                            } else {
                                mKey = ConversationKey.obtain(data.getTargetId(), data.getConversationType());
                                var17 = RongContext.getInstance().getPublicServiceInfoFromCache(mKey.getKey());
                                var15 = var17.getPortraitUri();
                                holder.rightIconView.setAvatar(var15 != null ? var15.toString() : null, 0);
                            }
                        } else if (!TextUtils.isEmpty(data.getSenderUserId())) {
                            var13 = RongUserInfoManager.getInstance().getUserInfo(data.getSenderUserId());
                            if (var13 != null && var13.getPortraitUri() != null) {
                                holder.rightIconView.setAvatar(var13.getPortraitUri().toString(), 0);
                            } else {
                                holder.rightIconView.setAvatar((String) null, 0);
                            }
                        }
                    } else if (holder.leftIconView.getVisibility() == 0) {
                        var13 = null;
                        var14 = null;
                        if (data.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE) && data.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                            if (data.getUserInfo() != null) {
                                var13 = data.getUserInfo();
                            } else if (data.getMessage() != null && data.getMessage().getContent() != null) {
                                var13 = data.getMessage().getContent().getUserInfo();
                            }

                            if (var13 != null) {
                                var15 = var13.getPortraitUri();
                                holder.leftIconView.setAvatar(var15 != null ? var15.toString() : null, R.drawable.rc_cs_default_portrait);
                            }
                        } else if ((data.getConversationType().equals(Conversation.ConversationType.PUBLIC_SERVICE) || data.getConversationType().equals(Conversation.ConversationType.APP_PUBLIC_SERVICE)) && data.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                            var13 = data.getUserInfo();
                            if (var13 != null) {
                                var15 = var13.getPortraitUri();
                                holder.leftIconView.setAvatar(var15 != null ? var15.toString() : null, 0);
                            } else {
                                mKey = ConversationKey.obtain(data.getTargetId(), data.getConversationType());
                                var17 = RongContext.getInstance().getPublicServiceInfoFromCache(mKey.getKey());
                                if (var17 != null && var17.getPortraitUri() != null) {
                                    holder.leftIconView.setAvatar(var17.getPortraitUri().toString(), 0);
                                } else {
                                    holder.leftIconView.setAvatar((String) null, 0);
                                }
                            }
                        } else if (!TextUtils.isEmpty(data.getSenderUserId())) {
                            var13 = RongUserInfoManager.getInstance().getUserInfo(data.getSenderUserId());
                            if (var13 != null && var13.getPortraitUri() != null) {
                                holder.leftIconView.setAvatar(var13.getPortraitUri().toString(), 0);
                            } else {
                                holder.leftIconView.setAvatar((String) null, 0);
                            }
                        }
                    }

                    if (view != null) {
                        view.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if (RongContext.getInstance().getConversationBehaviorListener() == null || !RongContext.getInstance().getConversationBehaviorListener().onMessageClick(ConversationAdapterEX.this.mContext, v, data.getMessage())) {
                                    Object provider;
                                    if (ConversationAdapterEX.this.getNeedEvaluate(data)) {
                                        provider = RongContext.getInstance().getEvaluateProvider();
                                    } else {
                                        provider = RongContext.getInstance().getMessageTemplate(data.getContent().getClass());
                                    }

                                    if (provider != null) {
                                        ((IContainerItemProvider.MessageProvider) provider).onItemClick(v, position, data.getContent(), data);
                                    }

                                }
                            }
                        });
                        view.setOnLongClickListener(new View.OnLongClickListener() {
                            public boolean onLongClick(View v) {
                                if (RongContext.getInstance().getConversationBehaviorListener() != null && RongContext.getInstance().getConversationBehaviorListener().onMessageLongClick(ConversationAdapterEX.this.mContext, v, data.getMessage())) {
                                    return true;
                                } else {
                                    Object provider;
                                    if (ConversationAdapterEX.this.getNeedEvaluate(data)) {
                                        provider = RongContext.getInstance().getEvaluateProvider();
                                    } else {
                                        provider = RongContext.getInstance().getMessageTemplate(data.getContent().getClass());
                                    }

                                    if (provider != null) {
                                        ((IContainerItemProvider.MessageProvider) provider).onItemLongClick(v, position, data.getContent(), data);
                                    }

                                    return true;
                                }
                            }
                        });
                    }

                    holder.warning.setOnClickListener(new DebouncedOnClickListener() {
                        public void onDebouncedClick(View view) {
                            if (ConversationAdapterEX.this.mOnItemHandlerListener != null) {
                                ConversationAdapterEX.this.mOnItemHandlerListener.onWarningViewClick(position, data.getMessage(), view);
                            }

                        }
                    });
                    if (tag.hide()) {
                        holder.time.setVisibility(8);
                    } else {
                        if (!this.timeGone) {
                            String var19 = RongDateUtils.getConversationFormatDate(data.getSentTime(), view.getContext());
                            holder.time.setText(var19);
                            if (position == 0) {
                                holder.time.setVisibility(0);
                            } else {
                                UIMessage var18 = (UIMessage) this.getItem(position - 1);
                                if (RongDateUtils.isShowChatTime(data.getSentTime(), var18.getSentTime(), 180)) {
                                    holder.time.setVisibility(0);
                                } else {
                                    holder.time.setVisibility(8);
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    protected void setGravity(View view, int gravity) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.gravity = gravity;
    }

    public void setEvaluateForRobot(boolean needEvaluate) {
        this.evaForRobot = needEvaluate;
    }

    public void setRobotMode(boolean robotMode) {
        this.robotMode = robotMode;
    }

    public boolean allowReadReceiptRequest(Message message) {
        return message != null && message.getContent() != null && message.getContent() instanceof TextMessage;
    }

    public interface OnItemHandlerListener {
        boolean onWarningViewClick(int var1, Message var2, View var3);

        void onReadReceiptStateClick(Message var1);
    }

    protected class ViewHolder {
        public AsyncImageView leftIconView;
        public AsyncImageView rightIconView;
        public TextView nameView;
        public ProviderContainerView contentView;
        public ProgressBar progressBar;
        public ImageView warning;
        public TextView readReceipt;
        public TextView readReceiptRequest;
        public TextView readReceiptStatus;
        public ViewGroup layout;
        public TextView time;
        public TextView sentStatus;
        public RelativeLayout layoutItem;
        public CheckBox message_check;

        protected ViewHolder() {
        }
    }
}

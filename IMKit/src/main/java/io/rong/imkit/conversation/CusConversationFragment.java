//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.rong.imkit.conversation;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources.NotFoundException;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import io.rong.common.RLog;
import io.rong.common.SystemUtils;
import io.rong.eventbus.EventBus;
import io.rong.imkit.IExtensionClickListener;
import io.rong.imkit.IPublicServiceMenuClickListener;
import io.rong.imkit.InputMenu;
import io.rong.imkit.R.bool;
import io.rong.imkit.R.id;
import io.rong.imkit.R.integer;
import io.rong.imkit.R.layout;
import io.rong.imkit.R.string;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongExtension;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongKitReceiver;
import io.rong.imkit.fragment.IHistoryDataResultCallback;
import io.rong.imkit.fragment.UriFragment;
import io.rong.imkit.manager.AudioPlayManager;
import io.rong.imkit.manager.AudioRecordManager;
import io.rong.imkit.manager.InternalModuleManager;
import io.rong.imkit.manager.SendImageManager;
import io.rong.imkit.manager.UnReadMessageManager;
import io.rong.imkit.mention.RongMentionManager;
import io.rong.imkit.model.ConversationInfo;
import io.rong.imkit.model.Event.CSTerminateEvent;
import io.rong.imkit.model.Event.ConnectEvent;
import io.rong.imkit.model.Event.DraftEvent;
import io.rong.imkit.model.Event.FileMessageEvent;
import io.rong.imkit.model.Event.MessageDeleteEvent;
import io.rong.imkit.model.Event.MessageRecallEvent;
import io.rong.imkit.model.Event.MessagesClearEvent;
import io.rong.imkit.model.Event.OnMessageSendErrorEvent;
import io.rong.imkit.model.Event.OnReceiveMessageEvent;
import io.rong.imkit.model.Event.OnReceiveMessageProgressEvent;
import io.rong.imkit.model.Event.PlayAudioEvent;
import io.rong.imkit.model.Event.PublicServiceFollowableEvent;
import io.rong.imkit.model.Event.ReadReceiptEvent;
import io.rong.imkit.model.Event.ReadReceiptRequestEvent;
import io.rong.imkit.model.Event.ReadReceiptResponseEvent;
import io.rong.imkit.model.Event.RemoteMessageRecallEvent;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.plugin.DefaultLocationPlugin;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.location.AMapRealTimeActivity;
import io.rong.imkit.plugin.location.IRealTimeLocationStateListener;
import io.rong.imkit.plugin.location.IUserInfoProvider;
import io.rong.imkit.plugin.location.LocationManager;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imkit.utilities.PromptPopupDialog;
import io.rong.imkit.utilities.PromptPopupDialog.OnPromptButtonClickedListener;
import io.rong.imkit.widget.AutoRefreshListView;
import io.rong.imkit.widget.AutoRefreshListView.Mode;
import io.rong.imkit.widget.AutoRefreshListView.OnRefreshListener;
import io.rong.imkit.widget.AutoRefreshListView.State;
import io.rong.imkit.widget.CSEvaluateDialog;
import io.rong.imkit.widget.CSEvaluateDialog.EvaluateClickListener;
import io.rong.imkit.widget.SingleChoiceDialog;
import io.rong.imkit.widget.adapter.MessageListAdapter;
import io.rong.imkit.widget.adapter.MessageListAdapter.OnItemHandlerListener;
import io.rong.imkit.widget.provider.EvaluatePlugin;
import io.rong.imlib.CustomServiceConfig;
import io.rong.imlib.CustomServiceConfig.CSEvaEntryPoint;
import io.rong.imlib.CustomServiceConfig.CSEvaType;
import io.rong.imlib.CustomServiceConfig.CSQuitSuspendType;
import io.rong.imlib.ICustomServiceListener;
import io.rong.imlib.IRongCallback.ISendMediaMessageCallback;
import io.rong.imlib.IRongCallback.ISendMessageCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.RongIMClient.ErrorCode;
import io.rong.imlib.RongIMClient.OperationCallback;
import io.rong.imlib.RongIMClient.ResultCallback;
import io.rong.imlib.RongIMClient.SendImageMessageCallback;
import io.rong.imlib.location.RealTimeLocationConstant.RealTimeLocationStatus;
import io.rong.imlib.model.CSCustomServiceInfo;
import io.rong.imlib.model.CSGroupItem;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Conversation.ConversationType;
import io.rong.imlib.model.Conversation.PublicServiceType;
import io.rong.imlib.model.CustomServiceMode;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.Message.MessageDirection;
import io.rong.imlib.model.Message.SentStatus;
import io.rong.imlib.model.PublicServiceMenu;
import io.rong.imlib.model.PublicServiceMenu.PublicServiceMenuItemType;
import io.rong.imlib.model.PublicServiceMenuItem;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.ReadReceiptInfo;
import io.rong.imlib.model.UserInfo;
import io.rong.message.CSPullLeaveMessage;
import io.rong.message.FileMessage;
import io.rong.message.ImageMessage;
import io.rong.message.InformationNotificationMessage;
import io.rong.message.LocationMessage;
import io.rong.message.MediaMessageContent;
import io.rong.message.PublicServiceCommandMessage;
import io.rong.message.ReadReceiptMessage;
import io.rong.message.RecallNotificationMessage;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;
import io.rong.push.RongPushClient;

public class CusConversationFragment extends UriFragment implements OnScrollListener, IExtensionClickListener, IUserInfoProvider, EvaluateClickListener {
    private static final String TAG = "CusConversationFragment";
    private PublicServiceProfile mPublicServiceProfile;
    private RongExtension mRongExtension;
    private boolean mEnableMention;
    private float mLastTouchY;
    private boolean mUpDirection;
    private float mOffsetLimit;
    private boolean finishing = false;
    private CSCustomServiceInfo mCustomUserInfo;
    private ConversationInfo mCurrentConversationInfo;
    private String mDraft;
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 100;
    private static final int REQUEST_CODE_LOCATION_SHARE = 101;
    private static final int REQUEST_CS_LEAVEL_MESSAGE = 102;
    public static final int SCROLL_MODE_NORMAL = 1;
    public static final int SCROLL_MODE_TOP = 2;
    public static final int SCROLL_MODE_BOTTOM = 3;
    private static final int DEFAULT_HISTORY_MESSAGE_COUNT = 30;
    private static final int DEFAULT_REMOTE_MESSAGE_COUNT = 10;
    private static final int TIP_DEFAULT_MESSAGE_COUNT = 2;
    public String mTargetId;
    public ConversationType mConversationType;
    private long indexMessageTime;
    private boolean directionDown;
    private boolean mReadRec;
    private boolean mSyncReadStatus;
    private int mNewMessageCount;
    private AutoRefreshListView mList;
    private TextView mButton;
    private LinearLayout mUnreadMsgLayout;
    private TextView mUnreadMsgCount;
    private ImageButton mNewMessageBtn;
    private TextView mNewMessageTextView;
    private MessageListAdapter mListAdapter;
    private View mMsgListView;
    private LinearLayout mNotificationContainer;
    private boolean mHasMoreLocalMessagesUp = true;
    private boolean mHasMoreLocalMessagesDown = true;
    private int mLastMentionMsgId;
    private long mSyncReadStatusMsgTime;
    private boolean mCSNeedToQuit = false;
    private List<String> mLocationShareParticipants;
    private CustomServiceConfig mCustomServiceConfig;
    private CSEvaluateDialog mEvaluateDialg;
    private RongKitReceiver mKitReceiver;
    private final int CS_HUMAN_MODE_CUSTOMER_EXPIRE = 0;
    private final int CS_HUMAN_MODE_SEAT_EXPIRE = 1;
    private boolean robotType = true;
    private long csEnterTime;
    private boolean csEvaluate = true;
    ICustomServiceListener customServiceListener = new ICustomServiceListener() {
        public void onSuccess(CustomServiceConfig config) {
            CusConversationFragment.this.mCustomServiceConfig = config;
            if(config.isBlack) {
                CusConversationFragment.this.onCustomServiceWarning(CusConversationFragment.this.getString(string.rc_blacklist_prompt), false, CusConversationFragment.this.robotType);
            }

            if(config.robotSessionNoEva) {
                CusConversationFragment.this.csEvaluate = false;
                CusConversationFragment.this.mListAdapter.setEvaluateForRobot(true);
            }

            if(CusConversationFragment.this.mRongExtension != null) {
                if(config.evaEntryPoint.equals(CSEvaEntryPoint.EVA_EXTENSION)) {
                    CusConversationFragment.this.mRongExtension.addPlugin(new EvaluatePlugin(CusConversationFragment.this.mCustomServiceConfig.isReportResolveStatus));
                }

                if(config.isDisableLocation) {
                    List i = CusConversationFragment.this.mRongExtension.getPluginModules();
                    IPluginModule uiMessage = null;

                    for(int i1 = 0; i1 < i.size(); ++i1) {
                        if(i.get(i1) instanceof DefaultLocationPlugin) {
                            uiMessage = (IPluginModule)i.get(i1);
                        }
                    }

                    if(uiMessage != null) {
                        CusConversationFragment.this.mRongExtension.removePlugin(uiMessage);
                    }
                }
            }

            if(config.quitSuspendType.equals(CSQuitSuspendType.NONE)) {
                try {
                    CusConversationFragment.this.mCSNeedToQuit = RongContext.getInstance().getResources().getBoolean(bool.rc_stop_custom_service_when_quit);
                } catch (NotFoundException var5) {
                    var5.printStackTrace();
                }
            } else {
                CusConversationFragment.this.mCSNeedToQuit = config.quitSuspendType.equals(CSQuitSuspendType.SUSPEND);
            }

            for(int var6 = 0; var6 < CusConversationFragment.this.mListAdapter.getCount(); ++var6) {
                UIMessage var7 = (UIMessage)CusConversationFragment.this.mListAdapter.getItem(var6);
                if(var7.getContent() instanceof CSPullLeaveMessage) {
                    var7.setCsConfig(config);
                }
            }

            CusConversationFragment.this.mListAdapter.notifyDataSetChanged();
        }

        public void onError(int code, String msg) {
            CusConversationFragment.this.onCustomServiceWarning(msg, false, CusConversationFragment.this.robotType);
        }

        public void onModeChanged(CustomServiceMode mode) {
            if(CusConversationFragment.this.mRongExtension != null && CusConversationFragment.this.isActivityExist()) {
                CusConversationFragment.this.mRongExtension.setExtensionBarMode(mode);
                if(!mode.equals(CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN) && !mode.equals(CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN_FIRST)) {
                    if(mode.equals(CustomServiceMode.CUSTOM_SERVICE_MODE_NO_SERVICE)) {
                        CusConversationFragment.this.csEvaluate = false;
                    }
                } else {
                    if(CusConversationFragment.this.mCustomServiceConfig.userTipTime > 0 && !TextUtils.isEmpty(CusConversationFragment.this.mCustomServiceConfig.userTipWord)) {
                        CusConversationFragment.this.startTimer(0, CusConversationFragment.this.mCustomServiceConfig.userTipTime * 60 * 1000);
                    }

                    if(CusConversationFragment.this.mCustomServiceConfig.adminTipTime > 0 && !TextUtils.isEmpty(CusConversationFragment.this.mCustomServiceConfig.adminTipWord)) {
                        CusConversationFragment.this.startTimer(1, CusConversationFragment.this.mCustomServiceConfig.adminTipTime * 60 * 1000);
                    }

                    CusConversationFragment.this.robotType = false;
                    CusConversationFragment.this.csEvaluate = true;
                }

            }
        }

        public void onQuit(String msg) {
            RLog.i("CusConversationFragment", "CustomService onQuit.");
            if(CusConversationFragment.this.getActivity() != null) {
                if(CusConversationFragment.this.mCustomServiceConfig.evaEntryPoint.equals(CSEvaEntryPoint.EVA_END) && !CusConversationFragment.this.robotType) {
                    CusConversationFragment.this.csQuitEvaluate(msg);
                } else {
                    CusConversationFragment.this.csQuit(msg);
                }

            }
        }

        public void onPullEvaluation(String dialogId) {
            if(CusConversationFragment.this.mEvaluateDialg == null) {
                CusConversationFragment.this.onCustomServiceEvaluation(true, dialogId, CusConversationFragment.this.robotType, CusConversationFragment.this.csEvaluate);
            }

        }

        public void onSelectGroup(List<CSGroupItem> groups) {
            CusConversationFragment.this.onSelectCustomerServiceGroup(groups);
        }
    };

    public CusConversationFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RLog.i("CusConversationFragment", "onCreate");
        InternalModuleManager.getInstance().onLoaded();

        try {
            this.mEnableMention = this.getActivity().getResources().getBoolean(bool.rc_enable_mentioned_message);
        } catch (NotFoundException var6) {
            RLog.e("CusConversationFragment", "rc_enable_mentioned_message not found in rc_config.xml");
        }

        try {
            this.mReadRec = this.getResources().getBoolean(bool.rc_read_receipt);
            this.mSyncReadStatus = this.getResources().getBoolean(bool.rc_enable_sync_read_status);
        } catch (NotFoundException var5) {
            RLog.e("CusConversationFragment", "rc_read_receipt not found in rc_config.xml");
            var5.printStackTrace();
        }

        this.mKitReceiver = new RongKitReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");
        filter.addAction("android.intent.action.NEW_OUTGOING_CALL");

        try {
            this.getActivity().registerReceiver(this.mKitReceiver, filter);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public TextView getButton(){
        return this.mButton;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(layout.rc_fr_conversation, container, false);
        this.mRongExtension = (RongExtension)view.findViewById(id.rc_extension);
        this.mRongExtension.setFragment(this);
        this.mOffsetLimit = 70.0F * this.getActivity().getResources().getDisplayMetrics().density;
        this.mMsgListView = this.findViewById(view, id.rc_layout_msg_list);
        this.mList = (AutoRefreshListView)this.findViewById(this.mMsgListView, id.rc_list);
        this.mButton = (TextView)this.findViewById(this.mMsgListView, id.rc_btn_bottom);
        this.mList.requestDisallowInterceptTouchEvent(true);
        this.mList.setMode(Mode.BOTH);
        this.mListAdapter = this.onResolveAdapter(this.getActivity());
        this.mList.setAdapter(this.mListAdapter);
        this.mList.setOnRefreshListener(new OnRefreshListener() {
            public void onRefreshFromStart() {
                if(CusConversationFragment.this.mHasMoreLocalMessagesUp) {
                    CusConversationFragment.this.getHistoryMessage(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, 30, Mode.START, 1);
                } else {
                    CusConversationFragment.this.getRemoteHistoryMessages(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, 10);
                }

            }

            public void onRefreshFromEnd() {
                if(CusConversationFragment.this.mHasMoreLocalMessagesDown && CusConversationFragment.this.indexMessageTime > 0L) {
                    CusConversationFragment.this.getHistoryMessage(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, 30, Mode.END, 1);
                } else {
                    CusConversationFragment.this.mList.onRefreshComplete(0, 0, false);
                }

            }
        });
//        this.mButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), MainActivity.class));
//            }
//        });
        this.mList.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == 2 && CusConversationFragment.this.mList.getCount() - CusConversationFragment.this.mList.getHeaderViewsCount() - CusConversationFragment.this.mList.getFooterViewsCount() == 0) {
                    if(CusConversationFragment.this.mHasMoreLocalMessagesUp) {
                        CusConversationFragment.this.getHistoryMessage(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, 30, Mode.START, 1);
                    } else if(CusConversationFragment.this.mList.getRefreshState() != State.REFRESHING) {
                        CusConversationFragment.this.getRemoteHistoryMessages(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, 10);
                    }

                    return true;
                } else {
                    if(event.getAction() == 1 && CusConversationFragment.this.mRongExtension != null && CusConversationFragment.this.mRongExtension.isExtensionExpanded()) {
                        CusConversationFragment.this.mRongExtension.collapseExtension();
                    }

                    return false;
                }
            }
        });
        if(RongContext.getInstance().getNewMessageState()) {
            this.mNewMessageTextView = (TextView)this.findViewById(view, id.rc_new_message_number);
            this.mNewMessageBtn = (ImageButton)this.findViewById(view, id.rc_new_message_count);
            this.mNewMessageBtn.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    CusConversationFragment.this.mList.setSelection(CusConversationFragment.this.mListAdapter.getCount());
                    CusConversationFragment.this.mNewMessageBtn.setVisibility(8);
                    CusConversationFragment.this.mNewMessageTextView.setVisibility(8);
                    CusConversationFragment.this.mNewMessageCount = 0;
                }
            });
        }

        if(RongContext.getInstance().getUnreadMessageState()) {
            this.mUnreadMsgLayout = (LinearLayout)this.findViewById(this.mMsgListView, id.rc_unread_message_layout);
            this.mUnreadMsgCount = (TextView)this.findViewById(this.mMsgListView, id.rc_unread_message_count);
        }

        this.mList.addOnScrollListener(this);
        this.mListAdapter.setOnItemHandlerListener(new OnItemHandlerListener() {
            public boolean onWarningViewClick(final int position, final Message data, View v) {
                RongIMClient.getInstance().deleteMessages(new int[]{data.getMessageId()}, new ResultCallback() {

                    @Override
                    public void onSuccess(Object o) {
                        Boolean aBoolean = (Boolean) o;
                        if(aBoolean.booleanValue()) {
                            CusConversationFragment.this.mListAdapter.remove(position);
                            data.setMessageId(0);
                            CusConversationFragment.this.onResendItemClick(data);
                        }
                    }

                    public void onError(ErrorCode e) {
                    }
                });
                return true;
            }

            public void onReadReceiptStateClick(Message message) {
                CusConversationFragment.this.onReadReceiptStateClick(message);
            }
        });
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                Rect r = new Rect();
                view.getWindowVisibleDisplayFrame(r);
                int screenHeight = view.getRootView().getHeight();
                int keypadHeight = screenHeight - r.bottom;
                if((double)keypadHeight > (double)screenHeight * 0.15D) {
                    CusConversationFragment.this.mList.setSelection(CusConversationFragment.this.mListAdapter.getCount());
                    if(CusConversationFragment.this.mNewMessageCount > 0) {
                        CusConversationFragment.this.mNewMessageCount = 0;
                        CusConversationFragment.this.mNewMessageBtn.setVisibility(8);
                        CusConversationFragment.this.mNewMessageTextView.setVisibility(8);
                    }
                }

            }
        });
        return view;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(scrollState == 1) {
            if(this.mRongExtension != null) {
                this.mRongExtension.collapseExtension();
            }
        } else if(scrollState == 0) {
            int last = this.mList.getLastVisiblePosition();
            if(this.mNewMessageBtn != null && last == this.mList.getCount() - 1) {
                this.mNewMessageCount = 0;
                this.mNewMessageBtn.setVisibility(8);
                this.mNewMessageTextView.setVisibility(8);
            }
        }

    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }

    public void onResume() {
        RongPushClient.clearAllPushNotifications(this.getActivity());
        super.onResume();
    }

    public final void getUserInfo(String userId, UserInfoCallback callback) {
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(userId);
        if(userInfo != null) {
            callback.onGotUserInfo(userInfo);
        }

    }

    public MessageListAdapter onResolveAdapter(Context context) {
        return new MessageListAdapter(context);
    }

    protected void initFragment(Uri uri) {
        this.indexMessageTime = this.getActivity().getIntent().getLongExtra("indexMessageTime", 0L);
        RLog.d("CusConversationFragment", "initFragment : " + uri + ",this=" + this + ", time = " + this.indexMessageTime);
        if(uri != null) {
            String mode = uri.getLastPathSegment().toUpperCase(Locale.US);
            this.mConversationType = ConversationType.valueOf(mode);
            this.mTargetId = uri.getQueryParameter("targetId");
            this.mRongExtension.setConversation(this.mConversationType, this.mTargetId);
            RongIMClient.getInstance().getTextMessageDraft(this.mConversationType, this.mTargetId, new ResultCallback() {

                @Override
                public void onSuccess(Object o) {
                    String s = (String) o;
                    CusConversationFragment.this.mDraft = s;
                    if(CusConversationFragment.this.mRongExtension != null) {
                        EditText editText = CusConversationFragment.this.mRongExtension.getInputEditText();
                        editText.setText(s);
                        editText.setSelection(editText.length());
                        CusConversationFragment.this.mRongExtension.setExtensionClickListener(CusConversationFragment.this);
                    }
                }

                public void onError(ErrorCode e) {
                    if(CusConversationFragment.this.mRongExtension != null) {
                        CusConversationFragment.this.mRongExtension.setExtensionClickListener(CusConversationFragment.this);
                    }

                }
            });
            this.mCurrentConversationInfo = ConversationInfo.obtain(this.mConversationType, this.mTargetId);
            RongContext.getInstance().registerConversationInfo(this.mCurrentConversationInfo);
            this.mNotificationContainer = (LinearLayout)this.mMsgListView.findViewById(id.rc_notification_container);
            if(this.mConversationType.equals(ConversationType.CUSTOMER_SERVICE) && this.getActivity() != null && this.getActivity().getIntent() != null && this.getActivity().getIntent().getData() != null) {
                this.mCustomUserInfo = (CSCustomServiceInfo)this.getActivity().getIntent().getParcelableExtra("customServiceInfo");
            }

            LocationManager.getInstance().bindConversation(this.getActivity(), this.mConversationType, this.mTargetId);
            LocationManager.getInstance().setUserInfoProvider(this);
            LocationManager.getInstance().setParticipantChangedListener(new IRealTimeLocationStateListener() {
                private View mRealTimeBar;
                private TextView mRealTimeText;

                public void onParticipantChanged(List<String> userIdList) {
                    if(!CusConversationFragment.this.isDetached()) {
                        if(this.mRealTimeBar == null) {
                            this.mRealTimeBar = CusConversationFragment.this.inflateNotificationView(layout.rc_notification_realtime_location);
                            this.mRealTimeText = (TextView)this.mRealTimeBar.findViewById(id.real_time_location_text);
                            this.mRealTimeBar.setOnClickListener(new OnClickListener() {
                                public void onClick(View v) {
                                    RealTimeLocationStatus status = RongIMClient.getInstance().getRealTimeLocationCurrentState(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId);
                                    if(status == RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_INCOMING) {
                                        PromptPopupDialog intent = PromptPopupDialog.newInstance(CusConversationFragment.this.getActivity(), "", CusConversationFragment.this.getResources().getString(string.rc_real_time_join_notification));
                                        intent.setPromptButtonClickedListener(new OnPromptButtonClickedListener() {
                                            public void onPositiveButtonClicked() {
                                                int result = LocationManager.getInstance().joinLocationSharing();
                                                if(result == 0) {
                                                    Intent intent = new Intent(CusConversationFragment.this.getActivity(), AMapRealTimeActivity.class);
                                                    if(CusConversationFragment.this.mLocationShareParticipants != null) {
                                                        intent.putStringArrayListExtra("participants", (ArrayList)CusConversationFragment.this.mLocationShareParticipants);
                                                    }

                                                    CusConversationFragment.this.startActivity(intent);
                                                } else if(result == 1) {
                                                    Toast.makeText(CusConversationFragment.this.getActivity(), string.rc_network_exception, 0).show();
                                                } else if(result == 2) {
                                                    Toast.makeText(CusConversationFragment.this.getActivity(), string.rc_location_sharing_exceed_max, 0).show();
                                                }

                                            }
                                        });
                                        intent.show();
                                    } else {
                                        Intent intent1 = new Intent(CusConversationFragment.this.getActivity(), AMapRealTimeActivity.class);
                                        if(CusConversationFragment.this.mLocationShareParticipants != null) {
                                            intent1.putStringArrayListExtra("participants", (ArrayList)CusConversationFragment.this.mLocationShareParticipants);
                                        }

                                        CusConversationFragment.this.startActivity(intent1);
                                    }

                                }
                            });
                        }

                        CusConversationFragment.this.mLocationShareParticipants = userIdList;
                        if(userIdList != null) {
                            if(userIdList.size() == 0) {
                                CusConversationFragment.this.hideNotificationView(this.mRealTimeBar);
                            } else {
                                if(userIdList.size() == 1 && userIdList.contains(RongIM.getInstance().getCurrentUserId())) {
                                    this.mRealTimeText.setText(CusConversationFragment.this.getResources().getString(string.rc_you_are_sharing_location));
                                } else if(userIdList.size() == 1 && !userIdList.contains(RongIM.getInstance().getCurrentUserId())) {
                                    this.mRealTimeText.setText(String.format(CusConversationFragment.this.getResources().getString(string.rc_other_is_sharing_location), new Object[]{CusConversationFragment.this.getNameFromCache((String)userIdList.get(0))}));
                                } else {
                                    this.mRealTimeText.setText(String.format(CusConversationFragment.this.getResources().getString(string.rc_others_are_sharing_location), new Object[]{Integer.valueOf(userIdList.size())}));
                                }

                                CusConversationFragment.this.showNotificationView(this.mRealTimeBar);
                            }
                        } else {
                            CusConversationFragment.this.hideNotificationView(this.mRealTimeBar);
                        }

                    }
                }

                public void onErrorException() {
                    if(!CusConversationFragment.this.isDetached()) {
                        CusConversationFragment.this.hideNotificationView(this.mRealTimeBar);
                        if(CusConversationFragment.this.mLocationShareParticipants != null) {
                            CusConversationFragment.this.mLocationShareParticipants.clear();
                            CusConversationFragment.this.mLocationShareParticipants = null;
                        }
                    }

                }
            });
            if(this.mConversationType.equals(ConversationType.CHATROOM)) {
                boolean scrollMode = this.isActivityExist() && this.getActivity().getIntent().getBooleanExtra("createIfNotExist", true);
                int message = this.getResources().getInteger(integer.rc_chatroom_first_pull_message_count);
                if(scrollMode) {
                    RongIMClient.getInstance().joinChatRoom(this.mTargetId, message, new OperationCallback() {
                        public void onSuccess() {
                            RLog.i("CusConversationFragment", "joinChatRoom onSuccess : " + CusConversationFragment.this.mTargetId);
                        }

                        public void onError(ErrorCode errorCode) {
                            RLog.e("CusConversationFragment", "joinChatRoom onError : " + errorCode);
                            if(CusConversationFragment.this.isActivityExist()) {
                                if(errorCode != ErrorCode.RC_NET_UNAVAILABLE && errorCode != ErrorCode.RC_NET_CHANNEL_INVALID) {
                                    CusConversationFragment.this.onWarningDialog(CusConversationFragment.this.getString(string.rc_join_chatroom_failure));
                                } else {
                                    CusConversationFragment.this.onWarningDialog(CusConversationFragment.this.getString(string.rc_notice_network_unavailable));
                                }
                            }

                        }
                    });
                } else {
                    RongIMClient.getInstance().joinExistChatRoom(this.mTargetId, message, new OperationCallback() {
                        public void onSuccess() {
                            RLog.i("CusConversationFragment", "joinExistChatRoom onSuccess : " + CusConversationFragment.this.mTargetId);
                        }

                        public void onError(ErrorCode errorCode) {
                            RLog.e("CusConversationFragment", "joinExistChatRoom onError : " + errorCode);
                            if(CusConversationFragment.this.isActivityExist()) {
                                if(errorCode != ErrorCode.RC_NET_UNAVAILABLE && errorCode != ErrorCode.RC_NET_CHANNEL_INVALID) {
                                    CusConversationFragment.this.onWarningDialog(CusConversationFragment.this.getString(string.rc_join_chatroom_failure));
                                } else {
                                    CusConversationFragment.this.onWarningDialog(CusConversationFragment.this.getString(string.rc_notice_network_unavailable));
                                }
                            }

                        }
                    });
                }
            } else if(this.mConversationType != ConversationType.APP_PUBLIC_SERVICE && this.mConversationType != ConversationType.PUBLIC_SERVICE) {
                if(this.mConversationType.equals(ConversationType.CUSTOMER_SERVICE)) {
                    this.onStartCustomService(this.mTargetId);
                } else if(this.mEnableMention && (this.mConversationType.equals(ConversationType.DISCUSSION) || this.mConversationType.equals(ConversationType.GROUP))) {
                    RongMentionManager.getInstance().createInstance(this.mConversationType, this.mTargetId, this.mRongExtension.getInputEditText());
                }
            } else {
                PublicServiceCommandMessage scrollMode1 = new PublicServiceCommandMessage();
                scrollMode1.setCommand(PublicServiceMenuItemType.Entry.getMessage());
                Message message1 = Message.obtain(this.mTargetId, this.mConversationType, scrollMode1);
                RongIMClient.getInstance().sendMessage(message1, (String)null, (String)null, new ISendMessageCallback() {
                    public void onAttached(Message message) {
                    }

                    public void onSuccess(Message message) {
                    }

                    public void onError(Message message, ErrorCode errorCode) {
                    }
                });
                PublicServiceType publicServiceType;
                if(this.mConversationType == ConversationType.PUBLIC_SERVICE) {
                    publicServiceType = PublicServiceType.PUBLIC_SERVICE;
                } else {
                    publicServiceType = PublicServiceType.APP_PUBLIC_SERVICE;
                }

                RongIM.getInstance().getPublicServiceProfile(publicServiceType, this.mTargetId, new ResultCallback() {

                    @Override
                    public void onSuccess(Object o) {
                        PublicServiceProfile publicServiceProfile = (PublicServiceProfile) o;
                        ArrayList inputMenuList = new ArrayList();
                        PublicServiceMenu menu = publicServiceProfile.getMenu();
                        ArrayList items = menu != null?menu.getMenuItems():null;
                        if(items != null && CusConversationFragment.this.mRongExtension != null) {
                            CusConversationFragment.this.mPublicServiceProfile = publicServiceProfile;
                            Iterator var5 = items.iterator();

                            while(var5.hasNext()) {
                                PublicServiceMenuItem item = (PublicServiceMenuItem)var5.next();
                                InputMenu inputMenu = new InputMenu();
                                inputMenu.title = item.getName();
                                inputMenu.subMenuList = new ArrayList();
                                Iterator var8 = item.getSubMenuItems().iterator();

                                while(var8.hasNext()) {
                                    PublicServiceMenuItem i = (PublicServiceMenuItem)var8.next();
                                    inputMenu.subMenuList.add(i.getName());
                                }

                                inputMenuList.add(inputMenu);
                            }

                            CusConversationFragment.this.mRongExtension.setInputMenu(inputMenuList, true);
                        }
                    }

                    public void onError(ErrorCode e) {
                    }
                });
            }
        }

        RongIMClient.getInstance().getConversation(this.mConversationType, this.mTargetId, new ResultCallback() {

            @Override
            public void onSuccess(Object o) {
                Conversation conversation = (Conversation) o;
                if(conversation != null && CusConversationFragment.this.isActivityExist()) {
                    final int unreadCount = conversation.getUnreadMessageCount();
                    if(unreadCount > 0) {
                        if(CusConversationFragment.this.mReadRec && CusConversationFragment.this.mConversationType == ConversationType.PRIVATE && RongContext.getInstance().isReadReceiptConversationType(ConversationType.PRIVATE)) {
                            RongIMClient.getInstance().sendReadReceiptMessage(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, conversation.getSentTime());
                        }

                        if(CusConversationFragment.this.mSyncReadStatus && (CusConversationFragment.this.mConversationType == ConversationType.PRIVATE || CusConversationFragment.this.mConversationType == ConversationType.GROUP || CusConversationFragment.this.mConversationType == ConversationType.DISCUSSION)) {
                            RongIMClient.getInstance().syncConversationReadStatus(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, conversation.getSentTime(), (OperationCallback)null);
                        }
                    }

                    if(conversation.getMentionedCount() > 0) {
                        CusConversationFragment.this.getLastMentionedMessageId(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId);
                    } else {
                        RongIM.getInstance().clearMessagesUnreadStatus(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, (ResultCallback)null);
                    }

                    if(unreadCount > 10 && CusConversationFragment.this.mUnreadMsgLayout != null) {
                        if(unreadCount > 150) {
                            CusConversationFragment.this.mUnreadMsgCount.setText(String.format("%s%s", new Object[]{"150+", CusConversationFragment.this.getActivity().getResources().getString(string.rc_new_messages)}));
                        } else {
                            CusConversationFragment.this.mUnreadMsgCount.setText(String.format("%s%s", new Object[]{Integer.valueOf(unreadCount), CusConversationFragment.this.getActivity().getResources().getString(string.rc_new_messages)}));
                        }

                        final Runnable overtimeRunnable = new Runnable() {
                            public void run() {
                                TranslateAnimation animation = new TranslateAnimation(0.0F, 700.0F, 0.0F, 0.0F);
                                animation.setDuration(700L);
                                animation.setFillAfter(true);
                                CusConversationFragment.this.mUnreadMsgLayout.startAnimation(animation);
                            }
                        };
                        CusConversationFragment.this.mUnreadMsgLayout.setOnClickListener(new OnClickListener() {
                            public void onClick(View v) {
                                CusConversationFragment.this.mUnreadMsgLayout.setClickable(false);
                                CusConversationFragment.this.getHandler().removeCallbacks(overtimeRunnable);
                                TranslateAnimation animation = new TranslateAnimation(0.0F, 500.0F, 0.0F, 0.0F);
                                animation.setDuration(500L);
                                CusConversationFragment.this.mUnreadMsgLayout.startAnimation(animation);
                                animation.setFillAfter(true);
                                animation.setAnimationListener(new AnimationListener() {
                                    public void onAnimationStart(Animation animation) {
                                    }

                                    public void onAnimationEnd(Animation animation) {
                                        CusConversationFragment.this.mUnreadMsgLayout.setVisibility(8);
                                        if(unreadCount <= 30) {
                                            if(CusConversationFragment.this.mList.getCount() < 30) {
                                                CusConversationFragment.this.mList.setSelection(CusConversationFragment.this.mListAdapter.getCount() - unreadCount);
                                            } else {
                                                CusConversationFragment.this.mList.setSelection(30 - unreadCount);
                                            }
                                        } else if(unreadCount > 30) {
                                            CusConversationFragment.this.getHistoryMessage(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, unreadCount - 30 - 1, Mode.START, 2);
                                        }

                                    }

                                    public void onAnimationRepeat(Animation animation) {
                                    }
                                });
                            }
                        });
                        TranslateAnimation translateAnimation = new TranslateAnimation(300.0F, 0.0F, 0.0F, 0.0F);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
                        translateAnimation.setDuration(1000L);
                        alphaAnimation.setDuration(2000L);
                        AnimationSet set = new AnimationSet(true);
                        set.addAnimation(translateAnimation);
                        set.addAnimation(alphaAnimation);
                        CusConversationFragment.this.mUnreadMsgLayout.setVisibility(0);
                        CusConversationFragment.this.mUnreadMsgLayout.startAnimation(set);
                        set.setAnimationListener(new AnimationListener() {
                            public void onAnimationStart(Animation animation) {
                            }

                            public void onAnimationEnd(Animation animation) {
                                CusConversationFragment.this.getHandler().postDelayed(overtimeRunnable, 4000L);
                            }

                            public void onAnimationRepeat(Animation animation) {
                            }
                        });
                    }
                }
            }

            public void onError(ErrorCode e) {
            }
        });
        Mode mode1 = this.indexMessageTime > 0L? Mode.END: Mode.START;
        int scrollMode2 = this.indexMessageTime > 0L?1:3;
        this.getHistoryMessage(this.mConversationType, this.mTargetId, 30, mode1, scrollMode2);
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

    }

    public void hideNotificationView(View notificationView) {
        if(notificationView != null) {
            View view = this.mNotificationContainer.findViewById(notificationView.getId());
            if(view != null) {
                this.mNotificationContainer.removeView(view);
                if(this.mNotificationContainer.getChildCount() == 0) {
                    this.mNotificationContainer.setVisibility(8);
                }
            }

        }
    }

    public void showNotificationView(View notificationView) {
        if(notificationView != null) {
            View view = this.mNotificationContainer.findViewById(notificationView.getId());
            if(view == null) {
                this.mNotificationContainer.addView(notificationView);
                this.mNotificationContainer.setVisibility(0);
            }
        }
    }

    public View inflateNotificationView(@LayoutRes int layout) {
        return LayoutInflater.from(this.getActivity()).inflate(layout, this.mNotificationContainer, false);
    }

    public void onResendItemClick(Message message) {
        if(message.getContent() instanceof ImageMessage) {
            ImageMessage mediaMessageContent = (ImageMessage)message.getContent();
            if(mediaMessageContent.getRemoteUri() != null && !mediaMessageContent.getRemoteUri().toString().startsWith("file")) {
                RongIM.getInstance().sendMessage(message, (String)null, (String)null, (ISendMediaMessageCallback)null);
            } else {
                RongIM.getInstance().sendImageMessage(message, (String)null, (String)null, (SendImageMessageCallback)null);
            }
        } else if(message.getContent() instanceof LocationMessage) {
            RongIM.getInstance().sendLocationMessage(message, (String)null, (String)null, (ISendMessageCallback)null);
        } else if(message.getContent() instanceof MediaMessageContent) {
            MediaMessageContent mediaMessageContent1 = (MediaMessageContent)message.getContent();
            if(mediaMessageContent1.getMediaUrl() != null) {
                RongIM.getInstance().sendMessage(message, (String)null, (String)null, (ISendMediaMessageCallback)null);
            } else {
                RongIM.getInstance().sendMediaMessage(message, (String)null, (String)null, (ISendMediaMessageCallback)null);
            }
        } else {
            RongIM.getInstance().sendMessage(message, (String)null, (String)null, (ISendMessageCallback)null);
        }

    }

    public void onReadReceiptStateClick(Message message) {
    }

    public void onSelectCustomerServiceGroup(final List<CSGroupItem> groupList) {
        if(!this.isActivityExist()) {
            RLog.w("CusConversationFragment", "onSelectCustomerServiceGroup Activity has finished");
        } else {
            ArrayList singleDataList = new ArrayList();
            singleDataList.clear();

            for(int i = 0; i < groupList.size(); ++i) {
                if(((CSGroupItem)groupList.get(i)).getOnline()) {
                    singleDataList.add(((CSGroupItem)groupList.get(i)).getName());
                }
            }

            if(singleDataList.size() == 0) {
                RongIMClient.getInstance().selectCustomServiceGroup(this.mTargetId, (String)null);
            } else {
                final SingleChoiceDialog singleChoiceDialog = new SingleChoiceDialog(this.getActivity(), singleDataList);
                singleChoiceDialog.setTitle(this.getActivity().getResources().getString(string.rc_cs_select_group));
                singleChoiceDialog.setOnOKButtonListener(new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int selItem = singleChoiceDialog.getSelectItem();
                        RongIMClient.getInstance().selectCustomServiceGroup(CusConversationFragment.this.mTargetId, ((CSGroupItem)groupList.get(selItem)).getId());
                    }
                });
                singleChoiceDialog.setOnCancelButtonListener(new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        RongIMClient.getInstance().selectCustomServiceGroup(CusConversationFragment.this.mTargetId, (String)null);
                    }
                });
                singleChoiceDialog.show();
            }
        }
    }

    private void csQuit(String msg) {
        if(this.getHandler() != null) {
            this.getHandler().removeCallbacksAndMessages((Object)null);
        }

        if(this.mEvaluateDialg == null) {
            this.onCustomServiceWarning(msg, this.mCustomServiceConfig.quitSuspendType == CSQuitSuspendType.NONE, this.robotType);
        } else {
            this.mEvaluateDialg.destroy();
        }

        if(!this.mCustomServiceConfig.quitSuspendType.equals(CSQuitSuspendType.NONE)) {
            RongContext.getInstance().getEventBus().post(new CSTerminateEvent(this.getActivity(), msg));
        }

    }

    private void csQuitEvaluateButtonClick(String msg) {
        if(this.mEvaluateDialg != null) {
            this.mEvaluateDialg.destroy();
            this.mEvaluateDialg = null;
        }

        if(this.getHandler() != null) {
            this.getHandler().removeCallbacksAndMessages((Object)null);
        }

        if(this.mEvaluateDialg == null) {
            this.onCustomServiceWarning(msg, false, this.robotType);
        } else {
            this.mEvaluateDialg.destroy();
        }

        if(!this.mCustomServiceConfig.quitSuspendType.equals(CSQuitSuspendType.NONE)) {
            RongContext.getInstance().getEventBus().post(new CSTerminateEvent(this.getActivity(), msg));
        }

    }

    private void csQuitEvaluate(final String msg) {
        if(this.mEvaluateDialg == null) {
            this.mEvaluateDialg = new CSEvaluateDialog(this.getContext(), this.mTargetId);
            this.mEvaluateDialg.setClickListener(new EvaluateClickListener() {
                public void onEvaluateSubmit() {
                    CusConversationFragment.this.csQuitEvaluateButtonClick(msg);
                }

                public void onEvaluateCanceled() {
                    CusConversationFragment.this.csQuitEvaluateButtonClick(msg);
                }
            });
            this.mEvaluateDialg.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    if(CusConversationFragment.this.mEvaluateDialg != null) {
                        CusConversationFragment.this.mEvaluateDialg = null;
                    }

                }
            });
            this.mEvaluateDialg.showStar("");
        }

    }

    public void onPause() {
        this.finishing = this.getActivity().isFinishing();
        if(this.finishing) {
            this.destroy();
        }

        super.onPause();
    }

    private void destroy() {
        RongIM.getInstance().clearMessagesUnreadStatus(this.mConversationType, this.mTargetId, (ResultCallback)null);
        if(this.getHandler() != null) {
            this.getHandler().removeCallbacksAndMessages((Object)null);
        }

        if(this.mEnableMention && (this.mConversationType.equals(ConversationType.DISCUSSION) || this.mConversationType.equals(ConversationType.GROUP))) {
            RongMentionManager.getInstance().destroyInstance(this.mConversationType, this.mTargetId);
        }

        if(this.mConversationType.equals(ConversationType.CHATROOM)) {
            SendImageManager.getInstance().cancelSendingImages(this.mConversationType, this.mTargetId);
            RongIM.getInstance().quitChatRoom(this.mTargetId, (OperationCallback)null);
        }

        if(this.mConversationType.equals(ConversationType.CUSTOMER_SERVICE) && this.mCSNeedToQuit) {
            this.onStopCustomService(this.mTargetId);
        }

        if(this.mSyncReadStatus && this.mSyncReadStatusMsgTime > 0L && (this.mConversationType.equals(ConversationType.DISCUSSION) || this.mConversationType.equals(ConversationType.GROUP))) {
            RongIMClient.getInstance().syncConversationReadStatus(this.mConversationType, this.mTargetId, this.mSyncReadStatusMsgTime, (OperationCallback)null);
        }

        EventBus.getDefault().unregister(this);
        AudioPlayManager.getInstance().stopPlay();
        AudioRecordManager.getInstance().destroyRecord();

        try {
            if(this.mKitReceiver != null) {
                this.getActivity().unregisterReceiver(this.mKitReceiver);
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        RongContext.getInstance().unregisterConversationInfo(this.mCurrentConversationInfo);
        LocationManager.getInstance().quitLocationSharing();
        LocationManager.getInstance().setParticipantChangedListener((IRealTimeLocationStateListener)null);
        LocationManager.getInstance().setUserInfoProvider((IUserInfoProvider)null);
        LocationManager.getInstance().unBindConversation();
        this.destroyExtension();
    }

    private void destroyExtension() {
        String text = this.mRongExtension.getInputEditText().getText().toString();
        if(TextUtils.isEmpty(text) && !TextUtils.isEmpty(this.mDraft) || !TextUtils.isEmpty(text) && TextUtils.isEmpty(this.mDraft) || !TextUtils.isEmpty(text) && !TextUtils.isEmpty(this.mDraft) && !text.equals(this.mDraft)) {
            RongIMClient.getInstance().saveTextMessageDraft(this.mConversationType, this.mTargetId, text, (ResultCallback)null);
            DraftEvent draft = new DraftEvent(this.mConversationType, this.mTargetId, text);
            RongContext.getInstance().getEventBus().post(draft);
        }

        this.mRongExtension.onDestroy();
        this.mRongExtension = null;
    }

    public void onDestroy() {
        if(!this.finishing) {
            this.destroy();
        }

        super.onDestroy();
    }

    public boolean isLocationSharing() {
        return LocationManager.getInstance().isSharing();
    }

    public void showQuitLocationSharingDialog(final Activity activity) {
        PromptPopupDialog.newInstance(activity, this.getString(string.rc_ext_warning), this.getString(string.rc_real_time_exit_notification), this.getString(string.rc_action_bar_ok)).setPromptButtonClickedListener(new OnPromptButtonClickedListener() {
            public void onPositiveButtonClicked() {
                activity.finish();
            }
        }).show();
    }

    public boolean onBackPressed() {
        if(this.mRongExtension != null && this.mRongExtension.isExtensionExpanded()) {
            this.mRongExtension.collapseExtension();
            return true;
        } else {
            return this.mConversationType != null && this.mCustomServiceConfig != null && this.mConversationType.equals(ConversationType.CUSTOMER_SERVICE) && this.mCustomServiceConfig.quitSuspendType.equals(CSQuitSuspendType.NONE)?this.onCustomServiceEvaluation(false, "", this.robotType, this.csEvaluate):false;
        }
    }

    public boolean handleMessage(android.os.Message msg) {
        InformationNotificationMessage info;
        switch(msg.what) {
            case 0:
                if(this.isActivityExist() && this.mCustomServiceConfig != null) {
                    info = new InformationNotificationMessage(this.mCustomServiceConfig.userTipWord);
                    RongIM.getInstance().insertMessage(ConversationType.CUSTOMER_SERVICE, this.mTargetId, this.mTargetId, info, System.currentTimeMillis(), (ResultCallback)null);
                    return true;
                }

                return true;
            case 1:
                if(this.isActivityExist() && this.mCustomServiceConfig != null) {
                    info = new InformationNotificationMessage(this.mCustomServiceConfig.adminTipWord);
                    RongIM.getInstance().insertMessage(ConversationType.CUSTOMER_SERVICE, this.mTargetId, this.mTargetId, info, System.currentTimeMillis(), (ResultCallback)null);
                    return true;
                }

                return true;
            default:
                return false;
        }
    }

    private boolean isActivityExist() {
        return this.getActivity() != null && !this.getActivity().isFinishing();
    }

    public void onWarningDialog(String msg) {
        Builder builder = new Builder(this.getActivity());
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setContentView(layout.rc_cs_alert_warning);
        TextView tv = (TextView)window.findViewById(id.rc_cs_msg);
        tv.setText(msg);
        window.findViewById(id.rc_btn_ok).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                alertDialog.dismiss();
                FragmentManager fm = CusConversationFragment.this.getChildFragmentManager();
                if(fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                } else {
                    CusConversationFragment.this.getActivity().finish();
                }

            }
        });
    }

    public void onCustomServiceWarning(String msg, final boolean evaluate, final boolean robotType) {
        if(!this.isActivityExist()) {
            RLog.w("CusConversationFragment", "Activity has finished");
        } else {
            Builder builder = new Builder(this.getActivity());
            builder.setCancelable(false);
            final AlertDialog alertDialog = builder.create();
            alertDialog.show();
            Window window = alertDialog.getWindow();
            window.setContentView(layout.rc_cs_alert_warning);
            TextView tv = (TextView)window.findViewById(id.rc_cs_msg);
            tv.setText(msg);
            window.findViewById(id.rc_btn_ok).setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService("input_method");
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    alertDialog.dismiss();
                    if(evaluate) {
                        CusConversationFragment.this.onCustomServiceEvaluation(false, "", robotType, evaluate);
                    } else {
                        FragmentManager fm = CusConversationFragment.this.getChildFragmentManager();
                        if(fm.getBackStackEntryCount() > 0) {
                            fm.popBackStack();
                        } else {
                            CusConversationFragment.this.getActivity().finish();
                        }
                    }

                }
            });
        }
    }

    public boolean onCustomServiceEvaluation(boolean isPullEva, String dialogId, boolean robotType, boolean evaluate) {
        if(this.isActivityExist()) {
            if(evaluate) {
                long fm = System.currentTimeMillis();
                int interval = 60;

                try {
                    interval = this.getActivity().getResources().getInteger(integer.rc_custom_service_evaluation_interval);
                } catch (NotFoundException var10) {
                    var10.printStackTrace();
                }

                if(fm - this.csEnterTime < (long)(interval * 1000) && !isPullEva) {
                    InputMethodManager imm = (InputMethodManager)this.getActivity().getSystemService("input_method");
                    if(imm != null && imm.isActive() && this.getActivity().getCurrentFocus() != null && this.getActivity().getCurrentFocus().getWindowToken() != null) {
                        imm.hideSoftInputFromWindow(this.getActivity().getCurrentFocus().getWindowToken(), 2);
                    }

                    FragmentManager fm1 = this.getChildFragmentManager();
                    if(fm1.getBackStackEntryCount() > 0) {
                        fm1.popBackStack();
                    } else {
                        this.getActivity().finish();
                    }

                    return false;
                }

                this.mEvaluateDialg = new CSEvaluateDialog(this.getContext(), this.mTargetId);
                this.mEvaluateDialg.setClickListener(this);
                this.mEvaluateDialg.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        if(CusConversationFragment.this.mEvaluateDialg != null) {
                            CusConversationFragment.this.mEvaluateDialg = null;
                        }

                    }
                });
                if(this.mCustomServiceConfig.evaluateType.equals(CSEvaType.EVA_UNIFIED)) {
                    this.mEvaluateDialg.showStarMessage(this.mCustomServiceConfig.isReportResolveStatus);
                } else if(robotType) {
                    this.mEvaluateDialg.showRobot(true);
                } else {
                    this.mEvaluateDialg.showStar(dialogId);
                }
            } else {
                FragmentManager fm2 = this.getChildFragmentManager();
                if(fm2.getBackStackEntryCount() > 0) {
                    fm2.popBackStack();
                } else {
                    this.getActivity().finish();
                }
            }
        }

        return true;
    }

    public void onSendToggleClick(View v, String text) {
        if(!TextUtils.isEmpty(text) && !TextUtils.isEmpty(text.trim())) {
            TextMessage textMessage = TextMessage.obtain(text);
            MentionedInfo mentionedInfo = RongMentionManager.getInstance().onSendButtonClick();
            if(mentionedInfo != null) {
                textMessage.setMentionedInfo(mentionedInfo);
            }

            Message message = Message.obtain(this.mTargetId, this.mConversationType, textMessage);
            RongIM.getInstance().sendMessage(message, (String)null, (String)null, (ISendMessageCallback)null);
        } else {
            RLog.e("CusConversationFragment", "text content must not be null");
        }
    }

    public void onImageResult(List<Uri> selectedImages, boolean origin) {
        SendImageManager.getInstance().sendImages(this.mConversationType, this.mTargetId, selectedImages, origin);
        if(this.mConversationType.equals(ConversationType.PRIVATE)) {
            RongIMClient.getInstance().sendTypingStatus(this.mConversationType, this.mTargetId, "RC:ImgMsg");
        }

    }

    public void onEditTextClick(EditText editText) {
    }

    public void onLocationResult(double lat, double lng, String poi, Uri thumb) {
        LocationMessage locationMessage = LocationMessage.obtain(lat, lng, poi, thumb);
        Message message = Message.obtain(this.mTargetId, this.mConversationType, locationMessage);
        RongIM.getInstance().sendLocationMessage(message, (String)null, (String)null, (ISendMessageCallback)null);
        if(this.mConversationType.equals(ConversationType.PRIVATE)) {
            RongIMClient.getInstance().sendTypingStatus(this.mConversationType, this.mTargetId, "RC:LBSMsg");
        }

    }

    public void onSwitchToggleClick(View v, ViewGroup inputBoard) {
        if(this.robotType) {
            RongIMClient.getInstance().switchToHumanMode(this.mTargetId);
        }

    }

    public void onVoiceInputToggleTouch(View v, MotionEvent event) {
        String[] permissions = new String[]{"android.permission.RECORD_AUDIO"};
        if(!PermissionCheckUtil.checkPermissions(this.getActivity(), permissions)) {
            if(event.getAction() == 0) {
                PermissionCheckUtil.requestPermissions(this, permissions, 100);
            }

        } else {
            if(event.getAction() == 0) {
                AudioManager mAudioManager = (AudioManager)this.getContext().getSystemService("audio");
                if(mAudioManager.getMode() != 0) {
                    Toast.makeText(this.getContext(), this.getContext().getString(string.rc_voip_occupying), 0).show();
                    return;
                }

                AudioPlayManager.getInstance().stopPlay();
                AudioRecordManager.getInstance().startRecord(v.getRootView(), this.mConversationType, this.mTargetId);
                this.mLastTouchY = event.getY();
                this.mUpDirection = false;
                ((Button)v).setText(string.rc_audio_input_hover);
            } else if(event.getAction() == 2) {
                if(this.mLastTouchY - event.getY() > this.mOffsetLimit && !this.mUpDirection) {
                    AudioRecordManager.getInstance().willCancelRecord();
                    this.mUpDirection = true;
                    ((Button)v).setText(string.rc_audio_input);
                } else if(event.getY() - this.mLastTouchY > -this.mOffsetLimit && this.mUpDirection) {
                    AudioRecordManager.getInstance().continueRecord();
                    this.mUpDirection = false;
                    ((Button)v).setText(string.rc_audio_input_hover);
                }
            } else if(event.getAction() == 1 || event.getAction() == 3) {
                AudioRecordManager.getInstance().stopRecord();
                ((Button)v).setText(string.rc_audio_input);
            }

            if(this.mConversationType.equals(ConversationType.PRIVATE)) {
                RongIMClient.getInstance().sendTypingStatus(this.mConversationType, this.mTargetId, "RC:VcMsg");
            }

        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 100 && grantResults[0] != 0) {
            Toast.makeText(this.getActivity(), this.getResources().getString(string.rc_permission_grant_needed), 0).show();
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onEmoticonToggleClick(View v, ViewGroup extensionBoard) {
    }

    public void onPluginToggleClick(View v, ViewGroup extensionBoard) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int cursor;
        int offset;
        if(count == 0) {
            cursor = start + before;
            offset = -before;
        } else {
            cursor = start;
            offset = count;
        }

        if(!this.mConversationType.equals(ConversationType.GROUP) && !this.mConversationType.equals(ConversationType.DISCUSSION)) {
            if(this.mConversationType.equals(ConversationType.PRIVATE) && offset != 0) {
                RongIMClient.getInstance().sendTypingStatus(this.mConversationType, this.mTargetId, "RC:TxtMsg");
            }
        } else {
            RongMentionManager.getInstance().onTextEdit(this.mConversationType, this.mTargetId, cursor, offset, s.toString());
        }

    }

    public void afterTextChanged(Editable s) {
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getKeyCode() == 67 && event.getAction() == 0) {
            EditText editText = (EditText)v;
            int cursorPos = editText.getSelectionStart();
            RongMentionManager.getInstance().onDeleteClick(this.mConversationType, this.mTargetId, editText, cursorPos);
        }

        return false;
    }

    public void onMenuClick(int root, int sub) {
        if(this.mPublicServiceProfile != null) {
            PublicServiceMenuItem item = (PublicServiceMenuItem)this.mPublicServiceProfile.getMenu().getMenuItems().get(root);
            if(sub >= 0) {
                item = (PublicServiceMenuItem)item.getSubMenuItems().get(sub);
            }

            if(item.getType().equals(PublicServiceMenuItemType.View)) {
                IPublicServiceMenuClickListener msg = RongContext.getInstance().getPublicServiceMenuClickListener();
                if(msg == null || !msg.onClick(this.mConversationType, this.mTargetId, item)) {
                    String action = "io.rong.imkit.intent.action.webview";
                    Intent intent = new Intent(action);
                    intent.setPackage(this.getActivity().getPackageName());
                    intent.addFlags(268435456);
                    intent.putExtra("url", item.getUrl());
                    this.getActivity().startActivity(intent);
                }
            }

            PublicServiceCommandMessage msg1 = PublicServiceCommandMessage.obtain(item);
            RongIMClient.getInstance().sendMessage(this.mConversationType, this.mTargetId, msg1, (String)null, (String)null, new ISendMessageCallback() {
                public void onAttached(Message message) {
                }

                public void onSuccess(Message message) {
                }

                public void onError(Message message, ErrorCode errorCode) {
                }
            });
        }

    }

    public void onPluginClicked(IPluginModule pluginModule, int position) {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 102) {
            this.getActivity().finish();
        } else {
            this.mRongExtension.onActivityPluginResult(requestCode, resultCode, data);
        }

    }

    private String getNameFromCache(String targetId) {
        UserInfo info = RongContext.getInstance().getUserInfoFromCache(targetId);
        return info == null?targetId:info.getName();
    }

    public final void onEventMainThread(ReadReceiptRequestEvent event) {
        RLog.d("CusConversationFragment", "ReadReceiptRequestEvent");
        if((this.mConversationType.equals(ConversationType.GROUP) || this.mConversationType.equals(ConversationType.DISCUSSION)) && RongContext.getInstance().isReadReceiptConversationType(event.getConversationType()) && event.getConversationType().equals(this.mConversationType) && event.getTargetId().equals(this.mTargetId)) {
            for(int i = 0; i < this.mListAdapter.getCount(); ++i) {
                if(((UIMessage)this.mListAdapter.getItem(i)).getUId().equals(event.getMessageUId())) {
                    final UIMessage uiMessage = (UIMessage)this.mListAdapter.getItem(i);
                    ReadReceiptInfo readReceiptInfo = uiMessage.getReadReceiptInfo();
                    if(readReceiptInfo == null) {
                        readReceiptInfo = new ReadReceiptInfo();
                        uiMessage.setReadReceiptInfo(readReceiptInfo);
                    }

                    if(readReceiptInfo.isReadReceiptMessage() && readReceiptInfo.hasRespond()) {
                        return;
                    }

                    readReceiptInfo.setIsReadReceiptMessage(true);
                    readReceiptInfo.setHasRespond(false);
                    ArrayList messageList = new ArrayList();
                    messageList.add(((UIMessage)this.mListAdapter.getItem(i)).getMessage());
                    RongIMClient.getInstance().sendReadReceiptResponse(event.getConversationType(), event.getTargetId(), messageList, new OperationCallback() {
                        public void onSuccess() {
                            uiMessage.getReadReceiptInfo().setHasRespond(true);
                        }

                        public void onError(ErrorCode errorCode) {
                            RLog.e("CusConversationFragment", "sendReadReceiptResponse failed, errorCode = " + errorCode);
                        }
                    });
                    break;
                }
            }
        }

    }

    public final void onEventMainThread(ReadReceiptResponseEvent event) {
        RLog.d("CusConversationFragment", "ReadReceiptResponseEvent");
        if((this.mConversationType.equals(ConversationType.GROUP) || this.mConversationType.equals(ConversationType.DISCUSSION)) && RongContext.getInstance().isReadReceiptConversationType(event.getConversationType()) && event.getConversationType().equals(this.mConversationType) && event.getTargetId().equals(this.mTargetId)) {
            for(int i = 0; i < this.mListAdapter.getCount(); ++i) {
                if(((UIMessage)this.mListAdapter.getItem(i)).getUId().equals(event.getMessageUId())) {
                    UIMessage uiMessage = (UIMessage)this.mListAdapter.getItem(i);
                    ReadReceiptInfo readReceiptInfo = uiMessage.getReadReceiptInfo();
                    if(readReceiptInfo == null) {
                        readReceiptInfo = new ReadReceiptInfo();
                        readReceiptInfo.setIsReadReceiptMessage(true);
                        uiMessage.setReadReceiptInfo(readReceiptInfo);
                    }

                    readReceiptInfo.setRespondUserIdList(event.getResponseUserIdList());
                    int first = this.mList.getFirstVisiblePosition();
                    int last = this.mList.getLastVisiblePosition();
                    int position = this.getPositionInListView(i);
                    if(position >= first && position <= last) {
                        this.mListAdapter.getView(i, this.getListViewChildAt(i), this.mList);
                    }
                    break;
                }
            }
        }

    }

    public final void onEventMainThread(MessageDeleteEvent deleteEvent) {
        RLog.d("CusConversationFragment", "MessageDeleteEvent");
        if(deleteEvent.getMessageIds() != null) {
            Iterator var2 = deleteEvent.getMessageIds().iterator();

            while(var2.hasNext()) {
                long messageId = (long)((Integer)var2.next()).intValue();
                int position = this.mListAdapter.findPosition(messageId);
                if(position >= 0) {
                    this.mListAdapter.remove(position);
                }
            }

            this.mListAdapter.notifyDataSetChanged();
        }

    }

    public final void onEventMainThread(PublicServiceFollowableEvent event) {
        RLog.d("CusConversationFragment", "PublicServiceFollowableEvent");
        if(event != null && !event.isFollow()) {
            this.getActivity().finish();
        }

    }

    public final void onEventMainThread(MessagesClearEvent clearEvent) {
        RLog.d("CusConversationFragment", "MessagesClearEvent");
        if(clearEvent.getTargetId().equals(this.mTargetId) && clearEvent.getType().equals(this.mConversationType)) {
            this.mListAdapter.clear();
            this.mListAdapter.notifyDataSetChanged();
        }

    }

    public final void onEventMainThread(MessageRecallEvent event) {
        RLog.d("CusConversationFragment", "MessageRecallEvent");
        if(event.isRecallSuccess()) {
            RecallNotificationMessage recallNotificationMessage = event.getRecallNotificationMessage();
            int position = this.mListAdapter.findPosition((long)event.getMessageId());
            if(position != -1) {
                ((UIMessage)this.mListAdapter.getItem(position)).setContent(recallNotificationMessage);
                int first = this.mList.getFirstVisiblePosition();
                int last = this.mList.getLastVisiblePosition();
                int listPos = this.getPositionInListView(position);
                if(listPos >= first && listPos <= last) {
                    this.mListAdapter.getView(position, this.getListViewChildAt(position), this.mList);
                }
            }
        } else {
            Toast.makeText(this.getActivity(), string.rc_recall_failed, 0).show();
        }

    }

    public final void onEventMainThread(RemoteMessageRecallEvent event) {
        RLog.d("CusConversationFragment", "RemoteMessageRecallEvent");
        int position = this.mListAdapter.findPosition((long)event.getMessageId());
        int first = this.mList.getFirstVisiblePosition();
        int last = this.mList.getLastVisiblePosition();
        if(position >= 0) {
            UIMessage uiMessage = (UIMessage)this.mListAdapter.getItem(position);
            if(uiMessage.getMessage().getContent() instanceof VoiceMessage) {
                AudioPlayManager.getInstance().stopPlay();
            }

            if(uiMessage.getMessage().getContent() instanceof FileMessage) {
                RongIM.getInstance().cancelDownloadMediaMessage(uiMessage.getMessage(), (OperationCallback)null);
            }

            uiMessage.setContent(event.getRecallNotificationMessage());
            int listPos = this.getPositionInListView(position);
            if(listPos >= first && listPos <= last) {
                this.mListAdapter.getView(position, this.getListViewChildAt(position), this.mList);
            }
        }

    }

    public final void onEventMainThread(Message msg) {
        RLog.d("CusConversationFragment", "Event message : " + msg.getMessageId() + ", " + msg.getObjectName() + ", " + msg.getSentStatus());
        if(this.mTargetId.equals(msg.getTargetId()) && this.mConversationType.equals(msg.getConversationType()) && msg.getMessageId() > 0) {
            int position = this.mListAdapter.findPosition((long)msg.getMessageId());
            if(position >= 0) {
                ((UIMessage)this.mListAdapter.getItem(position)).setMessage(msg);
                this.mListAdapter.getView(position, this.getListViewChildAt(position), this.mList);
            } else {
                UIMessage uiMessage = UIMessage.obtain(msg);
                if(msg.getContent() instanceof CSPullLeaveMessage) {
                    uiMessage.setCsConfig(this.mCustomServiceConfig);
                }

                this.mListAdapter.add(uiMessage);
                this.mListAdapter.notifyDataSetChanged();
            }

            if(this.mNewMessageCount <= 0) {
                this.mList.setTranscriptMode(2);
                if(msg.getSentStatus() != SentStatus.SENDING) {
                    this.mList.smoothScrollToPosition(this.mList.getCount());
                }

                this.mList.setTranscriptMode(0);
            }

            if(this.mConversationType.equals(ConversationType.CUSTOMER_SERVICE) && msg.getMessageDirection() == MessageDirection.SEND && !this.robotType && this.mCustomServiceConfig.userTipTime > 0 && !TextUtils.isEmpty(this.mCustomServiceConfig.userTipWord)) {
                this.startTimer(0, this.mCustomServiceConfig.userTipTime * 60 * 1000);
            }
        }

    }

    public final void onEventMainThread(FileMessageEvent event) {
        Message msg = event.getMessage();
        RLog.d("CusConversationFragment", "FileMessageEvent message : " + msg.getMessageId() + ", " + msg.getObjectName() + ", " + msg.getSentStatus());
        if(this.mTargetId.equals(msg.getTargetId()) && this.mConversationType.equals(msg.getConversationType()) && msg.getMessageId() > 0 && msg.getContent() instanceof FileMessage) {
            int position = this.mListAdapter.findPosition((long)msg.getMessageId());
            if(position >= 0) {
                UIMessage uiMessage = (UIMessage)this.mListAdapter.getItem(position);
                uiMessage.setMessage(msg);
                uiMessage.setProgress(event.getProgress());
                ((FileMessage)msg.getContent()).progress = event.getProgress();
                ((UIMessage)this.mListAdapter.getItem(position)).setMessage(msg);
            }
        }

    }

    public final void onEventMainThread(GroupUserInfo groupUserInfo) {
        RLog.d("CusConversationFragment", "GroupUserInfoEvent " + groupUserInfo.getGroupId() + " " + groupUserInfo.getUserId() + " " + groupUserInfo.getNickname());
        if(groupUserInfo.getNickname() != null && groupUserInfo.getGroupId() != null) {
            int count = this.mListAdapter.getCount();
            int first = this.mList.getFirstVisiblePosition();
            int last = this.mList.getLastVisiblePosition();

            for(int i = 0; i < count; ++i) {
                UIMessage uiMessage = (UIMessage)this.mListAdapter.getItem(i);
                if(uiMessage.getSenderUserId().equals(groupUserInfo.getUserId())) {
                    uiMessage.setNickName(true);
                    UserInfo userInfo = uiMessage.getUserInfo();
                    if(userInfo != null) {
                        userInfo.setName(groupUserInfo.getNickname());
                    } else {
                        userInfo = new UserInfo(groupUserInfo.getUserId(), groupUserInfo.getNickname(), (Uri)null);
                    }

                    uiMessage.setUserInfo(userInfo);
                    int pos = this.getPositionInListView(i);
                    if(pos >= first && pos <= last) {
                        this.mListAdapter.getView(i, this.getListViewChildAt(i), this.mList);
                    }
                }
            }

        }
    }

    private View getListViewChildAt(int adapterIndex) {
        int header = this.mList.getHeaderViewsCount();
        int first = this.mList.getFirstVisiblePosition();
        return this.mList.getChildAt(adapterIndex + header - first);
    }

    private int getPositionInListView(int adapterIndex) {
        int header = this.mList.getHeaderViewsCount();
        return adapterIndex + header;
    }

    private int getPositionInAdapter(int listIndex) {
        int header = this.mList.getHeaderViewsCount();
        return listIndex <= 0?0:listIndex - header;
    }

    public final void onEventMainThread(OnMessageSendErrorEvent event) {
        this.onEventMainThread(event.getMessage());
    }

    public final void onEventMainThread(OnReceiveMessageEvent event) {
        Message message = event.getMessage();
        RLog.i("CusConversationFragment", "OnReceiveMessageEvent, " + message.getMessageId() + ", " + message.getObjectName() + ", " + message.getReceivedStatus().toString());
        ConversationType conversationType = message.getConversationType();
        String targetId = message.getTargetId();
        if(this.mConversationType.equals(conversationType) && this.mTargetId.equals(targetId) && this.shouldUpdateMessage(message, event.getLeft())) {
            if(event.getLeft() == 0 && message.getConversationType().equals(ConversationType.PRIVATE) && RongContext.getInstance().isReadReceiptConversationType(ConversationType.PRIVATE) && message.getMessageDirection().equals(MessageDirection.RECEIVE)) {
                if(this.mReadRec) {
                    RongIMClient.getInstance().sendReadReceiptMessage(message.getConversationType(), message.getTargetId(), message.getSentTime());
                }

                if(this.mSyncReadStatus) {
                    RongIMClient.getInstance().syncConversationReadStatus(message.getConversationType(), message.getTargetId(), message.getSentTime(), (OperationCallback)null);
                }
            }

            if(this.mSyncReadStatus) {
                this.mSyncReadStatusMsgTime = message.getSentTime();
            }

            if(message.getMessageId() > 0) {
                if(!SystemUtils.isInBackground(this.getContext())) {
                    message.getReceivedStatus().setRead();
                    RongIMClient.getInstance().setMessageReceivedStatus(message.getMessageId(), message.getReceivedStatus(), (ResultCallback)null);
                    if(message.getMessageDirection().equals(MessageDirection.RECEIVE)) {
                        UnReadMessageManager.getInstance().onMessageReceivedStatusChanged();
                    }
                }

                if(this.mConversationType.equals(ConversationType.CUSTOMER_SERVICE) && !this.robotType && this.mCustomServiceConfig.adminTipTime > 0 && !TextUtils.isEmpty(this.mCustomServiceConfig.adminTipWord)) {
                    this.startTimer(1, this.mCustomServiceConfig.adminTipTime * 60 * 1000);
                }
            }

            RLog.d("CusConversationFragment", "mList.getCount(): " + this.mList.getCount() + " getLastVisiblePosition:" + this.mList.getLastVisiblePosition());
            if(this.mNewMessageBtn != null && this.mList.getCount() - this.mList.getLastVisiblePosition() > 2 && MessageDirection.SEND != message.getMessageDirection() && message.getConversationType() != ConversationType.CHATROOM && message.getConversationType() != ConversationType.CUSTOMER_SERVICE && message.getConversationType() != ConversationType.APP_PUBLIC_SERVICE && message.getConversationType() != ConversationType.PUBLIC_SERVICE) {
                ++this.mNewMessageCount;
                if(this.mNewMessageCount > 0) {
                    this.mNewMessageBtn.setVisibility(0);
                    this.mNewMessageTextView.setVisibility(0);
                }

                if(this.mNewMessageCount > 99) {
                    this.mNewMessageTextView.setText("99+");
                } else {
                    this.mNewMessageTextView.setText(this.mNewMessageCount + "");
                }
            }

            this.onEventMainThread(event.getMessage());
        }

    }

    public final void onEventBackgroundThread(final PlayAudioEvent event) {
        this.getHandler().post(new Runnable() {
            public void run() {
                CusConversationFragment.this.handleAudioPlayEvent(event);
            }
        });
    }

    private void handleAudioPlayEvent(PlayAudioEvent event) {
        RLog.i("CusConversationFragment", "PlayAudioEvent");
        int first = this.mList.getFirstVisiblePosition();
        int last = this.mList.getLastVisiblePosition();
        int position = this.mListAdapter.findPosition((long)event.messageId);
        if(event.continuously && position >= 0) {
            while(first <= last) {
                ++position;
                ++first;
                UIMessage uiMessage = (UIMessage)this.mListAdapter.getItem(position);
                if(uiMessage != null && uiMessage.getContent() instanceof VoiceMessage && uiMessage.getMessageDirection().equals(MessageDirection.RECEIVE) && !uiMessage.getReceivedStatus().isListened()) {
                    uiMessage.continuePlayAudio = true;
                    this.mListAdapter.getView(position, this.getListViewChildAt(position), this.mList);
                    break;
                }
            }
        }

    }

    public final void onEventMainThread(OnReceiveMessageProgressEvent event) {
        if(this.mList != null) {
            int first = this.mList.getFirstVisiblePosition();

            for(int last = this.mList.getLastVisiblePosition(); first <= last; ++first) {
                int position = this.getPositionInAdapter(first);
                UIMessage uiMessage = (UIMessage)this.mListAdapter.getItem(position);
                if(uiMessage.getMessageId() == event.getMessage().getMessageId()) {
                    uiMessage.setProgress(event.getProgress());
                    if(this.isResumed()) {
                        this.mListAdapter.getView(position, this.getListViewChildAt(position), this.mList);
                    }
                    break;
                }
            }
        }

    }

    public void onEventMainThread(ConnectEvent event) {
        RLog.i("CusConversationFragment", "ConnectEvent : " + event.getConnectStatus());
        if(this.mListAdapter.getCount() == 0) {
            Mode mode = this.indexMessageTime > 0L? Mode.END: Mode.START;
            int scrollMode = this.indexMessageTime > 0L?1:3;
            this.getHistoryMessage(this.mConversationType, this.mTargetId, 30, mode, scrollMode);
        }

    }

    public final void onEventMainThread(UserInfo userInfo) {
        RLog.i("CusConversationFragment", "userInfo " + userInfo.getUserId());
        int first = this.mList.getFirstVisiblePosition();
        int last = this.mList.getLastVisiblePosition();

        for(int i = 0; i < this.mListAdapter.getCount(); ++i) {
            UIMessage uiMessage = (UIMessage)this.mListAdapter.getItem(i);
            if(userInfo.getUserId().equals(uiMessage.getSenderUserId()) && !uiMessage.isNickName()) {
                if(uiMessage.getConversationType().equals(ConversationType.CUSTOMER_SERVICE) && uiMessage.getMessage() != null && uiMessage.getMessage().getContent() != null && uiMessage.getMessage().getContent().getUserInfo() != null) {
                    uiMessage.setUserInfo(uiMessage.getMessage().getContent().getUserInfo());
                } else {
                    uiMessage.setUserInfo(userInfo);
                }

                int position = this.getPositionInListView(i);
                if(position >= first && position <= last) {
                    this.mListAdapter.getView(i, this.getListViewChildAt(i), this.mList);
                }
            }
        }

    }

    public final void onEventMainThread(PublicServiceProfile publicServiceProfile) {
        RLog.i("CusConversationFragment", "publicServiceProfile");
        int first = this.mList.getFirstVisiblePosition();

        for(int last = this.mList.getLastVisiblePosition(); first <= last; ++first) {
            int position = this.getPositionInAdapter(first);
            UIMessage message = (UIMessage)this.mListAdapter.getItem(position);
            if(message != null && (TextUtils.isEmpty(message.getTargetId()) || publicServiceProfile.getTargetId().equals(message.getTargetId()))) {
                this.mListAdapter.getView(position, this.getListViewChildAt(position), this.mList);
            }
        }

    }

    public final void onEventMainThread(ReadReceiptEvent event) {
        RLog.i("CusConversationFragment", "ReadReceiptEvent");
        if(RongContext.getInstance().isReadReceiptConversationType(event.getMessage().getConversationType()) && this.mTargetId.equals(event.getMessage().getTargetId()) && this.mConversationType.equals(event.getMessage().getConversationType()) && event.getMessage().getMessageDirection().equals(MessageDirection.RECEIVE)) {
            ReadReceiptMessage content = (ReadReceiptMessage)event.getMessage().getContent();
            long ntfTime = content.getLastMessageSendTime();

            for(int i = this.mListAdapter.getCount() - 1; i >= 0; --i) {
                UIMessage uiMessage = (UIMessage)this.mListAdapter.getItem(i);
                if(uiMessage.getMessageDirection().equals(MessageDirection.SEND) && uiMessage.getSentStatus() == SentStatus.SENT && ntfTime >= uiMessage.getSentTime()) {
                    uiMessage.setSentStatus(SentStatus.READ);
                    int first = this.mList.getFirstVisiblePosition();
                    int last = this.mList.getLastVisiblePosition();
                    int position = this.getPositionInListView(i);
                    if(position >= first && position <= last) {
                        this.mListAdapter.getView(i, this.getListViewChildAt(i), this.mList);
                    }
                }
            }
        }

    }

    public MessageListAdapter getMessageAdapter() {
        return this.mListAdapter;
    }

    public boolean shouldUpdateMessage(Message message, int left) {
        return true;
    }

    public void getHistoryMessage(ConversationType conversationType, String targetId, int lastMessageId, int reqCount, CusConversationFragment.LoadMessageDirection direction, final IHistoryDataResultCallback<List<Message>> callback) {
        if(direction == CusConversationFragment.LoadMessageDirection.UP) {
            RongIMClient.getInstance().getHistoryMessages(conversationType, targetId, lastMessageId, reqCount, new ResultCallback() {
                public void onSuccess(Object o) {
                    List<Message> messages = (List<Message>) o;
                    if(callback != null) {
                        callback.onResult(messages);
                    }

                }

                public void onError(ErrorCode e) {
                    RLog.e("CusConversationFragment", "getHistoryMessages " + e);
                    if(callback != null) {
                        callback.onResult((List<Message>) null);
                    }

                }
            });
        } else {
            byte before = 10;
            byte after = 10;
            if(this.mListAdapter.getCount() > 0) {
                after = 30;
                before = 0;
            }

            RongIMClient.getInstance().getHistoryMessages(conversationType, targetId, this.indexMessageTime, before, after, new ResultCallback() {
                public void onSuccess(Object o) {
                    List<Message> messages = (List<Message>) o;
                    if(callback != null) {
                        callback.onResult(messages);
                    }

                    if(messages != null && messages.size() > 0 && CusConversationFragment.this.mHasMoreLocalMessagesDown) {
                        CusConversationFragment.this.indexMessageTime = ((Message)messages.get(0)).getSentTime();
                    } else {
                        CusConversationFragment.this.indexMessageTime = 0L;
                    }

                }

                public void onError(ErrorCode e) {
                    RLog.e("CusConversationFragment", "getHistoryMessages " + e);
                    if(callback != null) {
                        callback.onResult((List<Message>) null);
                    }

                    CusConversationFragment.this.indexMessageTime = 0L;
                }
            });
        }

    }

    private void getHistoryMessage(ConversationType conversationType, String targetId, final int reqCount, Mode mode, final int scrollMode) {
        this.mList.onRefreshStart(mode);
        if(conversationType.equals(ConversationType.CHATROOM)) {
            this.mList.onRefreshComplete(0, 0, false);
            RLog.w("CusConversationFragment", "Should not get local message in chatroom");
        } else {
            int last = this.mListAdapter.getCount() == 0?-1:((UIMessage)this.mListAdapter.getItem(0)).getMessageId();
            final CusConversationFragment.LoadMessageDirection direction = mode == Mode.START? CusConversationFragment.LoadMessageDirection.UP: CusConversationFragment.LoadMessageDirection.DOWN;
            this.getHistoryMessage(conversationType, targetId, last, reqCount, direction, new IHistoryDataResultCallback() {
                @Override
                public void onResult(Object o) {
                    List<Message> messages = (List<Message>) o;
                    int msgCount = messages == null?0:messages.size();
                    RLog.i("CusConversationFragment", "getHistoryMessage " + msgCount);
                    if(direction == CusConversationFragment.LoadMessageDirection.DOWN) {
                        CusConversationFragment.this.mList.onRefreshComplete(msgCount > 1?msgCount:0, msgCount, false);
                        CusConversationFragment.this.mHasMoreLocalMessagesDown = msgCount > 1;
                    } else {
                        CusConversationFragment.this.mList.onRefreshComplete(msgCount, reqCount, false);
                        CusConversationFragment.this.mHasMoreLocalMessagesUp = msgCount == reqCount;
                    }

                    if(messages != null && messages.size() > 0) {
                        int index = 0;
                        if(direction == CusConversationFragment.LoadMessageDirection.DOWN) {
                            index = CusConversationFragment.this.mListAdapter.getCount() == 0?0:CusConversationFragment.this.mListAdapter.getCount();
                        }

                        boolean needRefresh = false;
                        Iterator selected = messages.iterator();

                        while(selected.hasNext()) {
                            Message i = (Message)selected.next();
                            boolean contains = false;

                            for(int uiMessage = 0; uiMessage < CusConversationFragment.this.mListAdapter.getCount(); ++uiMessage) {
                                contains = ((UIMessage)CusConversationFragment.this.mListAdapter.getItem(uiMessage)).getMessageId() == i.getMessageId();
                                if(contains) {
                                    break;
                                }
                            }

                            if(!contains) {
                                UIMessage var11 = UIMessage.obtain(i);
                                if(i.getContent() instanceof CSPullLeaveMessage) {
                                    var11.setCsConfig(CusConversationFragment.this.mCustomServiceConfig);
                                }

                                CusConversationFragment.this.mListAdapter.add(var11, index);
                                needRefresh = true;
                            }
                        }

                        if(needRefresh) {
                            CusConversationFragment.this.mListAdapter.notifyDataSetChanged();
                            if(CusConversationFragment.this.mLastMentionMsgId > 0) {
                                index = CusConversationFragment.this.mListAdapter.findPosition((long)CusConversationFragment.this.mLastMentionMsgId);
                                CusConversationFragment.this.mList.setSelection(index);
                                CusConversationFragment.this.mLastMentionMsgId = 0;
                            } else if(2 == scrollMode) {
                                CusConversationFragment.this.mList.setSelection(0);
                            } else if(scrollMode == 3) {
                                CusConversationFragment.this.mList.setSelection(CusConversationFragment.this.mListAdapter.getCount());
                            } else if(direction == CusConversationFragment.LoadMessageDirection.DOWN) {
                                int var9 = CusConversationFragment.this.mList.getSelectedItemPosition();
                                if(var9 <= 0) {
                                    for(int var10 = 0; var10 < CusConversationFragment.this.mListAdapter.getCount(); ++var10) {
                                        if(((UIMessage)CusConversationFragment.this.mListAdapter.getItem(var10)).getSentTime() == CusConversationFragment.this.indexMessageTime) {
                                            CusConversationFragment.this.mList.setSelection(var10);
                                            break;
                                        }
                                    }
                                } else {
                                    CusConversationFragment.this.mList.setSelection(CusConversationFragment.this.mListAdapter.getCount() - messages.size());
                                }
                            } else {
                                CusConversationFragment.this.mList.setSelection(messages.size() + 1);
                            }

                            CusConversationFragment.this.sendReadReceiptResponseIfNeeded(messages);
                        }
                    }

                }

                public void onError() {
                    CusConversationFragment.this.mList.onRefreshComplete(reqCount, reqCount, false);
                }
            });
        }
    }

    public void getRemoteHistoryMessages(ConversationType conversationType, String targetId, long dateTime, int reqCount, final IHistoryDataResultCallback<List<Message>> callback) {
        RongIMClient.getInstance().getRemoteHistoryMessages(conversationType, targetId, dateTime, reqCount, new ResultCallback() {

            @Override
            public void onSuccess(Object o) {
                List<Message> messages = (List<Message>) o;
                if(callback != null) {
                    callback.onResult(messages);
                }
            }

            public void onError(ErrorCode e) {
                RLog.e("CusConversationFragment", "getRemoteHistoryMessages " + e);
                if(callback != null) {
                    callback.onResult((List<Message>) null);
                }

            }
        });
    }

    private void getRemoteHistoryMessages(ConversationType conversationType, String targetId, final int reqCount) {
        this.mList.onRefreshStart(Mode.START);
        if(this.mConversationType.equals(ConversationType.CHATROOM)) {
            this.mList.onRefreshComplete(0, 0, false);
            RLog.w("CusConversationFragment", "Should not get remote message in chatroom");
        } else {
            long dateTime = this.mListAdapter.getCount() == 0?0L:((UIMessage)this.mListAdapter.getItem(0)).getSentTime();
            this.getRemoteHistoryMessages(conversationType, targetId, dateTime, reqCount, new IHistoryDataResultCallback() {

                @Override
                public void onResult(Object o) {
                    List<Message> messages = (List<Message>) o;
                    RLog.i("CusConversationFragment", "getRemoteHistoryMessages " + (messages == null?0:messages.size()));
                    Message lastMessage = null;
                    if(messages != null && messages.size() > 0) {
                        if(CusConversationFragment.this.mListAdapter.getCount() == 0) {
                            lastMessage = (Message)messages.get(0);
                        }

                        ArrayList remoteList = new ArrayList();
                        Iterator var4 = messages.iterator();

                        while(var4.hasNext()) {
                            Message uiMessage = (Message)var4.next();
                            if(uiMessage.getMessageId() > 0) {
                                UIMessage uiMessage1 = UIMessage.obtain(uiMessage);
                                if(uiMessage.getContent() instanceof CSPullLeaveMessage) {
                                    uiMessage1.setCsConfig(CusConversationFragment.this.mCustomServiceConfig);
                                }

                                remoteList.add(uiMessage1);
                            }
                        }

                        List remoteList1 = CusConversationFragment.this.filterMessage(remoteList);
                        if(remoteList1 != null && remoteList1.size() > 0) {
                            var4 = remoteList1.iterator();

                            while(var4.hasNext()) {
                                UIMessage uiMessage2 = (UIMessage)var4.next();
                                uiMessage2.setSentStatus(SentStatus.READ);
                                CusConversationFragment.this.mListAdapter.add(uiMessage2, 0);
                            }

                            CusConversationFragment.this.mListAdapter.notifyDataSetChanged();
                            CusConversationFragment.this.mList.setSelection(messages.size() + 1);
                            CusConversationFragment.this.sendReadReceiptResponseIfNeeded(messages);
                            CusConversationFragment.this.mList.onRefreshComplete(messages.size(), reqCount, false);
                            if(lastMessage != null) {
                                RongContext.getInstance().getEventBus().post(lastMessage);
                            }
                        } else {
                            CusConversationFragment.this.mList.onRefreshComplete(0, reqCount, false);
                        }
                    } else {
                        CusConversationFragment.this.mList.onRefreshComplete(0, reqCount, false);
                    }
                }

                public void onError() {
                    CusConversationFragment.this.mList.onRefreshComplete(0, reqCount, false);
                }
            });
        }
    }

    private List<UIMessage> filterMessage(List<UIMessage> srcList) {
        Object destList;
        if(this.mListAdapter.getCount() > 0) {
            destList = new ArrayList();

            for(int i = 0; i < this.mListAdapter.getCount(); ++i) {
                Iterator var4 = srcList.iterator();

                while(var4.hasNext()) {
                    UIMessage msg = (UIMessage)var4.next();
                    if(!((List)destList).contains(msg) && msg.getMessageId() != ((UIMessage)this.mListAdapter.getItem(i)).getMessageId()) {
                        ((List)destList).add(msg);
                    }
                }
            }
        } else {
            destList = srcList;
        }

        return (List)destList;
    }

    private void getLastMentionedMessageId(ConversationType conversationType, String targetId) {
        RongIMClient.getInstance().getUnreadMentionedMessages(conversationType, targetId, new ResultCallback() {

            @Override
            public void onSuccess(Object o) {
                List<Message> messages = (List<Message>) o;
                if(messages != null && messages.size() > 0) {
                    CusConversationFragment.this.mLastMentionMsgId = ((Message)messages.get(0)).getMessageId();
                    int index = CusConversationFragment.this.mListAdapter.findPosition((long)CusConversationFragment.this.mLastMentionMsgId);
                    RLog.i("CusConversationFragment", "getLastMentionedMessageId " + CusConversationFragment.this.mLastMentionMsgId + " " + index);
                    if(CusConversationFragment.this.mLastMentionMsgId > 0 && index >= 0) {
                        CusConversationFragment.this.mList.setSelection(index);
                        CusConversationFragment.this.mLastMentionMsgId = 0;
                    }
                }

                RongIM.getInstance().clearMessagesUnreadStatus(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, (ResultCallback)null);

            }

            public void onError(ErrorCode e) {
                RongIM.getInstance().clearMessagesUnreadStatus(CusConversationFragment.this.mConversationType, CusConversationFragment.this.mTargetId, (ResultCallback)null);
            }
        });
    }

    private void sendReadReceiptResponseIfNeeded(List<Message> messages) {
        if(this.mReadRec && (this.mConversationType.equals(ConversationType.GROUP) || this.mConversationType.equals(ConversationType.DISCUSSION)) && RongContext.getInstance().isReadReceiptConversationType(this.mConversationType)) {
            ArrayList responseMessageList = new ArrayList();
            Iterator var3 = messages.iterator();

            while(var3.hasNext()) {
                Message message = (Message)var3.next();
                ReadReceiptInfo readReceiptInfo = message.getReadReceiptInfo();
                if(readReceiptInfo != null && readReceiptInfo.isReadReceiptMessage() && !readReceiptInfo.hasRespond()) {
                    responseMessageList.add(message);
                }
            }

            if(responseMessageList.size() > 0) {
                RongIMClient.getInstance().sendReadReceiptResponse(this.mConversationType, this.mTargetId, responseMessageList, (OperationCallback)null);
            }
        }

    }

    public void onExtensionCollapsed() {
    }

    public void onExtensionExpanded(int h) {
        if(this.indexMessageTime > 0L) {
            this.mListAdapter.clear();
            this.indexMessageTime = 0L;
            this.getHistoryMessage(this.mConversationType, this.mTargetId, 30, Mode.START, 1);
        } else {
            this.mList.setSelection(this.mListAdapter.getCount());
        }

    }

    public void onStartCustomService(String targetId) {
        this.csEnterTime = System.currentTimeMillis();
        this.mRongExtension.setExtensionBarMode(CustomServiceMode.CUSTOM_SERVICE_MODE_NO_SERVICE);
        RongIMClient.getInstance().startCustomService(targetId, this.customServiceListener, this.mCustomUserInfo);
    }

    public void onStopCustomService(String targetId) {
        RongIMClient.getInstance().stopCustomService(targetId);
    }

    public final void onEvaluateSubmit() {
        if(this.mEvaluateDialg != null) {
            this.mEvaluateDialg.destroy();
            this.mEvaluateDialg = null;
        }

        if(this.mCustomServiceConfig.quitSuspendType.equals(CSQuitSuspendType.NONE)) {
            this.getActivity().finish();
        }

    }

    public final void onEvaluateCanceled() {
        if(this.mEvaluateDialg != null) {
            this.mEvaluateDialg.destroy();
            this.mEvaluateDialg = null;
        }

        if(this.mCustomServiceConfig.quitSuspendType.equals(CSQuitSuspendType.NONE)) {
            this.getActivity().finish();
        }

    }

    private void startTimer(int event, int interval) {
        this.getHandler().removeMessages(event);
        this.getHandler().sendEmptyMessageDelayed(event, (long)interval);
    }

    private void stopTimer(int event) {
        this.getHandler().removeMessages(event);
    }

    public ConversationType getConversationType() {
        return this.mConversationType;
    }

    public String getTargetId() {
        return this.mTargetId;
    }

    private static enum LoadMessageDirection {
        DOWN,
        UP;

        private LoadMessageDirection() {
        }
    }
}

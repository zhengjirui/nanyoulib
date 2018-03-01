package io.rong.imkit.messages.provider;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.AutoLinkTextView;
import io.rong.imkit.widget.ILinkClickListener;
import io.rong.imkit.widget.LinkTextViewMovementMethod;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imkit.widget.provider.TextMessageItemProvider;
import io.rong.imlib.model.Message;
import io.rong.message.TextMessage;

/**
 * Created by 18513 on 2018/1/9.
 */
@ProviderTag(
        messageContent = TextMessage.class,
        showPortrait = true
)
public class CusTextMessageItemProvider extends TextMessageItemProvider {

    public CusTextMessageItemProvider() {
    }

    public View newView(Context context, ViewGroup group) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_item_text_message, (ViewGroup)null);
        CusTextMessageItemProvider.ViewHolder holder = new CusTextMessageItemProvider.ViewHolder();
        holder.message = (AutoLinkTextView)view.findViewById(android.R.id.text1);
        view.setTag(holder);
        return view;
    }

    public Spannable getContentSummary(TextMessage data) {
        if(data == null) {
            return null;
        } else {
            String content = data.getContent();
            if(content != null) {
                if(content.length() > 100) {
                    content = content.substring(0, 100);
                }

                return new SpannableString(AndroidEmoji.ensure(content));
            } else {
                return null;
            }
        }
    }

    @Override
    public void onItemLongClick(View view, int position, TextMessage content, UIMessage message) {
//        super.onItemLongClick(view, position, content, message);
    }

    public void onItemClick(View view, int position, TextMessage content, UIMessage message) {
    }

    public void bindView(final View v, int position, TextMessage content, final UIMessage data) {
        CusTextMessageItemProvider.ViewHolder holder = (CusTextMessageItemProvider.ViewHolder)v.getTag();
        if(data.getMessageDirection() == Message.MessageDirection.SEND) {
            holder.message.setBackgroundResource(R.drawable.rc_ic_bubble_right);
        } else {
            holder.message.setBackgroundResource(R.drawable.rc_ic_bubble_left);
        }

        final AutoLinkTextView textView = holder.message;
        if(data.getTextMessageContent() != null) {
            int len = data.getTextMessageContent().length();
            if(v.getHandler() != null && len > 500) {
                v.getHandler().postDelayed(new Runnable() {
                    public void run() {
                        String textMessageContent = data.getTextMessageContent().toString();
                        NyUtiles.showLog("--------",textMessageContent);
                        textView.setText(Html.fromHtml(textMessageContent,new ConvercationImageGetter(textView),null));
                    }
                }, 50L);
            } else {
                String textMessageContent = data.getTextMessageContent().toString();
                NyUtiles.showLog("--------",textMessageContent);
                textView.setText(Html.fromHtml(textMessageContent,new ConvercationImageGetter(textView),null));
            }
        }

//        holder.message.setMovementMethod(new LinkTextViewMovementMethod(new ILinkClickListener() {
//            public boolean onLinkClick(String link) {
//                RongIM.ConversationBehaviorListener listener = RongContext.getInstance().getConversationBehaviorListener();
//                boolean result = false;
//                if(listener != null) {
//                    result = listener.onMessageLinkClick(v.getContext(), link);
//                }
//
//                if(listener == null || !result) {
//                    String str = link.toLowerCase();
//                    if(str.startsWith("http") || str.startsWith("https")) {
//                        Intent intent = new Intent("io.rong.imkit.intent.action.webview");
//                        intent.setPackage(v.getContext().getPackageName());
//                        intent.putExtra("url", link);
//                        v.getContext().startActivity(intent);
//                        result = true;
//                    }
//                }
//
//                return result;
//            }
//        }));
    }

    private static class ViewHolder {
        AutoLinkTextView message;
        boolean longClick;

        private ViewHolder() {
        }
    }
}

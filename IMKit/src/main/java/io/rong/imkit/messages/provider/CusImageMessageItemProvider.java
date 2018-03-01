package io.rong.imkit.messages.provider;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Message;
import io.rong.message.ImageMessage;

/**
 * Created by 18513 on 2018/1/9.
 */
@ProviderTag(
        messageContent = ImageMessage.class,
        showProgress = false,
        showReadState = true
)
public class CusImageMessageItemProvider extends IContainerItemProvider.MessageProvider<ImageMessage> {
    private static final String TAG = "CusImageMessageItemProvider";

    public CusImageMessageItemProvider() {
    }

    public View newView(Context context, ViewGroup group) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_item_image_message, (ViewGroup)null);
        CusImageMessageItemProvider.ViewHolder holder = new CusImageMessageItemProvider.ViewHolder();
        holder.message = (TextView)view.findViewById(R.id.rc_msg);
        holder.img = (AsyncImageView)view.findViewById(R.id.rc_img);
        view.setTag(holder);
        return view;
    }

    public void onItemClick(View view, int position, ImageMessage content, UIMessage message) {

    }

    public void bindView(View v, int position, ImageMessage content, UIMessage message) {
        CusImageMessageItemProvider.ViewHolder holder = (CusImageMessageItemProvider.ViewHolder)v.getTag();
        if(message.getMessageDirection() == Message.MessageDirection.SEND) {
            v.setBackgroundResource(R.drawable.rc_ic_bubble_no_right);
        } else {
            v.setBackgroundResource(R.drawable.rc_ic_bubble_no_left);
        }

        holder.img.setResource(content.getThumUri());
        int progress = message.getProgress();
        Message.SentStatus status = message.getSentStatus();
        if(status.equals(Message.SentStatus.SENDING) && progress < 100) {
            holder.message.setText(progress + "%");
            holder.message.setVisibility(View.VISIBLE);
        } else {
            holder.message.setVisibility(View.GONE);
        }

    }

    public Spannable getContentSummary(ImageMessage data) {
        return new SpannableString(RongContext.getInstance().getResources().getString(R.string.rc_message_content_image));
    }

    private static class ViewHolder {
        AsyncImageView img;
        TextView message;

        private ViewHolder() {
        }
    }
}

package io.rong.imkit.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.rong.imageloader.core.ImageLoader;
import io.rong.imkit.NYAppManger;
import io.rong.imkit.R;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.base.BaseRecyclerViewHolder;
import io.rong.imkit.home.activity.HomeActivity;
import io.rong.imkit.home.bean.MsgTypeBean;


/**
 * Created by 18513 on 2017/12/14.
 */

public class MsgTypeGvAdapter extends BaseRecyclerViewHolder<MsgTypeBean.MsgTypeGvBean> {

    private final String TAG = "--MsgTypeGvAdapter";

    private Context mContext;
    private TextView msgtype_content_tv;
    private ImageView msgtype_content_img;
    private View itemView;

    public MsgTypeGvAdapter(Context context,View itemView) {
        super(itemView);
        this.mContext = context;
        this.itemView = itemView;
        msgtype_content_tv = (TextView) itemView.findViewById(R.id.msgtype_content_tv);
        msgtype_content_img = (ImageView) itemView.findViewById(R.id.msgtype_content_img);
    }

    @Override
    public void bindHolder(final MsgTypeBean.MsgTypeGvBean msgTypeBean) {
        String type_img_url = msgTypeBean.getType_img_url();
        msgtype_content_tv.setText(msgTypeBean.getType_text());
        ImageLoader.getInstance().displayImage(type_img_url,msgtype_content_img, NYAppManger.getInstance().getOptions());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NyUtiles.showLog(TAG,msgTypeBean.getType_text());
                HomeActivity msgTypeActivity = (HomeActivity) mContext;
                msgTypeActivity.requestHttp2(msgTypeBean.getGroup_id(),msgTypeBean.getType_text(),
                        msgTypeBean.getMsg(),msgTypeBean.getRule_id());
            }
        });
    }

}

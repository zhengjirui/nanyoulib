package io.rong.imkit.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.ImageLoader;
import io.rong.imageloader.core.assist.ImageScaleType;
import io.rong.imageloader.core.display.RoundedBitmapDisplayer;
import io.rong.imkit.R;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imkit.base.BaseRecyclerViewHolder;
import io.rong.imkit.home.bean.MsgTypeBean;

/**
 * Created by 18513 on 2017/12/14.
 */

public class MsgTypeHeaderAdapter extends BaseRecyclerViewHolder<MsgTypeBean.MsgTypeHeaderBean> {

    private Context mContext;
    private TextView msgtype_header_tv;
//    private TextView typemsg_hint_title;
    private ImageView msgtype_header_img;

    public MsgTypeHeaderAdapter(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        msgtype_header_tv = (TextView) itemView.findViewById(R.id.msgtype_header_tv);
//        typemsg_hint_title = (TextView) itemView.findViewById(R.id.typemsg_hint_title);
        msgtype_header_img = (ImageView) itemView.findViewById(R.id.msgtype_header_img);
    }

    @Override
    public void bindHolder(final MsgTypeBean.MsgTypeHeaderBean msgTypeHeaderBean) {
        String header_img_url = msgTypeHeaderBean.getHeader_img_url();
        ImageLoader.getInstance().displayImage(header_img_url,msgtype_header_img ,new DisplayImageOptions.Builder()
//                .showImageForEmptyUri(R.drawable.ny_loading_error)
                .showImageOnFail(R.drawable.ny_loading_error)
//                .showImageOnLoading(R.drawable.ny_loading)
                .displayer(new RoundedBitmapDisplayer(180))
//                .imageScaleType(ImageScaleType.EXACTLY )
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build());
        msgtype_header_tv.setText(msgTypeHeaderBean.getHeader_text());
//        msgtype_header_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NyUtiles.showToast(msgTypeHeaderBean.getHeader_text());
//            }
//        });
    }


}

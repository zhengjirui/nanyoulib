package io.rong.imkit.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import io.rong.imkit.R;
import io.rong.imkit.base.BaseRecyclerViewHolder;
import io.rong.imkit.home.bean.MsgTypeBean;

/**
 * Created by 18513 on 2017/12/14.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private MsgTypeBean msgTypeBean;
    private LayoutInflater inflater;

    public RvAdapter(Context context, MsgTypeBean msgTypeBean) {
        this.context = context;
        this.msgTypeBean = msgTypeBean;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 0:
                return new MsgTypeHeaderAdapter(context,inflater.inflate(R.layout.ny_msgtype_header_item,parent,false));

            case 1:
                return new MsgTypeGvAdapter(context,inflater.inflate(R.layout.ny_msgtype_gv_item,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //判断是第几个item，根据item的不同，往bindHolder里面穿不同的值（通过position判断）
        BaseRecyclerViewHolder vh = (BaseRecyclerViewHolder)holder;
        if(position == 0){
            vh.bindHolder(msgTypeBean.getMsgTypeHeaderBean());
        }else {
            vh.bindHolder(msgTypeBean.getMsgTypeGvBeenList().get(position - 1));
        }

    }

    @Override
    public int getItemViewType(int position) {
        //判断是第几个item，然后返回对应item的数据（通过position判断）
//        return super.getItemViewType(position);
        if(position == 0){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        int size = msgTypeBean.getMsgTypeGvBeenList().size() + 1;
        return size;
    }

    public void setNotifyDataSetChanged(MsgTypeBean msgTypeBean){
        this.msgTypeBean = msgTypeBean;
        this.notifyDataSetChanged();
    }
}

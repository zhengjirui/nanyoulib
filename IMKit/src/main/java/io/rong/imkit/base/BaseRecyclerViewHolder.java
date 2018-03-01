package io.rong.imkit.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 18513 on 2017/12/14.
 */

public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T o);
}

package com.practice.tiger.tigerstructure.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Author：NaShichao
 * Time：2016/12/26  下午4:08
 * Email：na.shichao@163.com
 * Description：RecyclerView.Adapter的实现类
 */

public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter {

    private OnItemClickListener mOnItemClickListener;

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view, holder.getLayoutPosition());
                }
            });
        }
    }

    interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}

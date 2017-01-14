package com.practice.tiger.tigerstructure.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.practice.tiger.tigerstructure.R;

import java.util.ArrayList;

/**
 * Author：NaShichao
 * Time：2016/12/26  下午4:26
 * Email：na.shichao@163.com
 * Description：
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {
    private ArrayList<String> data;
    private OnItemClickListener mOnItemClickListener;
    private ArrayList<Integer> heights;

    public MainRecyclerAdapter(ArrayList<String> data) {
        this.data = data;
        heights = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            heights.add((int) Math.max(200, Math.random() * 500));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler,
                parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view, holder.getLayoutPosition());
                }
            });
        }
        holder.tv.setText(data.get(position));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.tv.getLayoutParams();
        layoutParams.height = heights.get(position);
        holder.tv.setLayoutParams(layoutParams);
        holder.tv.setBackgroundColor(Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255),
                (int) (Math.random() * 255)));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_main_recycler_textView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}

package com.practice.tiger.tigerstructure.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.practice.tiger.tigerstructure.R;

import java.util.List;

/**
 * Author：NaShichao
 * Time：2016/12/27  下午3:51
 * Email：na.shichao@163.com
 * Description：
 */

public class HeaderRecyclerAdapter extends RecyclerView.Adapter<HeaderRecyclerAdapter.ViewHolder> {
    private List<String> list;

    public HeaderRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_header_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        ViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.item_header_recycler_tv);
        }
    }
}

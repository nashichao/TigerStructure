package com.practice.tiger.tigerstructure.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.interfaces.ItemTouchMoveListener;
import com.practice.tiger.tigerstructure.interfaces.StartDragListener;
import com.practice.tiger.tigerstructure.model.QQMessage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author：NaShichao
 * Time：2016/12/27  下午5:30
 * Email：na.shichao@163.com
 * Description：
 */

public class DragItemRecyclerAdapter extends RecyclerView.Adapter<DragItemRecyclerAdapter.ViewHolder>
        implements ItemTouchMoveListener {
    private ArrayList<QQMessage> messages;
    private StartDragListener listener;

    public DragItemRecyclerAdapter(ArrayList<QQMessage> messages, StartDragListener listener) {
        this.messages = messages;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drag_item_recycler,
                parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        QQMessage qqMessage = messages.get(position);
        holder.iv_logo.setImageResource(qqMessage.getLogo());
        holder.tv_name.setText(qqMessage.getName());
        holder.tv_Msg.setText(qqMessage.getLastMsg());
        holder.tv_time.setText(qqMessage.getTime());

        holder.iv_logo.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    listener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(messages, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public boolean onItemRemove(int position) {
        messages.remove(position);
        notifyItemRemoved(position);
        return false;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_logo;
        private TextView tv_name;
        private TextView tv_Msg;
        private TextView tv_time;

        ViewHolder(View view) {
            super(view);
            iv_logo = (ImageView) itemView.findViewById(R.id.iv_logo);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_Msg = (TextView) itemView.findViewById(R.id.tv_lastMsg);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}

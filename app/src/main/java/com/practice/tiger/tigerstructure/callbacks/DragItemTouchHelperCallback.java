package com.practice.tiger.tigerstructure.callbacks;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.interfaces.ItemTouchMoveListener;


/**
 * Author：NaShichao
 * Time：2016/12/27  下午7:03
 * Email：na.shichao@163.com
 * Description：RecyclerView 条目触摸 Callback
 */

public class DragItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private ItemTouchMoveListener listener;

    public void setListener(ItemTouchMoveListener listener) {
        this.listener = listener;
    }

    // 用来判断，Callback 回调监听时先调用的，用来判断是什么动作
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT |
                ItemTouchHelper.RIGHT);
//        return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
    }

    // 当移动的时候，回调的方法
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView
            .ViewHolder target) {
        listener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    // 侧滑时的回调
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        listener.onItemRemove(viewHolder.getAdapterPosition());
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getResources().getColor
                    (R.color.colorAccent));
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getResources().getColor
                (android.R.color.white));
        super.clearView(recyclerView, viewHolder);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float
            dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }
}

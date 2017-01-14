package com.practice.tiger.tigerstructure.acitivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.adapters.DragItemRecyclerAdapter;
import com.practice.tiger.tigerstructure.base.BaseActivity;
import com.practice.tiger.tigerstructure.callbacks.DragItemTouchHelperCallback;
import com.practice.tiger.tigerstructure.interfaces.StartDragListener;
import com.practice.tiger.tigerstructure.utils.DataUtils;


public class DragItemRecyclerActivity extends BaseActivity implements StartDragListener {

    private RecyclerView mRecyclerView;
    private DragItemRecyclerAdapter mAdapter;
    private ItemTouchHelper helper;

    @Override
    protected void setRootContentView() {
        setContentView(R.layout.activity_drag_item_recycler);
    }

    @Override
    protected void findViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.drag_item_recycler);
    }

    @Override
    protected void initViewsData() {
        mAdapter = new DragItemRecyclerAdapter(DataUtils.init(), this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        setListeners();
    }

    private void setListeners() {
        DragItemTouchHelperCallback callback = new DragItemTouchHelperCallback();
        callback.setListener(mAdapter);
        helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onStartDrag(ViewHolder viewHolder) {
        helper.startDrag(viewHolder);
    }
}

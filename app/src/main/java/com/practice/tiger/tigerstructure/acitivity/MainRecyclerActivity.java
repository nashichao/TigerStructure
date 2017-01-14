package com.practice.tiger.tigerstructure.acitivity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;


import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.adapters.MainRecyclerAdapter;
import com.practice.tiger.tigerstructure.base.BaseActivity;

import java.util.ArrayList;

public class MainRecyclerActivity extends BaseActivity implements MainRecyclerAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;

    @Override
    protected void setRootContentView() {
        setContentView(R.layout.activity_main_recycler);
    }

    @Override
    protected void findViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
    }

    @Override
    protected void initViewsData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            list.add("第" + (i + 1) + "个数据");
        }
        MainRecyclerAdapter adapter = new MainRecyclerAdapter(list);
        adapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager
                .VERTICAL));
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "点击了第" + position + "项", Toast.LENGTH_SHORT).show();
    }
}
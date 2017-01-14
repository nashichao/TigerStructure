package com.practice.tiger.tigerstructure.acitivity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.widget.TextView;


import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.adapters.HeaderRecyclerAdapter;
import com.practice.tiger.tigerstructure.base.BaseActivity;
import com.practice.tiger.tigerstructure.customwidget.WrapRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HeaderRecyclerViewActivity extends BaseActivity {

    private WrapRecyclerView mRecyclerView;

    @Override
    protected void setRootContentView() {
        setContentView(R.layout.activity_header_recycler_view);
    }

    @Override
    protected void findViews() {
        mRecyclerView = (WrapRecyclerView) findViewById(R.id.head_recycler_view);
    }

    @Override
    protected void initViewsData() {
        TextView headerView = new TextView(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        headerView.setLayoutParams(params);
        headerView.setText("我是HeaderView");
        mRecyclerView.addHeaderView(headerView);

        TextView footerView = new TextView(this);
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams
                .WRAP_CONTENT);
        footerView.setLayoutParams(params);
        footerView.setText("我是FooterView");
        mRecyclerView.addFooterView(footerView);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item " + i);
        }

        HeaderRecyclerAdapter adapter = new HeaderRecyclerAdapter(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }
}

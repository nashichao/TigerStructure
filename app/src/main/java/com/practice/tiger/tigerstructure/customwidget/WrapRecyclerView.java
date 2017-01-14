package com.practice.tiger.tigerstructure.customwidget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Author：NaShichao
 * Time：2016/12/27  下午2:45
 * Email：na.shichao@163.com
 * Description：带有头部的 RecyclerView，配合{@link HeaderViewRecyclerAdapter}存在
 */

public class WrapRecyclerView extends RecyclerView {
    private ArrayList<View> mHeaderViewInfos = new ArrayList<>();
    private ArrayList<View> mFooterViewInfos = new ArrayList<>();
    private Adapter mAdapter;

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void addHeaderView(View v) {
        mHeaderViewInfos.add(v);

        if (mAdapter != null) {
            if (!(mAdapter instanceof HeaderViewRecyclerAdapter)) {
                mAdapter = new HeaderViewRecyclerAdapter(mHeaderViewInfos, mFooterViewInfos, mAdapter);
            }
        }
    }


    public void addFooterView(View v) {
        mFooterViewInfos.add(v);

        if (mAdapter != null) {
            if (!(mAdapter instanceof HeaderViewRecyclerAdapter)) {
                mAdapter = new HeaderViewRecyclerAdapter(mHeaderViewInfos, mFooterViewInfos, mAdapter);
            }
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (mHeaderViewInfos.size() > 0 || mFooterViewInfos.size() > 0) {
            mAdapter = new HeaderViewRecyclerAdapter(mHeaderViewInfos, mFooterViewInfos, adapter);
        } else {
            mAdapter = adapter;
        }

        super.setAdapter(mAdapter);
    }
}

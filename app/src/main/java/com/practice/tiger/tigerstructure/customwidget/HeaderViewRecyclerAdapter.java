package com.practice.tiger.tigerstructure.customwidget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Author：NaShichao
 * Time：2016/12/27  下午3:03
 * Email：na.shichao@163.com
 * Description：RecyclerView 自定义适配器
 */

public class HeaderViewRecyclerAdapter extends RecyclerView.Adapter {
    private Adapter mAdapter;
    private ArrayList<View> mHeaderViewInfos = new ArrayList<>();
    private ArrayList<View> mFooterViewInfos = new ArrayList<>();

    public HeaderViewRecyclerAdapter(ArrayList<View> headerViewInfos, ArrayList<View> footerViewInfos,
                                     Adapter adapter) {
        mAdapter = adapter;

        if (headerViewInfos == null) {
            mHeaderViewInfos = new ArrayList<>();
        } else {
            mHeaderViewInfos = headerViewInfos;
        }

        if (footerViewInfos == null) {
            mFooterViewInfos = new ArrayList<>();
        } else {
            mFooterViewInfos = footerViewInfos;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //header
        if (viewType == RecyclerView.INVALID_TYPE) {
            return new HeaderViewHolder(mHeaderViewInfos.get(0));
        } else if (viewType == RecyclerView.INVALID_TYPE - 1) {//footer
            return new HeaderViewHolder(mFooterViewInfos.get(0));
        }
        // Footer (off-limits positions will throw an IndexOutOfBoundsException)
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return;
        }
        //adapter body
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mAdapter.onBindViewHolder(holder, adjPosition);
                return;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            // 是 header
            return RecyclerView.INVALID_TYPE;
        }
        // Adapter正常条目部分
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                return mAdapter.getItemViewType(adjPosition);
            }
        }
        //footer
        return RecyclerView.INVALID_TYPE - 1;
    }

    @Override
    public int getItemCount() {
        if (mAdapter != null) {
            return mAdapter.getItemCount() + getHeadersCount() + getFootersCount();
        } else {
            return getHeadersCount() + getFootersCount();
        }
    }


    private int getHeadersCount() {
        return mHeaderViewInfos.size();
    }

    private int getFootersCount() {
        return mFooterViewInfos.size();
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        HeaderViewHolder(View view) {
            super(view);
        }
    }
}

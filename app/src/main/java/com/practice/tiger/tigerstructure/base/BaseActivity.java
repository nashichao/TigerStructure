package com.practice.tiger.tigerstructure.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Author：NaShichao
 * Time：2016/12/26  上午11:11
 * Email：na.shichao@163.com
 * Description：Activity基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRootContentView();
        findViews();
        initViewsData();
    }

    protected abstract void setRootContentView();

    protected abstract void findViews();

    protected abstract void initViewsData();
}

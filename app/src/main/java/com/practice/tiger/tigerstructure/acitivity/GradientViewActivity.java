package com.practice.tiger.tigerstructure.acitivity;

import android.widget.LinearLayout;

import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.base.BaseActivity;
import com.practice.tiger.tigerstructure.customview.ZoomImageView;

public class GradientViewActivity extends BaseActivity {

    private LinearLayout linearLayout;

    @Override
    protected void setRootContentView() {
        setContentView(R.layout.activity_gradient_view);
    }

    @Override
    protected void findViews() {
        linearLayout = (LinearLayout) findViewById(R.id.activity_gradient_view);
    }

    @Override
    protected void initViewsData() {
        linearLayout.addView(new ZoomImageView(this));
    }
}

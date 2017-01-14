package com.practice.tiger.tigerstructure;

import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.practice.tiger.tigerstructure.acitivity.CircleProgressbarActivity;
import com.practice.tiger.tigerstructure.acitivity.DragItemRecyclerActivity;
import com.practice.tiger.tigerstructure.acitivity.GradientViewActivity;
import com.practice.tiger.tigerstructure.acitivity.HeaderRecyclerViewActivity;
import com.practice.tiger.tigerstructure.acitivity.MainRecyclerActivity;
import com.practice.tiger.tigerstructure.acitivity.NavigationActivity;
import com.practice.tiger.tigerstructure.acitivity.PropertyAnimationActivity;
import com.practice.tiger.tigerstructure.acitivity.SimpleHoriProgressActivity;
import com.practice.tiger.tigerstructure.acitivity.SlidingPriceBarActivity;
import com.practice.tiger.tigerstructure.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private AppCompatButton toMainRecyclerBtn, toHeaderRecyclerBtn, toDragRecyclerBtn, toNavigationBtn,
            toAnimationBtn, toCircleProgress, toSlidingPriceBar, toSimpleHoriProgress, toGradient;

    @Override
    protected void setRootContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findViews() {
        toMainRecyclerBtn = (AppCompatButton) findViewById(R.id.to_main_recycler_btn);
        toHeaderRecyclerBtn = (AppCompatButton) findViewById(R.id.to_header_recycler_btn);
        toDragRecyclerBtn = (AppCompatButton) findViewById(R.id.to_drag_recycler_btn);
        toNavigationBtn = (AppCompatButton) findViewById(R.id.to_navigation_btn);
        toAnimationBtn = (AppCompatButton) findViewById(R.id.to_property_animation_btn);
        toCircleProgress = (AppCompatButton) findViewById(R.id.to_circle_progress);
        toSlidingPriceBar = (AppCompatButton) findViewById(R.id.to_sliding_price_bar);
        toSimpleHoriProgress = (AppCompatButton) findViewById(R.id.to_hori_simple_progress);
        toGradient = (AppCompatButton) findViewById(R.id.to_gradient);
    }

    @Override
    protected void initViewsData() {
        toMainRecyclerBtn.setOnClickListener(this);
        toHeaderRecyclerBtn.setOnClickListener(this);
        toDragRecyclerBtn.setOnClickListener(this);
        toNavigationBtn.setOnClickListener(this);
        toAnimationBtn.setOnClickListener(this);
        toCircleProgress.setOnClickListener(this);
        toSlidingPriceBar.setOnClickListener(this);
        toSimpleHoriProgress.setOnClickListener(this);
        toGradient.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.to_main_recycler_btn:
                intent = new Intent(this, MainRecyclerActivity.class);
                startActivity(intent);
                break;
            case R.id.to_header_recycler_btn:
                intent = new Intent(this, HeaderRecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.to_drag_recycler_btn:
                intent = new Intent(this, DragItemRecyclerActivity.class);
                startActivity(intent);
                break;
            case R.id.to_navigation_btn:
                intent = new Intent(this, NavigationActivity.class);
                startActivity(intent);
                break;
            case R.id.to_property_animation_btn:
                intent = new Intent(this, PropertyAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.to_circle_progress:
                intent = new Intent(this, CircleProgressbarActivity.class);
                startActivity(intent);
                break;
            case R.id.to_sliding_price_bar:
                intent = new Intent(this, SlidingPriceBarActivity.class);
                startActivity(intent);
                break;
            case R.id.to_hori_simple_progress:
                intent = new Intent(this, SimpleHoriProgressActivity.class);
                startActivity(intent);
                break;
            case R.id.to_gradient:
                intent = new Intent(this, GradientViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}

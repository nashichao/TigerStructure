package com.practice.tiger.tigerstructure.acitivity;

import android.view.View;

import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.base.BaseActivity;
import com.practice.tiger.tigerstructure.customview.CircleProgressbar;


public class CircleProgressbarActivity extends BaseActivity implements View.OnClickListener {

    private CircleProgressbar progressbar;
    private int progress;

    @Override
    protected void setRootContentView() {
        setContentView(R.layout.activity_circle_progressbar);
    }

    @Override
    protected void findViews() {
        progressbar = (CircleProgressbar) findViewById(R.id.circle_progressbar_1);
    }

    @Override
    protected void initViewsData() {
        progressbar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress <= 100) {
                    progressbar.setProgress(++progress);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progress = 0;
            }
        }).start();
    }
}

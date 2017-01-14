package com.practice.tiger.tigerstructure.acitivity;


import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.base.BaseActivity;
import com.practice.tiger.tigerstructure.customview.SimpleHoriProgressView;

public class SimpleHoriProgressActivity extends BaseActivity {

    private SimpleHoriProgressView progressView;
    private int progress;
    private boolean stopFlag;

    @Override
    protected void setRootContentView() {
        setContentView(R.layout.activity_simple_hori_progress);
    }

    @Override
    protected void findViews() {
        progressView = (SimpleHoriProgressView) findViewById(R.id.simple_hori_progressbar);
    }

    @Override
    protected void initViewsData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < 300 && !stopFlag) {
                    progressView.setProgress(++progress);
                    if (progress == 299) {
                        progress = 0;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopFlag = true;
    }
}

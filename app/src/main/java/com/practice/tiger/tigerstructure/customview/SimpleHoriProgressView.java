package com.practice.tiger.tigerstructure.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.practice.tiger.tigerstructure.R;


/**
 * Author：NaShichao
 * Time：2017/1/11  下午10:37
 * Email：na.shichao@163.com
 * Description：
 */

public class SimpleHoriProgressView extends View {
    private Paint paint;
    private int max;
    private float progress;
    private Path path = new Path();

    public SimpleHoriProgressView(Context context) {
        super(context);
        paint = new Paint();
    }

    public SimpleHoriProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SimpleHoriProgressView);
        max = array.getInteger(R.styleable.SimpleHoriProgressView_simple_hori_pro_max, 300);
        array.recycle();
        paint = new Paint();
    }

    public SimpleHoriProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.moveTo(50, 50);
        path.lineTo(50, 350);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(30);
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);

        float percent = progress / 300f;
        path.reset();
        path.moveTo(50, 50);
        path.lineTo(50, 50 + 300 * percent);
        paint.setColor(Color.RED);
        canvas.drawPath(path, paint);
    }

    public float getProgress() {
        return progress;
    }

    public synchronized void setProgress(float progress) {
        if (progress < 0) {
            throw new IllegalArgumentException("progress值不能传小于零的");
        }
        if (progress > max) {
            progress = max;
        }
        this.progress = progress;
        postInvalidate();
    }
}

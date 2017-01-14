package com.practice.tiger.tigerstructure.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author：NaShichao
 * Time：2017/1/12  下午7:37
 * Email：na.shichao@163.com
 * Description：
 */

public class ScanView extends View {
    private Paint paint;
    private int radius;
    private int[] colors = new int[]{Color.TRANSPARENT, Color.TRANSPARENT, Color.BLUE};
    private float[] percent = new float[]{0f, 0.15f, 1f};
    private SweepGradient sweepGradient;
    private ShapeDrawable drawable;
    private Matrix matrix = new Matrix();
    private float deltaDegrees;

    public ScanView(Context context) {
        this(context, null);
    }

    public ScanView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScanView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        drawable = new ShapeDrawable();
        drawable.setShape(new OvalShape());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = getWidth() / 2;
        sweepGradient = new SweepGradient(radius, radius, colors, percent);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);
        canvas.drawCircle(radius, radius, radius, paint);
        matrix.setRotate(deltaDegrees += 1, radius, radius);
        sweepGradient.setLocalMatrix(matrix);
        paint.setShader(sweepGradient);
        drawable.setBounds(0, 0, radius * 2, radius * 2);
        postInvalidateDelayed(2);
    }
}

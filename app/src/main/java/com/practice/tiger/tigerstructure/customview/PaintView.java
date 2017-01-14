package com.practice.tiger.tigerstructure.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author：NaShichao
 * Time：2017/1/10  下午7:44
 * Email：na.shichao@163.com
 * Description：
 */

public class PaintView extends View {
    private Paint mPaint;
    private String string = "android安卓练习practise";
    float[] measureWidth = new float[1];

    public PaintView(Context context) {
        super(context);
        mPaint = new Paint();
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.reset();

        // 损失性能
//        mPaint.setAntiAlias(true);
        // 设置是否使用图像抖动处理。会使绘制的图片等颜色更加清晰以及饱满，同样也是损失性能
//        mPaint.setDither(true);
//        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        // 计算定制长度的字符串（字符长度，字符个数，显示的时候真实的长度）
//        mPaint.breakText()
        mPaint.setTextSize(50);
        int breakText = mPaint.breakText(string, true, 200, measureWidth);
//        mPaint.getTextWidths()
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
//        fontMetrics.ascent
    }
}

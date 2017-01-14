package com.practice.tiger.tigerstructure.customwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Author：NaShichao
 * Time：2017/1/12  下午2:57
 * Email：na.shichao@163.com
 * Description：
 */

public class BrightTextView extends TextView {
    private int[] colors = new int[]{Color.BLACK, Color.WHITE, Color.BLACK};
    private float[] percent = new float[]{0f, 0.5f, 1f};
    private LinearGradient gradient = new LinearGradient(0, 200, 200, 200, colors, percent, Shader.TileMode
            .CLAMP);
    private Matrix matrix = new Matrix();
    private int deltaX = 20;
    private int translation;

    public BrightTextView(Context context) {
        super(context);
    }

    public BrightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BrightTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        getPaint().setShader(gradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        matrix.setTranslate(translation, 0);
        translation += deltaX;
        if (translation > getWidth() || translation < -200) {
            deltaX = -deltaX;
        }
        gradient.setLocalMatrix(matrix);
        postInvalidateDelayed(50);
    }
}

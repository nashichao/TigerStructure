package com.practice.tiger.tigerstructure.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.practice.tiger.tigerstructure.R;


/**
 * Author：NaShichao
 * Time：2017/1/11  上午9:16
 * Email：na.shichao@163.com
 * Description：
 */

public class CircleProgressbar extends View {
    private int style;
    private int max;//
    private int roundColor;// 圆形底色
    private int roundProgressColor;// 圆环色
    private int textColor;// 字体颜色
    private float roundWidth;// 圆形环宽度
    private boolean shownText;//
    private float textSize;

    private int progress;
    private Paint paint;
    private RectF oval;

    public static final int STROKE = 0;
    public static final int FILL = 1;

    public CircleProgressbar(Context context) {
        super(context);
    }

    public CircleProgressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressbar);
        max = typedArray.getInteger(R.styleable.CircleProgressbar_max, 100);
        roundColor = typedArray.getColor(R.styleable.CircleProgressbar_roundColor, Color.RED);
        roundProgressColor = typedArray.getColor(R.styleable.CircleProgressbar_roundProgressColor, Color
                .BLUE);
        textColor = typedArray.getColor(R.styleable.CircleProgressbar_textColor, Color.GREEN);
        roundWidth = typedArray.getDimension(R.styleable.CircleProgressbar_roundWidth, 20);
        textSize = typedArray.getDimension(R.styleable.CircleProgressbar_textSize, 20);
        shownText = typedArray.getBoolean(R.styleable.CircleProgressbar_textShow, false);
        style = typedArray.getInt(R.styleable.CircleProgressbar_style, 0);
        typedArray.recycle();
    }

    public CircleProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth() / 2;

        float radius = center - roundWidth / 2;//半径
        paint.setColor(roundColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(roundWidth);
        paint.setAntiAlias(true);
        // 画默认的大圆环
        canvas.drawCircle(center, center, radius, paint);

        // 画进度百分比
        paint.setColor(textColor);
        paint.setStrokeWidth(0);
        paint.setTextSize(textSize);
        paint.setTypeface(Typeface.DEFAULT_BOLD);

        int percent = (int) (progress / (float) max * 100);
        if (shownText && style == 0) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float baseLine = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom + center;
            canvas.drawText(percent + "%", (getWidth() - paint.measureText(percent + "%")) / 2, baseLine,
                    paint);
        }

        // 画圆弧
        // 矩形区域，定义圆弧的形状大小

        if (oval == null)
//            oval = new RectF(center - radius, center - radius, center + radius, center + radius);
            oval = new RectF(roundWidth / 2, roundWidth / 2, getWidth() - roundWidth / 2, getHeight() -
                    roundWidth / 2);
        paint.setColor(roundProgressColor);
        paint.setStrokeWidth(roundWidth);
        switch (style) {
            case STROKE:
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawArc(oval, -90, 360 * ((float) progress / max), false, paint);
                break;
            case FILL:
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                if (progress != 0)
                    canvas.drawArc(oval, -90, 360 * ((float) progress / max), true, paint);
                break;
        }
    }

    public synchronized int getMax() {
        return max;
    }

    public synchronized void setMax(int max) {
        if (max < 0) {
            throw new IllegalArgumentException("max不能小于零");
        }
        this.max = max;
    }

    public synchronized int getProgress() {
        return progress;
    }

    public synchronized void setProgress(int progress) {
        if (progress < 0) {
            throw new IllegalArgumentException("progress不能小于零");
        }
        if (progress > max) {
            progress = max;
        }
        if (progress <= max) {
            this.progress = progress;
            postInvalidate();
        }
    }

    public int getRoundColor() {
        return roundColor;
    }

    public void setRoundColor(int roundColor) {
        this.roundColor = roundColor;
    }

    public int getRoundProgressColor() {
        return roundProgressColor;
    }

    public void setRoundProgressColor(int roundProgressColor) {
        this.roundProgressColor = roundProgressColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public float getRoundWidth() {
        return roundWidth;
    }

    public void setRoundWidth(float roundWidth) {
        this.roundWidth = roundWidth;
    }

    public boolean isShownText() {
        return shownText;
    }

    public void setShownText(boolean shownText) {
        this.shownText = shownText;
    }
}

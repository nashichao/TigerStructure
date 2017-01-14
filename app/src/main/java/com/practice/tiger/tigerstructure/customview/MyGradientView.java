package com.practice.tiger.tigerstructure.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.practice.tiger.tigerstructure.R;

/**
 * Author：NaShichao
 * Time：2017/1/12  上午11:35
 * Email：na.shichao@163.com
 * Description：
 */

public class MyGradientView extends View {

    private Bitmap bitmap;
    private Paint paint;
    private BitmapShader bitmapShader;

    Rect rect = new Rect(0, 0, 300, 300);
    private int width;
    private int height;

    public MyGradientView(Context context) {
        super(context);
        paint = new Paint();
        width = bitmap.getWidth();
        height = bitmap.getHeight();
    }

    public MyGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.icon_people)).getBitmap();
    }

    public MyGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

//        canvas.drawBitmap(bitmap, 0, 0, paint);

        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bitmapShader);


//        canvas.drawRect(rect, paint);

        // 画圆形头像
        canvas.drawCircle(width / 2, width / 2, width / 2, paint);
    }
}

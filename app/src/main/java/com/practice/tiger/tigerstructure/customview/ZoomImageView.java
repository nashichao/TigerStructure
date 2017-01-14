package com.practice.tiger.tigerstructure.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.MotionEvent;
import android.view.View;

import com.practice.tiger.tigerstructure.R;


/**
 * Author：NaShichao
 * Time：2017/1/12  下午4:33
 * Email：na.shichao@163.com
 * Description：
 */

public class ZoomImageView extends View {

    private Bitmap bitmap;
    private ShapeDrawable shapeDrawable;
    private static final int FACTOR = 3;// 放大倍数
    private static final int RADIUS = 200;// 放大半径
    private Matrix localM = new Matrix();

    public ZoomImageView(Context context) {
        super(context);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.angelina);

        // 放大后的整个图片
        Bitmap bmp = bitmap;
        bmp = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * FACTOR, bitmap.getHeight() * FACTOR,
                true);

        BitmapShader bitmapShader = new BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        // 制作一个圆形的图片，盖在canvas上面
        shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setShader(bitmapShader);
        // 切出矩形区域---用于绘制圆
        shapeDrawable.setBounds(0, 0, RADIUS * 2, RADIUS * 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, null);

        // 画制作好的圆形的图片
        shapeDrawable.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        localM.setTranslate(RADIUS - x * FACTOR, RADIUS - y * FACTOR);
        shapeDrawable.getPaint().getShader().setLocalMatrix(localM);
        shapeDrawable.setBounds(x - RADIUS, y - RADIUS, x + RADIUS, y + RADIUS);

        postInvalidate();
        return super.onTouchEvent(event);
    }
}

package com.practice.tiger.tigerstructure.acitivity;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;

import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.base.BaseActivity;


public class PropertyAnimationActivity extends BaseActivity {

    @Override
    protected void setRootContentView() {
        setContentView(R.layout.activity_property_animation);

    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void initViewsData() {
        View inflate = View.inflate(this, R.layout.item_main_recycler, null);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
    }

    public void startAnimation(final View view) {
        // 补间动画
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
//        view.startAnimation(animation);
        // --------------------------1.单个动画-------------------------
        // 属性动画
//        view.setTranslationX(100);

//        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", 0f, 300f);
//        ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translation", 0f, 300f);
//        ObjectAnimator rotationX = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
//        rotationX.setDuration(500);
//        rotationX.start();

        // --------------------------2.多个动画：-------------------------

        // 方法一：设置动画监听，开始第一个动画的同时开始其他动画
//        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "haha", 0f,200f);//
// 没有这个属性的时候，就是一个ValueAnimator
//        animator.setDuration(5000);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                // 动画在执行当中，不断地调用此方法
//                animation.getAnimatedFraction();// 百分比
//                float value = (float) animation.getAnimatedValue();// 得到duration时间内values当中的某一个中间值
//                view.setAlpha(value/200);
//                view.setScaleX(value/200);
//                view.setScaleY(value/200);
//            }
//        });
//        animator.start();


        // 方法二
//        ValueAnimator animator = ValueAnimator.ofFloat(0f, 200f);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();// 得到duration时间内values当中的某一个中间值
//                view.setAlpha(value / 200);
//                view.setScaleX(value / 200);
//                view.setScaleY(value / 200);
//            }
//        });
//        animator.setDuration(2000);
//        animator.start();


        // 方法三
//        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0.5f, 1f);
//        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.3f, 1f);
//        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.3f, 1f);
//        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, holder1, holder2, holder3);
//        animator.start();


        // 方法四 --------------------------动画集合-------------------------
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(animator).with(animator).after(animator)

        // --------------------------案例：抛物线效果-------------------------
        /**
         * x:匀速
         * y:加速度 y = 1/2*g*t*t
         * 使用估值器最好实现
         */
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(700);
        valueAnimator.setObjectValues(new PointF(0, 0));
        // 定义计算规则
        valueAnimator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                // 拿到每一个时间点的坐标
                // x
                PointF pointF = new PointF();
//                pointF.x = 150f * fraction * 4;// 初始速度*时间
//                pointF.y = 0.5f * 500f * (fraction * 4) * (fraction * 4);
                pointF.x = fraction * 400;// 初始速度*时间
                pointF.y = fraction * 400;
                return pointF;
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 得到此时间点的坐标
                PointF pointF = (PointF) animation.getAnimatedValue();
                view.setX(pointF.x);
                view.setY(pointF.y);
            }
        });
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
    }
}

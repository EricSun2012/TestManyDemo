package com.robot.anyDemo.gouwuche;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.LinearLayoutManager;

import com.robot.anyDemo.R;

public class BuyCarActivity extends AppCompatActivity implements AnimationInterface {

    private RecyclerView mAnim_rv;
    private ImageView mIv_pay_anim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buycar);

        mAnim_rv = findViewById(R.id.anim_rv);
        mIv_pay_anim = findViewById(R.id.iv_pay_anim);

        mAnim_rv.setLayoutManager(new LinearLayoutManager(this));
        mAnim_rv.setAdapter(new MyAnimationAdapter(this));
    }

    @Override
    public void playAnimation(int[] position) {
        ImageView mImg = new ImageView(this);
        mImg.setImageResource(R.drawable.circle);
        mImg.setScaleType(ImageView.ScaleType.MATRIX);
        ViewGroup rootView = (ViewGroup) getWindow().getDecorView();
        rootView.addView(mImg);

        int[] des = new int[2];
        mIv_pay_anim.getLocationInWindow(des);

        /*动画开始位置，也就是物品的位置动画结束的位置，也就是购物车的位置 */
        Point startPosition = new Point(position[0], position[1]);
        Point endPosition = new Point(des[0] + mIv_pay_anim.getWidth() / 2 - mImg.getWidth() / 2, des[1] + mIv_pay_anim.getHeight() / 2);

        int pointX = (startPosition.getX() + endPosition.getX()) / 2 - 100;
        int pointY = startPosition.getY() - 200;
        Point controllPoint = new Point(pointX, pointY);

        /*
         * 属性动画，依靠TypeEvaluator来实现动画效果，其中位移，缩放，渐变，旋转都是可以直接使用
         * 这里是自定义了TypeEvaluator， 我们通过point记录运动的轨迹，然后，物品随着轨迹运动，
         * 一旦轨迹发生变化，就会调用addUpdateListener这个方法，我们不断的获取新的位置，是物品移动
         * */
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new BizierEvaluator2(controllPoint), startPosition, endPosition);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                mImg.setX(point.getX());
                mImg.setY(point.getY());
            }
        });


        /**
         * 动画结束，移除掉小圆圈
         */
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ViewGroup rootView = (ViewGroup) getWindow().getDecorView();
                rootView.removeView(mImg);
            }
        });


    }

    @Override
    public Context getContext() {
        return this;
    }
}

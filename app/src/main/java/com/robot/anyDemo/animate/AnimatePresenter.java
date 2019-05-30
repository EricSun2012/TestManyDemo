package com.robot.anyDemo.animate;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BasePresenter;
import com.robot.anyDemo.base.BaseView;
import com.robot.anyDemo.gouwuche.BizierEvaluator2;
import com.robot.anyDemo.gouwuche.Point;

public class AnimatePresenter extends BasePresenter {
    public AnimatePresenter(BaseView baseView) {
        super(baseView);
    }


    public void startScaleProperty(ImageView imageView) {
        imageView.clearAnimation();
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 0.7f, 1f);
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 0.7f, 1f);

        AnimatorSet animSet = new AnimatorSet();
        animSet.play(animatorY).with(animatorX);
        animSet.setDuration(300);


        animSet.start();
    }


    public void startRotationProperty(ImageView imageView) {
        imageView.clearAnimation();
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotationX", 0f, 360f, 720f);
        animator.setDuration(5000);
        animator.start();
    }

    public void startTranslationProperty(ImageView imageView) {
        imageView.clearAnimation();
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", 0f, 200f);
        animator.setDuration(300);
        animator.start();
    }

    public void startBounceProperty(ImageView imageView) {
        imageView.clearAnimation();

        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "X", 10f, 200f);
        animator.setDuration(300);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    public void startColorProperty(ImageView imageView) {
        ValueAnimator animator = ObjectAnimator.ofInt(imageView, "backgroundColor", 0x00ff0000, 0x6600ff00);//对背景色颜色进行改变，操作的属性为"backgroundColor",此处必须这样写，不能全小写,后面的颜色为在对应颜色间进行渐变
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());//如果要颜色渐变必须要ArgbEvaluator，来实现颜色之间的平滑变化，否则会出现颜色不规则跳动
        animator.start();

    }

    public void startValueProperty(ImageView imageView) {
        imageView.clearAnimation();

        /*动画开始位置，也就是物品的位置动画结束的位置，也就是购物车的位置 */
        Point startPosition = new Point(100, 100);

        Point controllPoint = new Point(830, 330);
        ValueAnimator animator = ValueAnimator.ofObject(new BizierEvaluator2(controllPoint), startPosition, new Point(600, 1000));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                imageView.setX(point.getX());
                imageView.setY(point.getY());
            }
        });
        animator.setDuration(300);
        animator.start();
    }


    public void startSvgAnimation(ImageView imageView) {
        imageView.clearAnimation();
        imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.animal_svg_vector));

        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) imageView.getDrawable();
        animatedVectorDrawable.start();
    }
}

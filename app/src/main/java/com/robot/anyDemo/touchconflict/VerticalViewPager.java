package com.robot.anyDemo.touchconflict;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * 使用须知：上下切换需要添加竖向的pageTransformer，并且关闭滑块
 * <p>
 * mVerticalViewPager.setPageTransformer(true, new VerticalTransformer());
 * mVerticalViewPager.setOverScrollMode(OVER_SCROLL_NEVER);
 */
public class VerticalViewPager extends ViewPager {
    public VerticalViewPager(Context context) {
        super(context);
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private MotionEvent swapTouchEvent(MotionEvent event) {
        float width = getWidth();
        float height = getHeight();
        event.setLocation((event.getY() / height) * width, (event.getX() / width) * height * 0.3f);
        return event;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return super.onInterceptTouchEvent(swapTouchEvent(MotionEvent.obtain(event)));
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapTouchEvent(MotionEvent.obtain(ev)));
    }

}

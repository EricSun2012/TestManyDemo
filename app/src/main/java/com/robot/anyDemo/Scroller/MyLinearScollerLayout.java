package com.robot.anyDemo.Scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;

public class MyLinearScollerLayout extends ViewGroup {

    private OverScroller mScroller;
    private int tapslop;
    private float mXDown;
    private float mYDown;
    private float xLast;
    private float yLast;
    private float contentHeight;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                childView.layout(0, i * childView.getMeasuredHeight(), childView.getMeasuredWidth(), (i + 1) * childView.getMeasuredHeight());
            }
            if (childCount > 0) {
                contentHeight = getChildAt(childCount - 1).getBottom();
            } else {
                contentHeight = getMeasuredHeight();
            }
        }
    }

    public MyLinearScollerLayout(Context context) {
        this(context, null);
    }

    public MyLinearScollerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLinearScollerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new OverScroller(context);
        tapslop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mScroller.abortAnimation();
                xLast = mXDown = event.getX();
                yLast = mYDown = event.getY();

                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                float curY = event.getY();
                int scrollerY = (int) (yLast - curY);
                int oriY = getScrollY();
                if (oriY + getHeight() + scrollerY > contentHeight) {
                    scrollTo(0, (int) (contentHeight - getHeight()));
                    return true;
                } else if (oriY + scrollerY < 0) {
                    yLast = 0;
                    scrollTo(0, 0);
                    return true;

                }
                scrollBy(0, scrollerY);
                yLast = curY;

            }
            break;
            case MotionEvent.ACTION_UP: {
                int scrollerY = (int) ((mYDown - event.getY()) * 0.2);
                if (getScrollY() + scrollerY < 0) {
                    scrollerY = 0;
                } else if (getScrollY() + getHeight() + scrollerY > contentHeight) {
                    scrollerY = 0;
                }
                mScroller.startScroll(0, getScrollY(), 0, scrollerY);
                invalidate();

            }
            break;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }
}

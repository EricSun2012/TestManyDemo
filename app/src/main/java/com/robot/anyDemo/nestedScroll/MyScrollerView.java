package com.robot.anyDemo.nestedScroll;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingParent2;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MyScrollerView extends LinearLayout implements NestedScrollingParent2 {

    private View mHeader;
    private int mHeaderHeight;

    public MyScrollerView(Context context) {
        super(context);
    }

    public MyScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            mHeader = getChildAt(0);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mHeader.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        int totalHeight = MeasureSpec.getSize(heightMeasureSpec) + mHeader.getMeasuredHeight();
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(totalHeight, mode));
    }

    @Override
    public void scrollTo(int dx, int dy) {
        if (dy < 0) {
            dy = 0;
        } else if (dy > mHeaderHeight) {
            dy = mHeaderHeight;
        }

        super.scrollTo(dx, dy);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view1, int i, int i1) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view1, int i, int i1) {

    }

    @Override
    public void onStopNestedScroll(@NonNull View view, int i) {

    }

    @Override
    public void onNestedScroll(@NonNull View view, int i, int i1, int i2, int i3, int i4) {

    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int i2) {
        boolean headerScrollUp = dy > 0 && getScrollY() < mHeaderHeight;
        boolean headerScrollDown = dy < 0 && getScrollY() > 0 && !target.canScrollVertically(-1);

        Log.i("move", "dx=" + dx + ",dy=" + dy);
        if (headerScrollUp || headerScrollDown) {
            scrollBy(0, dy);
            consumed[1] = dy;
        }
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeaderHeight = mHeader.getMeasuredHeight();
    }
}

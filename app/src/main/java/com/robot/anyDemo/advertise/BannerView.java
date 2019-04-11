package com.robot.anyDemo.advertise;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.robot.anyDemo.R;

import java.util.ArrayList;

public class BannerView extends FrameLayout {
    private SparseArray<Drawable> mSparse = new SparseArray(7);
    private SparseArray<String> mTipsSparse = new SparseArray<>(7);
    private Context mContext;

    private ViewPager mViewPager;
    private TextView tipsTextView;

    private Handler mHandler;

    private Runnable runnable;

    public BannerView(Context context) {
        super(context);
        initView(context);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void setPagerAnimation(int type) {
        switch (type) {
            case 0: {
                mViewPager.setPageTransformer(true, new DefaultTransformer());

            } break;
        }
    }


    public void setDrawables(ArrayList<Drawable> data, ArrayList<String> tips) {
        if (null == data || data.size() == 0) return;
        stopRoll();
        mSparse.clear();
        mTipsSparse.clear();
        for (int i = 0; i < data.size(); i++) {
            mSparse.put(i, data.get(i));
            mTipsSparse.put(i, tips != null && tips.size() > i ? tips.get(i) : "");
        }
        mViewPager.setCurrentItem(0);
        tipsTextView.setText(tips != null && tips.size() > 0 ? tips.get(0) : "");
        startRoll();
    }

    private void initView(Context context) {
        mContext = context;
        mHandler = new Handler();

        View view = LayoutInflater.from(mContext).inflate(R.layout.view_banner, null);
        addView(view);
        mViewPager = view.findViewById(R.id.banner_viewpager);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new BannerAdapter());

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tipsTextView.setText(mTipsSparse.get(i % mSparse.size()));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        tipsTextView = view.findViewById(R.id.banner_tipsTitle);
        runnable = new Runnable() {
            @Override
            public void run() {
                startRoll();
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
            }
        };
    }

    public void startRoll() {
        mHandler.postDelayed(runnable, 2500);
    }

    public void stopRoll() {
        mHandler.removeCallbacks(runnable);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopRoll();
    }

    public class BannerAdapter extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            View view = LayoutInflater.from(mContext).inflate(R.layout.item_advertise, null);
            container.addView(view);
            ImageView imageView = view.findViewById(R.id.img);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageDrawable(mSparse.get(position % mSparse.size()));
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }
    }

}

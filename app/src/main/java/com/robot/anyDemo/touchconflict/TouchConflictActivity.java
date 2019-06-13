package com.robot.anyDemo.touchconflict;

import android.view.LayoutInflater;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.robot.anyDemo.R;
import com.robot.anyDemo.advertise.DefaultTransformer;
import com.robot.anyDemo.base.BaseActivity;
import com.robot.anyDemo.base.BasePresenter;

import java.util.ArrayList;

public class TouchConflictActivity extends BaseActivity {

    private ViewPager firstViewPager;
    private ViewPager secondViewPager;

    private TouchAdapter firstAdapter = new TouchAdapter();
    private TouchAdapter secondAdapter = new TouchAdapter();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_conflict;
    }

    @Override
    public void initView() {
        firstViewPager = findViewById(R.id.firstViewPager);
        secondViewPager = findViewById(R.id.secondViewPager);
        secondViewPager.setPageTransformer(true, new DefaultTransformer());

        firstViewPager.setAdapter(firstAdapter);
        secondViewPager.setAdapter(secondAdapter);
    }

    @Override
    public void initData() {
        ArrayList<String> data = new ArrayList<>();
        data.add("12312414124");
        data.add("544512321312142q");
        data.add("3165454312");

        firstAdapter.setDataSource(data);
        secondAdapter.setDataSource(data);
        ArrayList<View> firstCache = new ArrayList<View>();
        View view = LayoutInflater.from(this).inflate(R.layout.view_touch_first, null);
        firstCache.add(view);
        view = LayoutInflater.from(this).inflate(R.layout.view_touch_first, null);
        firstCache.add(view);
        view = LayoutInflater.from(this).inflate(R.layout.view_touch_first, null);
        firstCache.add(view);

        ArrayList<View> secondCache = new ArrayList<View>();
        view = LayoutInflater.from(this).inflate(R.layout.view_touch_second, null);
        secondCache.add(view);
        view = LayoutInflater.from(this).inflate(R.layout.view_touch_second, null);
        secondCache.add(view);
        view = LayoutInflater.from(this).inflate(R.layout.view_touch_second, null);
        secondCache.add(view);


        firstAdapter.setViewCache(firstCache);
        secondAdapter.setViewCache(secondCache);

        firstAdapter.notifyDataSetChanged();
        secondAdapter.notifyDataSetChanged();
    }
}

package com.robot.anyDemo.touchconflict;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TouchAdapter extends PagerAdapter {

    private List<String> dataSource = new ArrayList<>();
    private List<View> viewCache = new ArrayList<>();

    public void setDataSource(List<String> data) {
        dataSource.addAll(data);
    }

    public void setViewCache(List<View> cache) {
        viewCache.addAll(cache);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = viewCache.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

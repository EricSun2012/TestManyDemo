package com.robot.anyDemo.Scroller;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

public class ScrollerActivity extends BaseActivity<ScrollerPresenter> implements ScrollerView {
    @Override
    protected ScrollerPresenter createPresenter() {
        return new ScrollerPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scroller;
    }

    @Override
    public void initData() {
        setTitle("ScrollerGroup");
    }

    @Override
    public void initView() {

    }
}

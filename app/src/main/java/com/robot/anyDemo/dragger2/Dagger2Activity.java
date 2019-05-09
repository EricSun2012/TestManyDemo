package com.robot.anyDemo.dragger2;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

public class Dagger2Activity extends BaseActivity<Dragger2Presenter> {
    @Override
    protected Dragger2Presenter createPresenter() {
        return new Dragger2Presenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dagger;
    }

    @Override
    public void initData() {
        setTitle("Dagger2");
    }
}

package com.robot.anyDemo.RxJava;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

import io.reactivex.Observable;


public class RxActivity extends BaseActivity<RxPresenter> {
    @Override
    protected RxPresenter createPresenter() {
        return new RxPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxjava;
    }

    @Override
    public void initData() {
        setTitle("RxJava");
    }

    @Override
    public void initView() {

//        Observable.
    }
}

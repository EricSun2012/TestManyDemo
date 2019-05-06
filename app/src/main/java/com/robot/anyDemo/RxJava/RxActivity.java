package com.robot.anyDemo.RxJava;

import android.widget.Toast;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;


public class RxActivity extends BaseActivity<RxPresenter> implements RxView {
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

        presenter.getUserInfo("15311320433");
    }

    @Override
    public void showUserInfo(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

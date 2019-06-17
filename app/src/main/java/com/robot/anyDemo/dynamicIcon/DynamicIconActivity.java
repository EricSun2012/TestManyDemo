package com.robot.anyDemo.dynamicIcon;

import android.widget.Button;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;
import com.robot.anyDemo.base.BasePresenter;

public class DynamicIconActivity extends BaseActivity<DynamicIconPresenter> {

    private Button defaultButton;
    private Button aliasButton;


    @Override
    protected DynamicIconPresenter createPresenter() {
        return new DynamicIconPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dynamic_icon;
    }

    @Override
    public void initView() {
        defaultButton = findViewById(R.id.btn_default);
        aliasButton = findViewById(R.id.btn_alias);

        defaultButton.setOnClickListener(v -> {
            presenter.changeDefaultIcon();
        });

        aliasButton.setOnClickListener(v->{
            presenter.changeIcon();
        });
    }

    @Override
    public void initData() {

    }


}

package com.robot.anyDemo.IPC_Binder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

/**
 * 项目名称：TestManyDemo
 * 类描述：
 * 创建人：Eric
 * 创建时间：2020-02-28 11:11
 * 修改人：Eric
 * 修改时间：2020-02-28 11:11
 * 修改备注：
 */
public class BinderActivity extends BaseActivity<BinderPresenter> implements BinderView {


    @Override
    protected BinderPresenter createPresenter() {
        return new BinderPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_binder;
    }

    @Override
    public void initView() {
        int pid = android.os.Process.myPid();
        System.out.println("Activity pid=" + pid);

        Button button = findViewById(R.id.btn_click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.requestBody("这个是一个");
            }
        });
    }

    @Override
    public void initData() {
        presenter.init();
    }


}

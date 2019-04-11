package com.robot.anyDemo.dataStructure;

import android.view.View;
import android.widget.Button;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

public class DataStructureActivity extends BaseActivity<DataPresenter> {

    private Button zerenlianButton;

    @Override
    protected DataPresenter createPresenter() {
        return new DataPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_data_structure;
    }

    @Override
    public void initView() {
        zerenlianButton = findViewById(R.id.structure_zerenlian);
        zerenlianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.postAddress("Chinabeijingfangshan");
            }
        });
    }

    @Override
    public void initData() {
        setTitle("数据结构");
    }
}

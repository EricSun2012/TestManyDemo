package com.robot.anyDemo.ThridDimensional;


import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

public class ThirdDimensionActivity extends BaseActivity<ThreeDimensionPresenter> {
    @Override
    protected ThreeDimensionPresenter createPresenter() {
        return new ThreeDimensionPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_three_dimension;
    }


    @Override
    public void initData() {
        setTitle("3D动画");
    }
}

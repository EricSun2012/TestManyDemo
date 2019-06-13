package com.robot.anyDemo.dataBinding;

import android.app.Activity;

import androidx.databinding.DataBindingUtil;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BasePresenter;
import com.robot.anyDemo.databinding.ActivityDatabindingBinding;

/**
 * 项目名称：TestManyDemo
 * 类描述：
 * 创建人：Eric
 * 创建时间：2019-06-13 17:27
 * 修改人：Eric
 * 修改时间：2019-06-13 17:27
 * 修改备注：
 */
public class DataBindingPresenter extends BasePresenter<DataBindingView> {

    private ActivityDatabindingBinding bind;

    public DataBindingPresenter(DataBindingView baseView) {
        super(baseView);

        bind = DataBindingUtil.bind(((Activity) baseView).findViewById(R.id.dataBindingRoot));
    }

    public void bindingData(ActionTag tag) {
        bind.setActionTag(tag);
    }


}

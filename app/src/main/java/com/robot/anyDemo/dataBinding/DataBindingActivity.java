package com.robot.anyDemo.dataBinding;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 项目名称：TestManyDemo
 * 类描述：
 * 创建人：Eric
 * 创建时间：2019-06-13 17:26
 * 修改人：Eric
 * 修改时间：2019-06-13 17:26
 * 修改备注：
 */
public class DataBindingActivity extends BaseActivity<DataBindingPresenter> implements DataBindingView {

    private ActionTag mTag;

    private Button titleButton;

    @Override
    protected DataBindingPresenter createPresenter() {
        return new DataBindingPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_databinding;
    }

    @Override
    public void initData() {
        mTag = new ActionTag();
        mTag.setTitle("123");
        presenter.bindingData(mTag);

        presenter.bindingClick(v -> {
            titleButton.setText("12345");
            Logger.getGlobal().log(Level.INFO, mTag.getTitle());
            Toast.makeText(v.getContext(), mTag.getTitle(), Toast.LENGTH_SHORT).show();
        });
    }


    @Override
    public void initView() {
        setTitle("DataBinding");
        titleButton = findViewById(R.id.btn_title);
    }
}

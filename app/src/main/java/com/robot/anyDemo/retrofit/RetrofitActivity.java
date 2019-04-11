package com.robot.anyDemo.retrofit;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

public class RetrofitActivity extends BaseActivity<RetrofitPresenter> implements RetrofitView {
    private EditText phoneNumberEdit;
    private TextView contentText;

    @Override
    protected RetrofitPresenter createPresenter() {
        return new RetrofitPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_retrofit;
    }

    @Override
    public void initView() {
        super.initView();

        contentText = findViewById(R.id.txt_content);
        phoneNumberEdit = findViewById(R.id.edit_phone);
        findViewById(R.id.btn_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phoneNumberEdit.getText().toString().trim();
                if (null == phone || phone.length() != 11) return;
                presenter.requestMobileInfo(phone);
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        setTitle("Retrofit");
    }

    @Override
    public void getMobileInfo(String mobile) {
        contentText.setText(mobile);
    }
}

package com.robot.anyDemo.mvp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

public class MvpActivity extends BaseActivity<MvpPresenter> implements MvpView {

    private TextView contentText;
    private ImageView picImageView;

    @Override
    protected MvpPresenter createPresenter() {
        return new MvpPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }


    @Override
    public void initView() {
        super.initView();
        contentText = findViewById(R.id.txt_content);
        picImageView = findViewById(R.id.img_pic);
        findViewById(R.id.btn_word).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestSomething();
            }
        });

        findViewById(R.id.btn_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestImage();
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        setTitle("MVP");
    }

    @Override
    public void getSomethingMessage(int code, String message) {
        contentText.setText(message);
    }

    @Override
    public void getSomePicture(int drawable) {
        picImageView.setImageDrawable(getResources().getDrawable(drawable));
    }
}

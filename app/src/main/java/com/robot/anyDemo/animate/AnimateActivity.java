package com.robot.anyDemo.animate;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;
import com.robot.anyDemo.base.BaseView;

public class AnimateActivity extends BaseActivity<AnimatePresenter> implements BaseView {

    private ImageView imageView;
    private Button rotationButton;
    private Button scaleButton;
    private Button valueButton;
    private Button translationButton;

    private Button bounceButton;

    private Button colorButton;

    private Button svgButton;

    @Override
    protected AnimatePresenter createPresenter() {
        return new AnimatePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animate;
    }

    @Override
    public void initView() {
        imageView = findViewById(R.id.animate_pic);

        rotationButton = findViewById(R.id.animate_rotation);
        rotationButton.setOnClickListener(v -> presenter.startRotationProperty(imageView));

        scaleButton = findViewById(R.id.animate_scale);
        scaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startScaleProperty(imageView);
            }
        });

        valueButton = findViewById(R.id.animate_value);
        valueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startValueProperty(imageView);
            }
        });

        translationButton = findViewById(R.id.animate_translation);
        translationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startTranslationProperty(imageView);
            }
        });

        bounceButton = findViewById(R.id.animate_bounce);
        bounceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startBounceProperty(imageView);
            }
        });

        colorButton = findViewById(R.id.animate_color);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startColorProperty(imageView);
            }
        });

        svgButton = findViewById(R.id.animate_svg);
        svgButton.setOnClickListener(v -> {
            presenter.startSvgAnimation(imageView);
        });

    }

    @Override
    public void initData() {
        setTitle("动画");

    }
}

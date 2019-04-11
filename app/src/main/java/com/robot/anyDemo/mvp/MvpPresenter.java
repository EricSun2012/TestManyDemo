package com.robot.anyDemo.mvp;


import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BasePresenter;

public class MvpPresenter extends BasePresenter<MvpView> {
    public MvpPresenter(MvpView baseView) {
        super(baseView);
    }

    public void requestSomething() {

        baseView.getSomethingMessage(200, "这个回调挺好使");
    }


    public void requestImage() {
        baseView.getSomePicture(R.drawable.circle);
    }
}

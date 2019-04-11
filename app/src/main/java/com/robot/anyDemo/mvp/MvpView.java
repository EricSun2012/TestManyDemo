package com.robot.anyDemo.mvp;

import com.robot.anyDemo.base.BaseView;

public interface MvpView extends BaseView {


    void getSomethingMessage(int code, String message);

    void getSomePicture(int drawableResource);
}

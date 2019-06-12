package com.robot.anyDemo.RefreshView;

import com.robot.anyDemo.base.BasePresenter;

public class RefreshPresenter extends BasePresenter<RefreshView> {
    public RefreshPresenter(RefreshView baseView) {
        super(baseView);
    }


    public void requestSomeData() {

        //do some async work
        baseView.getSomeData("");
    }
}

package com.robot.anyDemo.RxJava;

import com.robot.anyDemo.base.BaseObserver;
import com.robot.anyDemo.base.BasePresenter;
import com.robot.anyDemo.base.BaseView;
import com.robot.anyDemo.retrofit.ApiRetrofit;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RxPresenter extends BasePresenter<RxView> {
    public RxPresenter(RxView baseView) {
        super(baseView);
    }


    public void getUserInfo(String phone) {
        Observable observable = ApiRetrofit.getInstance().getApiService().getRxMobileInfo(phone);

        addDisposable(observable, new BaseObserver<String>(baseView) {
            @Override
            public void onSuccess(String o) {
                baseView.showUserInfo(o);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}

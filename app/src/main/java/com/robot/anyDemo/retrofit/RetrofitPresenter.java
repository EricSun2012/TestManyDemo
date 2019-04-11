package com.robot.anyDemo.retrofit;

import com.robot.anyDemo.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitPresenter extends BasePresenter<RetrofitView> {

    public RetrofitPresenter(RetrofitView baseView) {
        super(baseView);
    }


    public void requestMobileInfo(String phone) {
        Call call = ApiRetrofit.getInstance().getApiService().getMobileInfo(phone);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.code() == 200) {
                    baseView.getMobileInfo(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}

package com.robot.anyDemo.retrofit;

import com.robot.anyDemo.base.BaseModel;
import com.robot.anyDemo.base.BaseObserver;
import com.robot.anyDemo.base.BasePresenter;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitPresenter extends BasePresenter<RetrofitView> {

    public RetrofitPresenter(RetrofitView baseView) {
        super(baseView);
    }


    public void requestMobileInfo(String phone) {
        Observable<String> call = ApiRetrofit.getInstance().getApiService().getRxMobileInfo(phone);
        addDisposable(call, new BaseObserver<BaseModel>(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                if (o.getErrcode() == 200) {
                    baseView.getMobileInfo(o.getResult().toString());
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}

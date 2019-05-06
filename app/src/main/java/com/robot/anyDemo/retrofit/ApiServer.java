package com.robot.anyDemo.retrofit;


import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServer {

    @GET("getMobileInfo")
    Call<Object> getMobileInfo(@Query("mobile") String mobile);

    @FormUrlEncoded
    @POST("update")
    Call<Object> submitMobileInfo(@FieldMap HashMap<String, String> map);


    @GET("getMobileInfo")
    Observable<String> getRxMobileInfo(@Query("mobile") String mobile);
}

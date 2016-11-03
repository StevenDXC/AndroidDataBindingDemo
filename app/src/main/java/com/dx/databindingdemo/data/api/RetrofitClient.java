package com.dx.databindingdemo.data.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Miutrip_iMac on 2016/10/17.
 */

public class RetrofitClient {

    private static final String BASE_URL = "https://api.github.com/";

    private Retrofit mRetrofit;

    public RetrofitClient(){
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public APIService getAPIService(){
        return mRetrofit.create(APIService.class);
    }
}

package com.edu.stu.mvpdemo.util;

import android.content.Context;

import com.edu.stu.mvpdemo.service.RetrofitService;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dingyun on 2018/3/21.
 */

public class RetrofitHelper {
    private Context mCntext;
    OkHttpClient client = new OkHttpClient();
    GsonConverterFactory factory =
            GsonConverterFactory.create(new GsonBuilder().create());

    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitHelper(context);
        }

        return instance;
    }


    private RetrofitHelper(Context mContext) {
        mCntext = mContext;
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(client).addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();


    }

    public RetrofitService getServer() {
        return mRetrofit.create(RetrofitService.class);
    }
}
package com.cooksdev.facebookfeedandroid.data.api;

import com.cooksdev.facebookfeedandroid.data.dto.UserEntity;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;

import java.io.IOException;

import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by roma on 09.09.16.
 */
public class FacebookFeedApi {

    private static FacebookFeedApi instance;
    private RetrofitFacebookFeedRestApi retrofitFacebookFeedRestApi;

    private FacebookFeedApi() {
        retrofitFacebookFeedRestApi = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RetrofitFacebookFeedRestApi.class);
    }

    public static FacebookFeedApi getInstance() {
        if (instance == null)
            instance = new FacebookFeedApi();
        return instance;
    }

    public Observable<UserEntity> getUserInfo() {
        return retrofitFacebookFeedRestApi.getUserInfo(AccessToken.getCurrentAccessToken().getToken());
    }
}

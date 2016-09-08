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



        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header(Constants.ACCESS_TOKEN, AccessToken.getCurrentAccessToken().getToken())
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
        httpClient.addInterceptor(logging);

        retrofitFacebookFeedRestApi = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient.build())
                .build()
                .create(RetrofitFacebookFeedRestApi.class);
    }

    public static FacebookFeedApi getInstance() {
        if (instance == null)
            instance = new FacebookFeedApi();
        return instance;
    }

    public Observable<UserEntity> getUserInfo() {
        return retrofitFacebookFeedRestApi.getUserInfo();
    }
}

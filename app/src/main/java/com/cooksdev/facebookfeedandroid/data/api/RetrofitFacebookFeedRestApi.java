package com.cooksdev.facebookfeedandroid.data.api;

import com.cooksdev.facebookfeedandroid.data.dto.UserEntity;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by roma on 09.09.16.
 */
public interface RetrofitFacebookFeedRestApi {

    @GET(Urls.USER_INFO)
    Observable<UserEntity> getUserInfo(@Query("access_token") String accessToken);
}

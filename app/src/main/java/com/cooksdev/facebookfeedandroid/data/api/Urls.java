package com.cooksdev.facebookfeedandroid.data.api;

/**
 * Created by roma on 09.09.16.
 */
public class Urls {

    public static final String BASE_URL = "https://graph.facebook.com/v2.7/";

    public static final String USER_INFO = "me/?fields=picture,name";
    public static final String POSTS = "me/?fields=posts{permalink_url,full_picture,message,created_time}";

}

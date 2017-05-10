package com.cooksdev.facebookfeedandroid;

import android.app.Application;

import com.cooksdev.facebookfeedandroid.presentation.util.StringsUtil;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by roma on 08.09.16.
 */
public class FacebookFeedApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        StringsUtil.initialize(this);
    }
}

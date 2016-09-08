package com.cooksdev.facebookfeedandroid.app;

import android.app.Application;

import com.cooksdev.facebookfeedandroid.util.StringsUtil;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
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
        FacebookSdk.addLoggingBehavior(LoggingBehavior.REQUESTS);
    }
}

package com.cooksdev.facebookfeedandroid.presenter;

/**
 * Created by roma on 08.09.16.
 */
public interface IBasePresenter<T> {

    void setView(T t);

    void onCreate();

    void onResume();

    void onStart();

    void onStop();
}

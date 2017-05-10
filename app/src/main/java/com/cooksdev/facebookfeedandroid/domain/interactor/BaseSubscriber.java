package com.cooksdev.facebookfeedandroid.domain.interactor;

import rx.Subscriber;

/**
 * Created by roma on 8.09.16.
 */
public abstract class BaseSubscriber<T> extends Subscriber<T>{

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}

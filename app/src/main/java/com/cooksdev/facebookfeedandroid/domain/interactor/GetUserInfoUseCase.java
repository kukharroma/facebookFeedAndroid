package com.cooksdev.facebookfeedandroid.domain.interactor;

import com.cooksdev.facebookfeedandroid.data.repository.UserRepository;
import com.cooksdev.facebookfeedandroid.data.model.User;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;

/**
 * Created by roma on 08.09.16.
 */
public class GetUserInfoUseCase {

    private UserRepository repository = new UserRepository();
    private Subscription subscription = Subscribers.empty();


    public void execute(Subscriber<User> subscriber) {
        subscription = repository.getUserInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void unSubscribe() {
        if (!subscription.isUnsubscribed())
            subscription.unsubscribe();
    }


}

package com.cooksdev.facebookfeedandroid.interactor;

import com.cooksdev.facebookfeedandroid.data.repository.UserRepository;
import com.cooksdev.facebookfeedandroid.model.Posts;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by roma on 08.09.16.
 */
public class GetUserPostsUseCase {

    private UserRepository userRepository = new UserRepository();
    private Subscription subscription = Subscriptions.empty();

    public void execute(Subscriber<Posts> subscriber){
        subscription = userRepository.getUserPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void unSubscribe(){
        if (!subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}

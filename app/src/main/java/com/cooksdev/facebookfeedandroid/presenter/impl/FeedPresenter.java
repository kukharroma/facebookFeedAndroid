package com.cooksdev.facebookfeedandroid.presenter.impl;

import com.cooksdev.facebookfeedandroid.interactor.BaseSubscriber;
import com.cooksdev.facebookfeedandroid.interactor.GetUserPostsUseCase;
import com.cooksdev.facebookfeedandroid.model.Post;
import com.cooksdev.facebookfeedandroid.model.Posts;
import com.cooksdev.facebookfeedandroid.presenter.IFeedPresenter;
import com.cooksdev.facebookfeedandroid.ui.view.IFeedView;

/**
 * Created by roma on 08.09.16.
 */
public class FeedPresenter implements IFeedPresenter {

    private IFeedView view;
    private GetUserPostsUseCase useCase = new GetUserPostsUseCase();

    @Override
    public void setView(IFeedView view) {
        this.view = view;
    }

    @Override
    public void getPosts() {
        useCase.execute(new GetPostsSubscriber());
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }


    @Override
    public void onStop() {
        useCase.unSubscribe();
    }

    class GetPostsSubscriber extends BaseSubscriber<Posts> {
        @Override
        public void onCompleted() {
            view.showMessage("onCompleted()");
        }

        @Override
        public void onError(Throwable e) {
            view.showMessage(e.getMessage());
        }

        @Override
        public void onNext(Posts posts) {
            view.showPosts(posts);
        }
    }

}

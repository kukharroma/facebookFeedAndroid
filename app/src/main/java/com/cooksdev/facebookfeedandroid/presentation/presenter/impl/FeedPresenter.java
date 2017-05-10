package com.cooksdev.facebookfeedandroid.presentation.presenter.impl;

import com.cooksdev.facebookfeedandroid.domain.interactor.BaseSubscriber;
import com.cooksdev.facebookfeedandroid.domain.interactor.GetUserPostsUseCase;
import com.cooksdev.facebookfeedandroid.data.model.Posts;
import com.cooksdev.facebookfeedandroid.presentation.presenter.IFeedPresenter;
import com.cooksdev.facebookfeedandroid.presentation.ui.view.IFeedView;

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
    public void onStart() {
        getPosts();
    }

    @Override
    public void onStop() {
        useCase.unSubscribe();
    }

    @Override
    public void onDestroy() {

    }

    class GetPostsSubscriber extends BaseSubscriber<Posts> {

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

package com.cooksdev.facebookfeedandroid.presenter.impl;

import com.cooksdev.facebookfeedandroid.presenter.IFeedPresenter;
import com.cooksdev.facebookfeedandroid.ui.view.IFeedView;

/**
 * Created by roma on 08.09.16.
 */
public class FeedPresenter implements IFeedPresenter {

    private IFeedView view;

    @Override
    public void setView(IFeedView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}

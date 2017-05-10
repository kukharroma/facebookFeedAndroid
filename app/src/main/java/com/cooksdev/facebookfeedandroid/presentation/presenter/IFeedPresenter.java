package com.cooksdev.facebookfeedandroid.presentation.presenter;

import com.cooksdev.facebookfeedandroid.presentation.ui.view.IFeedView;

/**
 * Created by roma on 08.09.16.
 */
public interface IFeedPresenter extends IBasePresenter<IFeedView>{

    void getPosts();
}

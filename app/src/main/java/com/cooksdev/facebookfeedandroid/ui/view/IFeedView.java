package com.cooksdev.facebookfeedandroid.ui.view;

import com.cooksdev.facebookfeedandroid.model.Posts;

/**
 * Created by roma on 08.09.16.
 */
public interface IFeedView extends IBaseView {

    void initPostsAdapter();

    void showPosts(Posts posts);
}

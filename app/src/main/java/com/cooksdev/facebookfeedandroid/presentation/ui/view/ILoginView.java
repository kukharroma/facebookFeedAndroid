package com.cooksdev.facebookfeedandroid.presentation.ui.view;

import com.cooksdev.facebookfeedandroid.data.model.User;

/**
 * Created by roma on 08.09.16.
 */
public interface ILoginView extends IBaseView {

    void showUserInfo(User user);

    void hideUserInfo();

    void showPosts();


}

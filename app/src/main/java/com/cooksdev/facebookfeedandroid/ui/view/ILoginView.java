package com.cooksdev.facebookfeedandroid.ui.view;

import com.cooksdev.facebookfeedandroid.model.User;

/**
 * Created by roma on 08.09.16.
 */
public interface ILoginView extends IBaseView {

    void showUserInfo(User user);

    void hideUserInfo();


}

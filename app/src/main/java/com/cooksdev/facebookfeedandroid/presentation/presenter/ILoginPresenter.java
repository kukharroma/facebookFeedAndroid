package com.cooksdev.facebookfeedandroid.presentation.presenter;

import android.content.Intent;

import com.cooksdev.facebookfeedandroid.presentation.ui.view.ILoginView;
import com.facebook.login.widget.LoginButton;

/**
 * Created by roma on 08.09.16.
 */
public interface ILoginPresenter extends IBasePresenter<ILoginView>{

    void registerFbLoginButtonCallback(LoginButton loginButton);

    void onActivityResult(int requestCode, int resultCode, Intent data);
}

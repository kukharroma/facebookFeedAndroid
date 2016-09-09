package com.cooksdev.facebookfeedandroid.presenter.impl;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.util.Log;

import com.cooksdev.facebookfeedandroid.R;
import com.cooksdev.facebookfeedandroid.interactor.BaseSubscriber;
import com.cooksdev.facebookfeedandroid.interactor.GetUserInfoUseCase;
import com.cooksdev.facebookfeedandroid.model.User;
import com.cooksdev.facebookfeedandroid.presenter.ILoginPresenter;
import com.cooksdev.facebookfeedandroid.ui.view.ILoginView;
import com.cooksdev.facebookfeedandroid.util.StringsUtil;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by roma on 08.09.16.
 */
public class LoginPresenter implements ILoginPresenter {

    private ILoginView view;
    private CallbackManager fbCallbackManager;
    private FbFeedFacebookCallback fbFeedFacebookCallback;
    private GetUserInfoUseCase useCase;


    @Override
    public void setView(ILoginView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        fbCallbackManager = CallbackManager.Factory.create();
        fbFeedFacebookCallback = new FbFeedFacebookCallback();
        useCase = new GetUserInfoUseCase();

    }

    @Override
    public void onStart() {
        if (AccessToken.getCurrentAccessToken() != null)
            useCase.execute(new UserInfoSubscriber());
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void registerFbLoginButtonCallback(LoginButton loginButton) {
        loginButton.registerCallback(fbCallbackManager, fbFeedFacebookCallback);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        fbCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    class UserInfoSubscriber extends BaseSubscriber<User> {

        @Override
        public void onError(Throwable e) {
            view.showMessage(e.getMessage());
        }

        @Override
        public void onNext(User user) {
            view.showUserInfo(user);
        }
    }

    class FbFeedFacebookCallback implements FacebookCallback<LoginResult> {
        @Override
        public void onSuccess(LoginResult loginResult) {
            useCase.execute(new UserInfoSubscriber());
        }

        @Override
        public void onCancel() {
            view.showMessage(StringsUtil.getString(R.string.message_user_canceled_login));
        }

        @Override
        public void onError(FacebookException error) {
            view.showMessage(error.getMessage());
        }
    }


}

package com.cooksdev.facebookfeedandroid.presentation.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cooksdev.facebookfeedandroid.R;
import com.cooksdev.facebookfeedandroid.data.model.User;
import com.cooksdev.facebookfeedandroid.presentation.presenter.ILoginPresenter;
import com.cooksdev.facebookfeedandroid.presentation.presenter.impl.LoginPresenter;
import com.cooksdev.facebookfeedandroid.presentation.ui.activities.MainActivity;
import com.cooksdev.facebookfeedandroid.presentation.ui.view.ILoginView;
import com.facebook.AccessTokenTracker;
import com.facebook.login.widget.LoginButton;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by roma on 08.09.16.
 */
public class LoginFragment extends BaseFragment implements ILoginView {

    public static final String TAG = LoginFragment.class.getSimpleName();

    private ILoginPresenter presenter;
    private AccessTokenTracker accessTokenTracker;

    private LoginButton btFbLogin;
    private Button btPosts;
    private RoundedImageView ivProfile;
    private TextView tvUsername;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter();
        presenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initComponents(view);
        return view;
    }

    @Override
    public void initComponents(View view) {
        btFbLogin = (LoginButton) view.findViewById(R.id.bt_fb_login);
        btFbLogin.setReadPermissions(getResources().getString(R.string.fb_permissions));
        btFbLogin.setFragment(this);
        tvUsername = (TextView) view.findViewById(R.id.tv_username);
        ivProfile = (RoundedImageView) view.findViewById(R.id.iv_photo_profile);
        btPosts = (Button) view.findViewById(R.id.bt_show_posts);
        presenter.registerFbLoginButtonCallback(btFbLogin);
        btPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPosts();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void showUserInfo(User user) {
        tvUsername.setText(user.getUsername());
        btPosts.setVisibility(View.VISIBLE);
        Glide.with(this)
                .load(user.getProfileImageUrl())
                .fitCenter()
                .crossFade()
                .into(ivProfile);
    }

    @Override
    public void hideUserInfo() {
        ivProfile.setImageDrawable(null);
        tvUsername.setText(getString(R.string.empty));
        btPosts.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showPosts() {
        ((MainActivity) getActivity()).showFeedFragment();
    }
}

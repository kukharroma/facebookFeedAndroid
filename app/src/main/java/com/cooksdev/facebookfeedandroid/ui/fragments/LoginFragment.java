package com.cooksdev.facebookfeedandroid.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cooksdev.facebookfeedandroid.R;
import com.cooksdev.facebookfeedandroid.model.User;
import com.cooksdev.facebookfeedandroid.presenter.ILoginPresenter;
import com.cooksdev.facebookfeedandroid.presenter.impl.LoginPresenter;
import com.cooksdev.facebookfeedandroid.ui.activities.MainActivity;
import com.cooksdev.facebookfeedandroid.ui.view.ILoginView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.makeramen.roundedimageview.RoundedImageView;

import org.w3c.dom.Text;

/**
 * Created by roma on 08.09.16.
 */
public class LoginFragment extends BaseFragment implements ILoginView {

    private LoginButton btFbLogin;
    private Button btPosts;
    private RoundedImageView ivProfile;
    private TextView tvUsername;

    private AccessTokenTracker accessTokenTracker;

    private ILoginPresenter presenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter();
        presenter.setView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
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
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if (currentAccessToken == null)
                    hideUserInfo();
            }
        };
        accessTokenTracker.startTracking();
        btPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPosts();
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
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
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        if (target.getRequest().isFailed()) {
                            target.getRequest().begin();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
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

package com.cooksdev.facebookfeedandroid.ui.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cooksdev.facebookfeedandroid.R;
import com.cooksdev.facebookfeedandroid.ui.fragments.FeedFragment;
import com.cooksdev.facebookfeedandroid.ui.fragments.LoginFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLoginFragment();
    }

    public void showLoginFragment(){
        getSupportFragmentManager().beginTransaction().
                add(R.id.container, LoginFragment.newInstance(), LoginFragment.TAG).commit();
    }

    public void showFeedFragment(){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.container, FeedFragment.newInstance(), FeedFragment.TAG).addToBackStack(FeedFragment.TAG).commit();
    }
}

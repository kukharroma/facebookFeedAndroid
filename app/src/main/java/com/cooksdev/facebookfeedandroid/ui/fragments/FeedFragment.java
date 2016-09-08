package com.cooksdev.facebookfeedandroid.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cooksdev.facebookfeedandroid.R;

/**
 * Created by roma on 08.09.16.
 */
public class FeedFragment  extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        initComponents(view);
        return view;
    }

    @Override
    public void initComponents(View view) {

    }
}

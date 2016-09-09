package com.cooksdev.facebookfeedandroid.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cooksdev.facebookfeedandroid.R;
import com.cooksdev.facebookfeedandroid.model.Posts;
import com.cooksdev.facebookfeedandroid.presenter.IBasePresenter;
import com.cooksdev.facebookfeedandroid.presenter.IFeedPresenter;
import com.cooksdev.facebookfeedandroid.ui.adapter.PostsAdapter;
import com.cooksdev.facebookfeedandroid.ui.view.IFeedView;

/**
 * Created by roma on 08.09.16.
 */
public class FeedFragment  extends BaseFragment implements IFeedView{

    private RecyclerView rvPosts;
    private PostsAdapter postsAdapter;

    private IFeedPresenter presenter;

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        initComponents(view);
        return view;
    }

    @Override
    public void initComponents(View view) {
        rvPosts = (RecyclerView) view.findViewById(R.id.rv_posts);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void initPostsAdapter() {

    }

    @Override
    public void showPosts(Posts posts) {

    }
}

package com.cooksdev.facebookfeedandroid.presentation.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cooksdev.facebookfeedandroid.R;
import com.cooksdev.facebookfeedandroid.data.model.Posts;
import com.cooksdev.facebookfeedandroid.presentation.presenter.IFeedPresenter;
import com.cooksdev.facebookfeedandroid.presentation.presenter.impl.FeedPresenter;
import com.cooksdev.facebookfeedandroid.presentation.ui.adapter.PostsAdapter;
import com.cooksdev.facebookfeedandroid.presentation.ui.view.IFeedView;

/**
 * Created by roma on 08.09.16.
 */
public class FeedFragment extends BaseFragment implements IFeedView, PostsAdapter.OnPermalinkClickListener {

    public static final String TAG = FeedFragment.class.getSimpleName();

    private IFeedPresenter presenter;

    private RecyclerView rvPosts;
    private PostsAdapter postsAdapter;

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new FeedPresenter();
        presenter.setView(this);
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
        initPostsAdapter();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getPosts();
    }

    @Override
    public void initPostsAdapter() {
        postsAdapter = new PostsAdapter(getContext(), this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        rvPosts.setLayoutManager(lm);
        rvPosts.setAdapter(postsAdapter);
    }

    @Override
    public void showPosts(Posts posts) {
        postsAdapter.updatePosts(posts);
    }

    @Override
    public void onPhotoClick(String permalinkUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(permalinkUrl));
        startActivity(intent);
    }

}

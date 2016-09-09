package com.cooksdev.facebookfeedandroid.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by roma on 09.09.16.
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {



    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PostAdapter.PostViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        public PostViewHolder(View itemView) {
            super(itemView);
        }




    }
}

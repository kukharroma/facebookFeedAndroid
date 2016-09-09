package com.cooksdev.facebookfeedandroid.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cooksdev.facebookfeedandroid.R;
import com.cooksdev.facebookfeedandroid.model.Post;
import com.cooksdev.facebookfeedandroid.model.Posts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 09.09.16.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private Context context;
    private OnPermalinkClickListener permalinkClickListener;
    private List<Post> posts = new ArrayList<>();

    public PostsAdapter(Context context, OnPermalinkClickListener permalinkClickListener) {
        this.context = context;
        this.permalinkClickListener = permalinkClickListener;
    }

    public void updatePosts(Posts posts) {
        this.posts = posts.getPosts();
        this.notifyDataSetChanged();
    }

    @Override
    public PostsAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post_item, parent, false);
        PostViewHolder postVH = new PostViewHolder(view);
        return postVH;
    }

    @Override
    public void onBindViewHolder(PostsAdapter.PostViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.tvCreated.setText(post.getCreated());
        holder.tvMessage.setText(post.getMessage());
        holder.loadPhoto(post.getPictureUrl());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public interface OnPermalinkClickListener {
        void onPhotoClick(String permalinkUrl);
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tvCreated;
        TextView tvMessage;
        ImageView ivPicture;

        public PostViewHolder(View view) {
            super(view);

            tvCreated = (TextView) view.findViewById(R.id.tv_created);
            tvMessage = (TextView) view.findViewById(R.id.tv_message);
            ivPicture = (ImageView) view.findViewById(R.id.iv_picture);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String permalinkUrl = posts.get(getAdapterPosition()).getPermalinkUrl();
                    permalinkClickListener.onPhotoClick(permalinkUrl);
                }
            });
        }

        public void loadPhoto(String imageUrl) {
            Glide.with(context)
                    .load(imageUrl)
                    .centerCrop()
                    .into(ivPicture);
        }

    }
}

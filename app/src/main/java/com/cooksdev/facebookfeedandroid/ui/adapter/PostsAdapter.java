package com.cooksdev.facebookfeedandroid.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cooksdev.facebookfeedandroid.R;
import com.cooksdev.facebookfeedandroid.model.Post;
import com.cooksdev.facebookfeedandroid.model.Posts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 09.09.16.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    public PostsAdapter(Context context) {
        this.context = context;
    }

    private Context context;
    private List<Post> posts = new ArrayList<>();

    public void updatePosts(Posts posts) {
        this.posts = posts.getPosts();
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

    public interface OnPermanentLinkClickListener {
        void onPhotoClick(String permanentUrl);
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
        }

        public void loadPhoto(String imageUrl) {
            Glide.with(context)
                    .load(imageUrl)
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
                    .into(ivPicture);
        }

    }
}

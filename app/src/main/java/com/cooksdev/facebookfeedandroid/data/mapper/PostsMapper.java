package com.cooksdev.facebookfeedandroid.data.mapper;

import com.cooksdev.facebookfeedandroid.data.dto.posts.PostEntity;
import com.cooksdev.facebookfeedandroid.data.dto.posts.PostsEntity;
import com.cooksdev.facebookfeedandroid.data.model.Post;
import com.cooksdev.facebookfeedandroid.data.model.Posts;
import com.cooksdev.facebookfeedandroid.presentation.util.DateFormatter;

/**
 * Created by roma on 09.09.16.
 */
public class PostsMapper {

    public static Posts transfer(PostsEntity postsEntity) {
        Posts posts = new Posts();
        posts.setNext(postsEntity.getPosts().getPagingEntity().getNext());
        posts.setPrevious(postsEntity.getPosts().getPagingEntity().getPrevious());
        for (PostEntity postEntity : postsEntity.getPosts().getData()) {
            posts.getPosts().add(transfer(postEntity));
        }

        return posts;
    }

    public static Post transfer(PostEntity postEntity) {
        Post post = new Post();
        post.setMessage(postEntity.getMessage());
        post.setPermalinkUrl(postEntity.getPermalinkUrl());
        post.setPictureUrl(postEntity.getFullPicture());
        post.setCreated(DateFormatter.convertDate(postEntity.getCreatedTime()));

        return post;
    }
}

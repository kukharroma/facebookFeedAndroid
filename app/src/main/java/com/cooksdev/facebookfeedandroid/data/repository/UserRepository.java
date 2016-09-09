package com.cooksdev.facebookfeedandroid.data.repository;

import com.cooksdev.facebookfeedandroid.data.api.FacebookFeedApi;
import com.cooksdev.facebookfeedandroid.data.dto.posts.PostsEntity;
import com.cooksdev.facebookfeedandroid.data.dto.user.UserEntity;
import com.cooksdev.facebookfeedandroid.data.mapper.UserMapper;
import com.cooksdev.facebookfeedandroid.model.Post;
import com.cooksdev.facebookfeedandroid.model.User;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by roma on 08.09.16.
 */
public class UserRepository {

    public Observable<User> getUserInfo() {
        return FacebookFeedApi.getInstance().getUserInfo().map(new Func1<UserEntity, User>() {
            @Override
            public User call(UserEntity userEntity) {
                return UserMapper.transfer(userEntity);
            }
        });
    }

    public Observable<Post> getUserPosts(){
        return FacebookFeedApi.getInstance().getUserPosts().map(new Func1<PostsEntity, Post>() {
            @Override
            public Post call(PostsEntity postsEntity) {
                return null;
            }
        });
    }
}

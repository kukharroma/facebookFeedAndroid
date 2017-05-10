package com.cooksdev.facebookfeedandroid.data.repository;

import com.cooksdev.facebookfeedandroid.data.api.FacebookFeedApi;
import com.cooksdev.facebookfeedandroid.data.dto.posts.PostsEntity;
import com.cooksdev.facebookfeedandroid.data.dto.user.UserEntity;
import com.cooksdev.facebookfeedandroid.data.mapper.PostsMapper;
import com.cooksdev.facebookfeedandroid.data.mapper.UserMapper;
import com.cooksdev.facebookfeedandroid.data.model.Posts;
import com.cooksdev.facebookfeedandroid.data.model.User;

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

    public Observable<Posts> getUserPosts() {
        return FacebookFeedApi.getInstance().getUserPosts().map(new Func1<PostsEntity, Posts>() {
            @Override
            public Posts call(PostsEntity postsEntity) {
                return PostsMapper.transfer(postsEntity);
            }
        });
    }
}

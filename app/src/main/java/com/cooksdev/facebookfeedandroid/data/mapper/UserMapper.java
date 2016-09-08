package com.cooksdev.facebookfeedandroid.data.mapper;

import com.cooksdev.facebookfeedandroid.data.dto.UserEntity;
import com.cooksdev.facebookfeedandroid.model.User;

/**
 * Created by roma on 09.09.16.
 */
public class UserMapper {

    public static User transfer(UserEntity userEntity){
        User user = new User();
        user.setUsername(userEntity.getName());
        user.setProfileImageUrl(userEntity.getPictureEntity().getPictureInfoEntity().getUrl());

        return user;
    }
}

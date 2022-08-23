package com.developer.community.fixture;

import com.developer.community.model.entity.UserEntity;

// 테스트용(가상의) UserEntity
public class UserEntityFixture {

    public static UserEntity get(String userName, String password, Integer userId) {
        UserEntity entity = new UserEntity();
        entity.setId(userId);
        entity.setUserName(userName);
        entity.setPassword(password);
        return entity;
    }
}

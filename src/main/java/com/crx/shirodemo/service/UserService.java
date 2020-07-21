package com.crx.shirodemo.service;

import com.crx.shirodemo.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectList();

    User findByName(String name);
}

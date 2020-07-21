package com.crx.shirodemo.service.imp;

import com.crx.shirodemo.entity.User;
import com.crx.shirodemo.mapper.UserMapper;
import com.crx.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectList() {
        return userMapper.selectList();
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByUserName(name);
    }


}

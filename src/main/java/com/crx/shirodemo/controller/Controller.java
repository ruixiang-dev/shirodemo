package com.crx.shirodemo.controller;

import com.crx.shirodemo.entity.User;
import com.crx.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    UserService userService;
    @GetMapping("list")
    public List<User> getList(){
        return userService.selectList();
    }
}

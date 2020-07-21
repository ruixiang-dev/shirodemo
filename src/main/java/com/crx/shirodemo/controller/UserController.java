package com.crx.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/{url}")
    public String redict(@PathVariable("url") String url){
        return url;
    }
    @PostMapping("login")
    public String login(String name,String psw){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,psw);
        try {
            subject.login(token);
            return "index";
            //用户名若不存在 发生用户名未知异常\
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            //非法密码异常
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return "login";
        }
    }
}

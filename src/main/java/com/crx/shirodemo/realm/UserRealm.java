package com.crx.shirodemo.realm;

import com.crx.shirodemo.entity.User;
import com.crx.shirodemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * 认证规则 ：anon  无需认证
 *            authc 必须认证
 *            authcBase 需要通过HttpBasic才可以
 *            user 不一定通过认证 曾经被shiro记住即可 比如记住我
 *
 * 授权    perms 必须拥有某一个权限才可以访问
 *         role  必须角色访问
 *         port  请求的端口必须是指定的值
 *         rest  请求基于rest  POST PUT GET DELETE
 *         ssl   安全url请求
 */
@Slf4j
public class UserRealm  extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Override  //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override  //认证 登录
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user =userService.findByName(token.getUsername());
        log.info("======================================"+user.toString());
        if (!Objects.isNull(user)){
            //进行密码的验证
            return new SimpleAuthenticationInfo(user,user.getPsw(),getName());
        }
        return null;
    }
}

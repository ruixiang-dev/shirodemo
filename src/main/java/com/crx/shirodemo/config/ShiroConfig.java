package com.crx.shirodemo.config;

import com.crx.shirodemo.realm.UserRealm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean (@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager );
        //权限设置
        Map<String,String> map = new HashMap<>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administrator","roles[administrator]");
        factoryBean.setFilterChainDefinitionMap(map);
        //设置登录页面
        factoryBean.setLoginUrl("login");
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return  manager;
    }
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}

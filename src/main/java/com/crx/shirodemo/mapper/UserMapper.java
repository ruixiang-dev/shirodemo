package com.crx.shirodemo.mapper;

import com.crx.shirodemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectList();

    User findByUserName(@Param("name") String name);

}
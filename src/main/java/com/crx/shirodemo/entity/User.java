package com.crx.shirodemo.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String name;

    private String psw;

    private String role;

    private String power;

}
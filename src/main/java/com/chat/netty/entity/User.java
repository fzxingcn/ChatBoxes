package com.chat.netty.entity;

import lombok.Data;

@Data
public class User {

    String id;

    private String table;

    private String  message;

    private String name;

    private String pwd;
}

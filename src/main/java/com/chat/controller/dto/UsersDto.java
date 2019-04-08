package com.chat.controller.dto;

import lombok.Data;

@Data
public class UsersDto {

    /**用户id**/
    private String userId;
    /**用户姓名**/
    private String userName;
    /**用户年龄**/
    private String userAge;
    /**用户性别**/
    private String userSex;
    /**用户密码**/
    private String userPassword;
    /**用户等级 0:普通用户 1：一级管理员 2：二级管理员**/
    private String userGrade;

    private String table;

    private String message;

}

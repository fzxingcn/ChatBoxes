package com.chat.controller.dto;

import lombok.Data;

@Data
public class UsersDto {

    /**用户id**/
    private String userId;
    /**用户姓名**/
    private String userName;

    private String table;

    private String message;

}

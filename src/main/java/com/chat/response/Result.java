package com.chat.response;

import lombok.Data;

@Data
public class Result<T> {

    /***返回编码**/
    private String code;
    /**返回内容**/
    private String message;

    private T date;
}

package com.chat.entity;

import lombok.Data;

/**
 * 聊天室的实体
 * @author fzxing
 */
@Data
public class BoxesBean {

    /**聊天室ID**/
    public String boxeId;

    /**聊天室名称**/
    public String boxeName;

    /**聊天室编码**/
    public String boxeCode;

    /**聊天室人数最大值**/
    public String boxePeopleSize;

    /**聊天室创建时间**/
    public String createDate;

    /**聊天室创人id**/
    public String createUserId;

    /**聊天室创人名称**/
    public String createUserName;
}

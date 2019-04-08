package com.chat.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.Objects;

/**
 * 用户消息实体类
 */
@Data
public class MageBena {


    private static ObjectMapper gson = new ObjectMapper();
    /*private static Gson gson = new Gson();*/
 
    /**
     * 那个聊天室
     */
    private String table;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 所发送的消息
     */
    private String message;

    /**
     * 发送时间
     */
    private String sendDate;
 
    /**
     * 将json字符串转成Mage
     * @param message
     * @return
     * @throws Exception
     */
    public static MageBena strJson2Mage(String message) throws Exception{
        return Objects.isNull(message) ? null : gson.readValue(message, MageBena.class);
    }
 
    /**
     * 将Mage转成json字符串
     * @return
     * @throws Exception
     */
    public String toJson() throws Exception{
        return gson.writeValueAsString(this);
    }
 
    public MageBena setTableId(String table) {
        this.setTable(table);
        return this;
    }
}

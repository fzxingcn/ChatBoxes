package com.chat.dao;

import com.chat.entity.UsersBean;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UsersDao {

     /**
      * 添加一个用户对象
      * @param users
      */
     void saveUser(UsersBean users);

     /**
      * 根据指定的id 所对应的值进行查询，返回单个对象
      * @param id
      * @param value
      * @return
      */
     UsersBean findUserByName(String id,String value);

     /**
      * 根据指定id删除对应的列
      * @param id
      * @param value
      */
     void removeUser(String id,String value);

     /**
      * 根据指定的id修改 指定的字段
      * @param id
      * @param key
      * @param value
      */
     void updateUser(String id, String key, String value);

     /**
      * 根据指定的参数查询多条记录
      * @param key
      * @param value
      * @return
      */
     List<UsersBean> listUser(String key,String value);
}

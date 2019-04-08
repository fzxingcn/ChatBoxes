package com.chat.service;

import com.chat.controller.dto.UsersDto;
import com.chat.entity.UsersBean;
import com.chat.response.Result;

import java.util.List;

public interface UsersService {

    Result<UsersDto> login(UsersBean usersBean);

    /**
     * 增加一个用户
     * @param usersBean
     * @return
     */
     Result addUser(UsersBean usersBean);

    /**
     * 根据自定义id查询用户
     * @param id
     * @return
     */
    Result<UsersBean> findById(String id);

    /**
     * 根据条件查询所有的用户
     * @param usersBean
     * @return
     */
    Result<List<UsersBean>> findList(UsersBean usersBean);

    /**
     * 根据id删除指定的数据
     * @param id
     * @return
     */
    Result deleteById(String id);
}

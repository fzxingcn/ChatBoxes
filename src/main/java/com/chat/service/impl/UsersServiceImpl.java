package com.chat.service.impl;

import com.chat.controller.dto.UsersDto;
import com.chat.dao.UsersDao;
import com.chat.entity.UsersBean;
import com.chat.response.Result;
import com.chat.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public Result<UsersDto> login(UsersBean usersBean) {
        Result result=new Result();
        if(usersBean.getUserName() == null || usersBean.getUserPassword() == null){
            result.setCode("409");
            result.setMessage("必须的数据不能为空!");
            return result;
        }

        UsersBean users= usersDao.findUserByName("userName",usersBean.getUserName());
        if(users == null || users.getUserName() == null){
            result.setCode("401");
            result.setMessage("账号或密码错误!");
            return result;
        }
        if(!usersBean.getUserPassword().equals(users.getUserPassword())){
            result.setCode("401");
            result.setMessage("账号或密码错误!");
            return result;
        }
        result.setCode("200");
        result.setMessage("登录成功!");
        UsersDto usersDto=new UsersDto();
        usersDto.setUserId(users.getUserId());
        usersDto.setUserName(users.getUserName());
        result.setDate(usersDto);
        return result;
    }

    @Override
    public Result addUser(UsersBean usersBean) {
        Result result;

        //数据校验
        result = verifyData(usersBean);
       if(!"200".equals(result.getCode())){
           return result;
       }
        usersBean.setUserGrade("0");
        usersBean.setUserAge("18");
        usersBean.setUserSex("男");
        usersBean.setUserId(UUID.randomUUID().toString());
        usersDao.saveUser(usersBean);
        result.setMessage("添加成功!");
        return result;
    }

    @Override
    public Result<UsersBean> findById(String id) {
        return null;
    }

    @Override
    public Result<List<UsersBean>> findList(UsersBean usersBean) {
        return null;
    }

    @Override
    public Result deleteById(String id) {
        return null;
    }

    /**
     * 校验数据方法
     * @param usersBean
     * @return
     */
    public Result verifyData(UsersBean usersBean){
        Result result=new Result();
        if(usersBean.getUserName() == null || "".equals(usersBean.getUserName())){
            result.setCode("500");
            result.setMessage("用户名不能为空!");
            return result;
        }
        if(usersBean.getUserPassword() == null || "".equals(usersBean.getUserPassword())){
            result.setCode("500");
            result.setMessage("密码不能为空!");
            return result;
        }
        UsersBean users= usersDao.findUserByName("userName",usersBean.getUserName());
        if( null != users && null != users.getUserName()){
            result.setCode("405");
            result.setMessage("账号已存在!");
            return result;
        }
        result.setCode("200");
        return  result;
    }
}

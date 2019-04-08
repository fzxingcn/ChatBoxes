package com.chat.controller;

import com.chat.controller.dto.UsersDto;
import com.chat.entity.UsersBean;
import com.chat.response.Result;
import com.chat.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Fzx
 */


@Controller
@RequestMapping("test")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("login")
    public String  getIndex(HashMap<String, Object> map,UsersBean user){
        Result result=usersService.login(user);
        map.put("user",result.getDate());
        return "index";
    }

    @ResponseBody
    @RequestMapping("register")
    public Result register(UsersBean usersBean){
        return usersService.addUser(usersBean);
    }


}

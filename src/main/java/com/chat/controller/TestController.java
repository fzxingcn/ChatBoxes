package com.chat.controller;

import com.chat.netty.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * Fzx
 */


@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("index")
    public String  getIndex(HashMap<String, Object> map,String id,String name){
        User user=new User();
        user.setName(name);
        user.setId(id);
        map.put("user",user);
        return "index";
    }
}

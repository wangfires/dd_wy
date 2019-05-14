package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("add")
    public void add(User user){
        userService.regist(user);
    }
    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(String username,String password){
        Map<String, Object> map = userService.login(username, password);
        return map;
    }
}

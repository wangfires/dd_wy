package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.Map;

public interface UserService {
    public void regist(User user);
    Map<String,Object> login(String username, String password);
}

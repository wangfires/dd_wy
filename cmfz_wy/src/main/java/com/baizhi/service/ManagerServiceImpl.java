package com.baizhi.service;

import com.baizhi.dao.ManagerMapper;
import com.baizhi.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String,Object> map=new HashMap<String, Object>();
        Manager manager = new Manager();
        manager.setUsername(username);
        Manager loginmanager = managerMapper.selectOne(manager);
        if(loginmanager==null){
            String nerror="用户名不存在！！";
            map.put("nerror",nerror);
        }else {
            if (!password.equals(loginmanager.getPassword())){
                String perror="密码不正确！！";
                map.put("perror",perror);
            }else {
                map.put("login",loginmanager);
            }
        }
        return map;
    }
}

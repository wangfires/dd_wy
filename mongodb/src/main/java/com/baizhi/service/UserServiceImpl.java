package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void regist(User user) {
        userDao.insert(user);
    }

    @Override
    public Map<String,Object> login(String username, String password) {
        Map<String,Object> map=new HashMap<String, Object>();
        Query query = Query.query(Criteria.where("username").is("zs"));
        List<User> user = mongoTemplate.find(query, User.class);
        System.out.println(user.get(0));
        if(user==null){
            String nerror="用户名不存在！！";
            map.put("nerror",nerror);
        }else {
            if (!password.equals(user.get(0).getPassword())){
                String perror="密码不正确！！";
                map.put("perror",perror);
            }else {
                map.put("login",user);
            }
        }
        return map;

    }
}

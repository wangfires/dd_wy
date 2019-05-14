package com.baizhi;

import com.baizhi.dao.EmpDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Emp;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {
    @Autowired
    private EmpDao empDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void contextLoads() {
        Query query = Query.query(Criteria.where("username").is("11"));
        System.out.println( mongoTemplate.find(query,User.class));
    }
    @Test
    public void aa(){
        List<User> users = Arrays.asList(
                new User(null, "zs", "123456", "123456", "男")
        );
        userDao.insert(users); // db.users.insert([{},{},{}])
    }
    @Test
    public void bb(){
//        List<Emp> list = Arrays.asList(
//                new Emp(null, "ww", 155.0, new Date(), "男"),
//                new Emp(null, "yy", 255.0, new Date(), "女"),
//                new Emp(null, "qq", 355.0, new Date(), "男"),
//                new Emp(null, "aa", 455.0, new Date(), "女"),
//                new Emp(null, "cc", 555.0, new Date(), "男")
//
//        );
//        empDao.insert(list);
    }
    @Test
    public void cc(){
        List<Emp> all = empDao.findAll();
        for (Emp emp : all) {
            System.out.println(emp.getId().equals(""));
        }
    }

}

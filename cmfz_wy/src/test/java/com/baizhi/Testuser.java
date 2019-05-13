package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)

@SpringBootTest
public class Testuser {
    @Autowired
    private UserService userService;
    @Test
    public void aa(){
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

}

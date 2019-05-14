package com;

import com.baizhi.Application;
import com.baizhi.service.GroupService;
import com.baizhi.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class test {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Test
    public void aa(){

        Long byGroupid = studentService.findByGroupid("1");
        System.out.println(byGroupid);
    }
}

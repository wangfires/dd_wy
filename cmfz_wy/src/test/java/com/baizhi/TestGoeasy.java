package com.baizhi;

import com.baizhi.entity.Fuser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.goeasy.GoEasy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)

@SpringBootTest
public class TestGoeasy {
    @Test
    public void aa() throws JsonProcessingException {
        List<Fuser> man=new ArrayList<>();
        List<Fuser> women=new ArrayList<>();
        man.add(new Fuser(10,"河南"));
        man.add(new Fuser(8,"天津"));
        women.add(new Fuser(7,"河南"));
        women.add(new Fuser(7,"天津"));
        Map<String,Object> result=new HashMap<>();
        result.put("man",man);
        result.put("women",women);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(result);
        System.out.println(s);
        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-0648bf2139c140ec8787eef013d3285a");
        goEasy.publish("my_channel",s);
    }
}

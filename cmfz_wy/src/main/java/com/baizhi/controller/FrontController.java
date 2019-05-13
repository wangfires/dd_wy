package com.baizhi.controller;

import com.baizhi.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("front")
public class FrontController {
    @Autowired
    private FrontService frontService;
    @RequestMapping("firstPage")
    @ResponseBody
    public Map<String,Object> aa(String id,String type){
        Map<String, Object> all = frontService.getFirstPage(id,type);
        return all;
    }
    @RequestMapping("wen")
    @ResponseBody
    public Map<String,Object> aa1(String id ,String uid){
        Map<String, Object> wen = frontService.getWen(id,uid);
        return wen;
    }
}

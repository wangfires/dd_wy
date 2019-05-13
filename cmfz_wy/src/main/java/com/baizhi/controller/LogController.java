package com.baizhi.controller;

import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("log")
@RestController
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("findAll")
    @ResponseBody
    public List<Log> find(){
        List<Log> all = logService.findAll();
        return all;
    }
}

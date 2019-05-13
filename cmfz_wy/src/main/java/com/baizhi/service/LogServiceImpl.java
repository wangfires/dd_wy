package com.baizhi.service;

import com.baizhi.dao.LogMapper;
import com.baizhi.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;


    @Override
    public List<Log> findAll() {
        return logMapper.selectAll();
    }
}

package com.baizhi.service;

import com.baizhi.entity.Emp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmpService {
    void add(Emp emp);
    void delete(String id);
    void update(Emp emp);
    List<Emp> findAll();
    PageInfo<Emp> findByPage(Integer page,Integer rows);
}

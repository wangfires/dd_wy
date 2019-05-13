package com.baizhi.service;

import com.baizhi.entity.Special;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SpecialService {
    void add(Special special);
    void delete(String id);
    void update(Special special);
    PageInfo<Special> findByPage(Integer page, Integer rows);
    List<Special> findAll();
}

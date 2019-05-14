package com.baizhi.service;

import com.baizhi.entity.Clazz;

import java.util.List;

public interface ClazzService {
    void add(Clazz clazz);
    void delete(String id);
    void update(Clazz clazz);
    List<Clazz> findByPage(Integer start,Integer rows);
    Long findTotals();
    List<Clazz> findAll();
}

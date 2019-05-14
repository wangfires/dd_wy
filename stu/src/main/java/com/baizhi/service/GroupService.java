package com.baizhi.service;

import com.baizhi.entity.Group;

import java.util.List;

public interface GroupService {
    void add(Group group);
    void delete(String id);
    void update(Group group);
    List<Group> findByPage(Integer start,Integer rows);
    Long findTotals();
    List<Group> findAll();
    Long findByClazzid(String clazzid);
    List<Group> findByClazz(String clazzid);
}

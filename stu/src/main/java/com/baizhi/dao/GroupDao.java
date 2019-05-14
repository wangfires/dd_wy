package com.baizhi.dao;

import com.baizhi.entity.Group;

import java.util.List;

public interface GroupDao extends BaseDao<Group>{
    List<Group> findAll();
    List<Group> findByClazz(String clazzid);
    Long findByClazzid(String clazzid);
}

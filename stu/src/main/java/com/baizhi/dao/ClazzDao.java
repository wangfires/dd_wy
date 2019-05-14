package com.baizhi.dao;

import com.baizhi.entity.Clazz;

import java.util.List;

public interface ClazzDao extends BaseDao<Clazz> {
    List<Clazz> findAll();
}

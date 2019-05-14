package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    void add(T t);
    void delete(String id);
    void update(T t);
    List<T> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);
    Long findTotals();
}

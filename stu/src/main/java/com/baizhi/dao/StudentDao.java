package com.baizhi.dao;

import com.baizhi.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao extends BaseDao<Student> {
    Long findByCityid(String cityid);
    Long findByClazzid(String clazzid);
    Long findByGroupid(String groupid);
    List<Student> findByPage(@Param("searchField") String searchField,@Param("searchString") String searchString,@Param("start") Integer strat,@Param("rows") Integer rows);
    void addTs(@Param("stuid") String stuid, @Param("tagid") String tagid);
}

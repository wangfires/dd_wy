package com.baizhi.service;

import com.baizhi.entity.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);
    void delete(String id);
    void update(Student student);
    List<Student> findByPage(String searchField,  String searchString,Integer start, Integer rows);
    Long findTotals();
    Long findByClazzid(String clazzid);
    Long findByCityid(String cityid);
    Long findByGroupid(String groupid);
    void addTs(String stuid,String tagid);
}

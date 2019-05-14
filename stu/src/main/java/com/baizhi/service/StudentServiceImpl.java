package com.baizhi.service;

import com.baizhi.dao.StudentDao;
import com.baizhi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    @Transactional
    public void add(Student student) {
        student.setId(UUID.randomUUID().toString());
        studentDao.add(student);
    }

    @Override
    @Transactional
    public void delete(String id) {
        studentDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public List<Student> findByPage(String searchField, String searchString,Integer start, Integer rows) {
        return studentDao.findByPage(searchField,searchString,start,rows);
    }

    @Override
    public Long findTotals() {
        return studentDao.findTotals();
    }

    @Override
    public Long findByClazzid(String clazzid) {
        return studentDao.findByClazzid(clazzid);
    }

    @Override
    public Long findByCityid(String cityid) {
        return studentDao.findByCityid(cityid);
    }

    @Override
    public Long findByGroupid(String groupid) {
        return studentDao.findByGroupid(groupid);
    }

    @Override
    public void addTs(String stuid, String tagid) {
        studentDao.addTs(stuid,tagid);
    }
}

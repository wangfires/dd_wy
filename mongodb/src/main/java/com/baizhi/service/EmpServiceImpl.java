package com.baizhi.service;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public void add(Emp emp) {
        empDao.insert(emp);
    }

    @Override
    public void delete(String id) {
        empDao.deleteById(id);
    }

    @Override
    public void update(Emp emp) {
        empDao.save(emp);
    }

    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public PageInfo<Emp> findByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Emp> emps = empDao.findAll();
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps);
        System.out.println(empPageInfo.getPages());
        return empPageInfo;
    }
}

package com.baizhi.service;

import com.baizhi.dao.ClazzDao;
import com.baizhi.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzDao clazzDao;
    @Override
    @Transactional
    public void add(Clazz clazz) {
        clazz.setCreatedate(new Date());
        clazz.setId(UUID.randomUUID().toString());
        clazzDao.add(clazz);
    }

    @Override
    @Transactional
    public void delete(String id) {
        clazzDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Clazz clazz) {
        clazzDao.update(clazz);
    }

    @Override
    public List<Clazz> findByPage(Integer start, Integer rows) {
        return clazzDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return clazzDao.findTotals();
    }

    @Override
    public List<Clazz> findAll() {
        return clazzDao.findAll();
    }
}

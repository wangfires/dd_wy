package com.baizhi.service;

import com.baizhi.dao.GroupDao;
import com.baizhi.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {
@Autowired
private GroupDao groupDao;
    @Override
    public void add(Group group) {
        group.setCreatedate(new Date());
        group.setId(UUID.randomUUID().toString());
        groupDao.add(group);
    }

    @Override
    public void delete(String id) {
        groupDao.delete(id);
    }

    @Override
    public void update(Group group) {
        groupDao.update(group);
    }

    @Override
    public List<Group> findByPage(Integer start, Integer rows) {
        return groupDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return groupDao.findTotals();
    }

    @Override
    public List<Group> findAll() {
        return groupDao.findAll();
    }

    @Override
    public Long findByClazzid(String clazzid) {
        return groupDao.findByClazzid(clazzid);
    }

    @Override
    public List<Group> findByClazz(String clazzid) {
        return groupDao.findByClazz(clazzid);
    }
}

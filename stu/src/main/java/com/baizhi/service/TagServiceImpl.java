package com.baizhi.service;

import com.baizhi.dao.TagDao;
import com.baizhi.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    @Transactional
    public void add(Tag tag) {
        tag.setId(UUID.randomUUID().toString());
        tagDao.add(tag);
    }

    @Override
    @Transactional
    public void delete(String id) {
    tagDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Tag tag) {
tagDao.update(tag);
    }

    @Override
    public List<Tag> findByPage(Integer start, Integer rows) {
        return tagDao.findByPage(start,rows);
    }

    @Override
    public long findTotals() {
        return tagDao.findTotals();
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public List<Tag> findByType(String type) {
        return tagDao.findByType(type);
    }
}

package com.baizhi.service;

import com.baizhi.entity.Tag;

import java.util.List;

public interface TagService {
    void add(Tag tag);
    void delete(String id);
    void update(Tag tag);
    List<Tag> findByPage(Integer start,Integer rows);
    long findTotals();
    List<Tag> findAll();
    List<Tag> findByType(String type);
}

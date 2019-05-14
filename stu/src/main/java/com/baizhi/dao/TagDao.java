package com.baizhi.dao;

import com.baizhi.entity.Tag;

import java.util.List;

public interface TagDao extends BaseDao<Tag> {
    List<Tag> findAll();
    List<Tag> findByType(String type);
}

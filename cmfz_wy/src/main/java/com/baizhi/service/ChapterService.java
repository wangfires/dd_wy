package com.baizhi.service;

import com.baizhi.entity.Chapter;
import com.github.pagehelper.PageInfo;

public interface ChapterService {
    void save(Chapter chapter);
    void remove(String id);
    void update(Chapter chapter);
    PageInfo<Chapter> findByPage(Integer page, Integer rows);
    void updatedown(String id);
    void updateplay(String id);

}

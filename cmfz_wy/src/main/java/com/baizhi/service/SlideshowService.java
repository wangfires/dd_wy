package com.baizhi.service;

import com.baizhi.entity.Slideshow;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SlideshowService {
    void add(Slideshow slideshow);
    void delete(String id);
    void update(Slideshow slideshow);
    List<Slideshow> findAll();
    Slideshow findOne(String id);
    PageInfo<Slideshow> findByPage(Integer pageNum, Integer pageSize);
    void insertSlideshows(List<Slideshow> list);
}

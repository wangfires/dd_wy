package com.baizhi.service;

import com.baizhi.aspect.TestAspect;
import com.baizhi.dao.SlideshowMapper;
import com.baizhi.entity.Slideshow;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SlideshowServiceImpl implements SlideshowService {
    @Autowired
    private SlideshowMapper slideshowMapper;
    @Override
    @Transactional
    public void add(Slideshow slideshow) {
        slideshow.setId(UUID.randomUUID().toString());
        slideshow.setCreatedate(new Date());

        slideshowMapper.insert(slideshow);
    }

    @Override
    @Transactional
    @TestAspect(value = "轮播图删除")
    public void delete(String id) {
        slideshowMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    @TestAspect(value = "轮播图更新")
    public void update(Slideshow slideshow) {
        slideshowMapper.updateByPrimaryKeySelective(slideshow);
    }

    @Override
    @TestAspect(value = "查询所有轮播图")
    public List<Slideshow> findAll() {
        return slideshowMapper.selectAll();
    }

    @Override
    public Slideshow findOne(String id) {
        return slideshowMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Slideshow> findByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Slideshow> slideshows = slideshowMapper.selectAll();
        PageInfo<Slideshow> pageInfo=new PageInfo(slideshows);
        return pageInfo;
    }

    @Override
    public void insertSlideshows(List<Slideshow> list) {
        slideshowMapper.insertSlideshows(list);
    }
}

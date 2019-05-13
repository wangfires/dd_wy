package com.baizhi.service;

import com.baizhi.aspect.TestAspect;
import com.baizhi.dao.ChapterMapper;
import com.baizhi.entity.Chapter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    @TestAspect(value = "章节添加")
    @Transactional
    public void save(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapter.setCreatedate(new Date());
        chapter.setPlaycount(0);
        chapter.setDownloadcount(0);
        chapterMapper.add(chapter);
    }

    @Override
    @TestAspect(value = "章节删除")
    @Transactional
    public void remove(String id) {
        chapterMapper.delete(id);
    }

    @Override
    @TestAspect(value = "章节更新")
    @Transactional
    public void update(Chapter chapter) {
        chapterMapper.update(chapter);
    }

    @Override
    public PageInfo<Chapter> findByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Chapter> all = chapterMapper.findAll();
        PageInfo<Chapter> chapterPageInfo = new PageInfo<>(all);
        return chapterPageInfo;
    }

    @Override
    public void updatedown(String id) {
        chapterMapper.updatedown(id);
    }

    @Override
    public void updateplay(String id) {
        chapterMapper.updateplay(id);
    }
}

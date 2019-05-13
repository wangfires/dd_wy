package com.baizhi.service;

import com.baizhi.dao.ChapterMapper;
import com.baizhi.dao.SlideshowMapper;
import com.baizhi.dao.SpecialMapper;
import com.baizhi.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class FrontServiceImpl implements FrontService {
    @Autowired
    private SlideshowMapper slideshowMapper;
    @Autowired
    private SpecialMapper specialMapper;
    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public Map<String, Object> getFirstPage(String uid, String type) {
        Map<String,Object> result= new HashMap<>();
        ArrayList<Fspecial> specials = new ArrayList<>();
        ArrayList<Fslideshow> slideshows = new ArrayList<>();
        if ("all".equals(type)){
            PageHelper.startPage(1,5);
            List<Slideshow> slideshows1 = slideshowMapper.selectAll();
            PageInfo<Slideshow> pageInfo1 = new PageInfo<>(slideshows1);
            for (Slideshow slideshow : pageInfo1.getList()) {
                Fslideshow fslideshow = new Fslideshow(slideshow.getId(), slideshow.getDes(), slideshow.getPicpath());
                slideshows.add(fslideshow);
            }
            result.put("header",slideshows);
        }
        PageHelper.startPage(1,6);
        List<Special> specials1 = specialMapper.selectAll();
        PageInfo<Special> pageInfo = new PageInfo<>(specials1);
        for (Special special : pageInfo.getList()) {
            Fspecial fspecial = new Fspecial(special.getPicture(), special.getName(),null, special.getAuthor(),null,0, special.getCount(),null,special.getCreatedate());
            specials.add(fspecial);
        }
        result.put("body",specials);
        return result;
    }

    @Override
    public Map<String, Object> getWen(String id, String uid) {
        Map<String, Object> result = new HashMap<>();
        ArrayList<Fchapter> fchapters = new ArrayList<>();
        Special special = specialMapper.selectByPrimaryKey(id);
        Fspecial fspecial = new Fspecial(special.getPicture(), special.getName(), special.getScore(), special.getAuthor(), special.getTeller(), null, special.getCount(), special.getDes(), special.getCreatedate());
        List<Chapter> chapters = chapterMapper.findBySpecialid(id);
        for (Chapter chapter : chapters) {
            Fchapter fchapter = new Fchapter(chapter.getName(), chapter.getAudiopath(), chapter.getSizes(), chapter.getDuration());
            fchapters.add(fchapter);
        }
        result.put("introduction",fspecial);
        result.put("list",fchapters);
        return result;
    }
}

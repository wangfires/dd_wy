package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import java.util.List;

public interface ChapterMapper {
    void delete(String id);

    void add(Chapter record);
    List<Chapter> findAll();
    void update(Chapter record);
    void updatedown(String id);
    void updateplay(String id);
    List<Chapter> findBySpecialid(String id);
}
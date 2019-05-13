package com.baizhi.dao;

import com.baizhi.entity.Article;
import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Article record);

    Article selectByPrimaryKey(String id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);
}
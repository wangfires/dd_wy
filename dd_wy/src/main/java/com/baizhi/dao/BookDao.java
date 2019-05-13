package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookDao extends BaseDao<Book>{
	List<Book> selectByLike(Book book);
	List<Book> selectRecommend();
	List<Book> selectBySale();
	List<Book> selectByCreateDate();
	List<Book> selectByNewAndCreateDate();
	List<Book> selectByFirst(String id);
	List<Book> selectBySecond(String id);
	Integer count1(String id);
	Integer count(String typeId);
	List<Book> findByPage(@Param("begin")Integer begin,@Param("end")Integer end,@Param("id")String id);
	List<Book> findByFirstPage(@Param("begin")Integer begin,@Param("end")Integer end,@Param("id")String id);
	void updateCount(@Param("id")String id,@Param("count")Integer count);
 }

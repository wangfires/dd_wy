package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;

public interface BookService {
	void addBook(Book book);
	void deleteBook(String id);
	void updateBook(Book book);
	Book selectById(String id);
	List<Book> selectAll();
	List<Book> selectByLike(Book book);
	List<Book> selectByBook(Book book);
	List<Book> selectRecommend();
	List<Book> selectBySale();
	List<Book> selectByCreateDate();
	List<Book> selectByNewAndCreateDate();
	List<Book> selectByFirst(String id);
	List<Book> selectBySecond(String id);
	Integer count(String typeId);
	Integer count1(String id);
	List<Book> findByPage(Integer page,String id);
	List<Book> findByFirstPage(Integer page,String id);
}

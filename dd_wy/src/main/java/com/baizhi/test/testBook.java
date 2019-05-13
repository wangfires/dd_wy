package com.baizhi.test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.util.MybatisUtil;

public class testBook {
	public static void main(String[] args) {
//		SqlSession session = MybatisUtil.getSqlSession();
//		BookDao bookDao = session.getMapper(BookDao.class);
		
		//添加图书
//		Book book = new Book("1","111","111","111", "111", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
//		bookDao.add(book);
		//删除图书
		//bookDao.delete("1");
		//修改图书
		
		//查询所有
//		List<Book> list = bookDao.selectAll();
//		System.out.println(list);
		//根据图书查询
//		Book book = new Book();
//		book.setId("22d4e0e7-52e1-4b68-b53c-ca1514091729");
//		book.setDprice(111.0);
//		bookDao.update(book);
//		session.commit();
//		List<Book> list=bookDao.selectByFirst("69c0b6a7-0247-44d8-9e6b-94cbd6024c3b");
//		List<Book> list2 = bookDao.selectBySecond("96c337e2-983e-4300-80f9-d097c039a121");
//		Integer a = bookDao.count("491ea439-5d82-476f-9a7e-973269265f8a");
//		System.out.println(a);
//		System.out.println(list2);
//		System.out.println(list);
//		List<Book> list= bookDao.findByFirstPage(1, 4, "138e08b4-e0da-49fd-b11c-c1cfc3476a8c");
//		for (Book book : list) {
//			System.out.println(book);
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String,Object> cart =(Map<String, Object>) session.getAttribute("cart");
		Double total=0d;
		Double save=0d;
		for (Entry<String, Object> entry : cart.entrySet()) {
			System.out.println(entry);
		}
		}
	
}
 
package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import com.baizhi.util.MybatisUtil;

public class BookServiceImpl implements BookService{

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		try{
			String id =UUID.randomUUID().toString();
			book.setId(id);
			bookDao.add(book);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	public void deleteBook(String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		try{
			bookDao.delete(id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		try{
			bookDao.update(book);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	public List<Book> selectByBook(Book book) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		try{
			 list = bookDao.selectByObject(book);
			 session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.close();
		}
		return list;
	}
	public List<Book> selectAll(){
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		try{
			list = bookDao.selectAll();
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.close();
		}
		return list;
	}

	@Override
	public List<Book> selectByLike(Book book) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		
		List<Book> list = new ArrayList<Book>();
		try{
			list = bookDao.selectByLike(book);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.close();
		}
		return list;
	}

	@Override
	public Book selectById(String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		Book book=new Book();
		try{
			book=bookDao.selectById(id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.close();
		}
		return book;
	}

	@Override
	public List<Book> selectRecommend() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		try{
			list=bookDao.selectAll();
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
			
		}finally{
			MybatisUtil.close();
		}
		Integer a = new Random().nextInt(list.size());
		Integer b = new Random().nextInt(list.size());
		while(true){
			if(a==b){
				b=new Random().nextInt(list.size());
			}if(a!=b){
				break;
			}
		}
		List<Book> book = new ArrayList<Book>();
		book.add(list.get(a));
		book.add(list.get(b));
		return book;
	}

	@Override
	public List<Book> selectBySale() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		try{
			list = bookDao.selectBySale();
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.close();
		}
		return list;
	}

	@Override
	public List<Book> selectByCreateDate() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		try{
			list = bookDao.selectByCreateDate();
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}
		finally{
			MybatisUtil.close();
		}
		return list;
		
	}

	@Override
	public List<Book> selectByNewAndCreateDate() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		try{
			list = bookDao.selectByNewAndCreateDate();
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}
		finally{
			MybatisUtil.close();
		}
		return list;
	}

	@Override
	public List<Book> selectByFirst(String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		try{
			list = bookDao.selectByFirst(id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Book> selectBySecond(String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		try{
			list = bookDao.selectBySecond(id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}
		MybatisUtil.close();
		return list;
	}

	@Override
	public Integer count(String typeId) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		Integer count=0;
		try{
			count=bookDao.count(typeId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			MybatisUtil.close();
		}
		return count;
	}

	@Override
	public Integer count1(String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		Integer count=0;
		try{
			count=bookDao.count1(id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		MybatisUtil.close();
		return count;
		
	}

	@Override
	public List<Book> findByPage(Integer page,String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		Integer begin = (page-1)*3;
		Integer end = page*3;
		try {
			list=bookDao.findByPage(begin, end, id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Book> findByFirstPage(Integer page, String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		List<Book> list = new ArrayList<Book>();
		Integer begin = (page-1)*3;
		Integer end = page*3;
		try {
			list=bookDao.findByFirstPage(begin, end, id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			MybatisUtil.close();
		}
		return list;
	}

}

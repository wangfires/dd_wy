package com.baizhi.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.ItemDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.service.ItemService;
import com.baizhi.util.MybatisUtil;


public class ItemServiceImpl implements ItemService{

	@Override
	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		ItemDao itemDao = sqlSession.getMapper(ItemDao.class);
		try{
			itemDao.add(item);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
		}
		finally{
			MybatisUtil.close();
		}
	}

	@Override
	public List<Item> findByOrderId(String OrderId) {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		OrderDao mapper = sqlSession.getMapper(OrderDao.class);
		Order order = mapper.selectById(OrderId);
		session.setAttribute("order", order);
		ItemDao itemDao = sqlSession.getMapper(ItemDao.class);
		List<Item> list = new ArrayList<Item>();
		try{
			list= itemDao.selectByOrderId(OrderId);
		}catch(Exception e){
			throw new RuntimeException("查询详情失败");
		}
		finally{
			MybatisUtil.close();
		}
		return list;
	}
	 
	
}

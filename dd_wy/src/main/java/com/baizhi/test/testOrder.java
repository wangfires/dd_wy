package com.baizhi.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Order;
import com.baizhi.util.MybatisUtil;

public class testOrder {
	public static void main(String[] args) {
	SqlSession sqlSession = MybatisUtil.getSqlSession();
	OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
	List<Order> list = orderDao.selectAllOrder();
	for (Order order : list) {
		System.out.println(order);
	}
	}
}

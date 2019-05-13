package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Order;

public interface OrderDao extends BaseDao<Order>{
	
	List<Order> selectAllOrder();
}

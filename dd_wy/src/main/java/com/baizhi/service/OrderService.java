package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;


public interface OrderService {
	void saveOrder(Address addr);
	List<Order> findAllOrder();
}

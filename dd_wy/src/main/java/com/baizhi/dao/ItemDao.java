package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Item;

public interface ItemDao extends BaseDao<Item>{
	List<Item> selectByOrderId(String orderId);
}

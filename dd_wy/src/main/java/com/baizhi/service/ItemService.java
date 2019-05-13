package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Item;

public interface ItemService {
	void saveItem(Item item);
	List<Item> findByOrderId(String OrderId);
}

package com.baizhi.dao;

import java.util.List;

public interface BaseDao<T> {
	//添加一个对象
	void add(T t);
	//删除一个对象
	void delete(String id);
	//修改一个对象
	void update(T t);
	//查询一个对象
	T selectById(String id);
	//查询所有对象
	List<T> selectAll();
	//根据传入的对象查询
	List<T> selectByObject(T t);
}

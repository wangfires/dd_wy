package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Type;

public interface TypeService {
	void save(Type type);
	void remove (String id);
	List<Type> showAll();
	List<Type> selectByParentId(String parentId);
	List<Type> selectByLevels(Integer levels);
	Type selectByName(String name);
	List<Type> selectAllFirst();
	Type selectFirstById(String id);
	Type  selectById(String id);
}

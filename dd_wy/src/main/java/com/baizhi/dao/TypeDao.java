package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Type;

public interface TypeDao extends BaseDao<Type >{
	List<Type> selectByParentId(String ParentId);
	List<Type> selectByLevels(Integer levels);
	Type selectByName(String name);
	List<Type> selectAllFirst();
	Type selectFirstById(String id);
}

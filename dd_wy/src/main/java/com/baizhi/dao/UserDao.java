package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.User;

public interface UserDao extends BaseDao<User> {
	User selectByEmail(String email);
	User login(User user);
	void active(@Param("id")String id,@Param("emailCode")String emailCode);
	void updateStatus(@Param("id")String id,@Param("status")String status);
}

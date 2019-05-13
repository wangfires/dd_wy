package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.User;

public interface UserService {
	void regist(User user);
	User login(User user);
	void active(String emailCode);
	void updateStatus(String id,String status);
	List<User> findAll();
}

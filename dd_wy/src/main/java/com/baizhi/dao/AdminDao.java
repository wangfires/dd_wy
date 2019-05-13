package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao {
	/**
	 * 根据管理员账号查询此人是否存在
	 * */
	Admin login(String username);
}

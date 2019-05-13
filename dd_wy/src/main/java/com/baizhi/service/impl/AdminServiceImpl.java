package com.baizhi.service.impl;

import org.apache.ibatis.session.SqlSession;


import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.MybatisUtil;

public class AdminServiceImpl implements AdminService{

	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);
		Admin loginAdmin = adminDao.login(admin.getUsername());
		MybatisUtil.close();
		
		
			
		
		return loginAdmin;
	}

}

package com.baizhi.test;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.util.MybatisUtil;

public class testAddress {
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
		Address addr = new Address("1","1","1","1","555","1");
		//addressDao.add(addr);
		//Address address = addressDao.selectByUserId("1");
		
		addressDao.update(addr);
		MybatisUtil.commit();
	}
}

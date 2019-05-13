package com.baizhi.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.util.MybatisUtil;

public class AddressServiceImpl implements AddressService{

	@Override
	public List<Address> findAllAddress() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		AddressDao addressDao = session.getMapper(AddressDao.class);
		List<Address> list = addressDao.selectAll();
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Address> findByUserId(String userId) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		AddressDao addressDao = session.getMapper(AddressDao.class);
		 List<Address> list = addressDao.selectByUserId(userId);
		MybatisUtil.close();
		return list;
	}

	@Override
	public Address findById(String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		AddressDao addressDao = session.getMapper(AddressDao.class);
		Address address = addressDao.selectById(id);
		MybatisUtil.close();
		return address;
		
	}

	@Override
	public void save(Address address) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		AddressDao addressDao = session.getMapper(AddressDao.class);
		try {
			address.setId(UUID.randomUUID().toString());
			addressDao.add(address);
			MybatisUtil.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MybatisUtil.rollback();
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

}

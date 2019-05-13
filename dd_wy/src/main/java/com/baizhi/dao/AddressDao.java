package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressDao extends BaseDao<Address>{
	List<Address> selectByUserId(String userId);
}

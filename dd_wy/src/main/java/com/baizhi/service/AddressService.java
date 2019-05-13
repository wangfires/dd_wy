package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	List<Address> findAllAddress();
	List<Address> findByUserId(String userId);
	Address findById(String id);
	void save(Address address);
	void updateAddress(Address address);
}

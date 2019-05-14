package com.baizhi.dao;

import com.baizhi.entity.Emp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpDao extends MongoRepository<Emp,String> {

}

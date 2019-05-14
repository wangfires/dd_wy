package com.baizhi.dao;

import com.baizhi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,String> {

}

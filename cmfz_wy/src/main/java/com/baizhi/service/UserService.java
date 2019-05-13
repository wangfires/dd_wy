package com.baizhi.service;

import com.baizhi.entity.Fuser;
import com.baizhi.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    Integer findOneWeek();
    Integer findTwoWeek();
    Integer findThreeWeek();
    Integer findFourWeek();
    Integer findFiveWeek();
    List<Fuser> findBySex(String sex);
    void add(User user);
    void delete(String id);
    void update(User user);
    List<User> findAll();
    PageInfo<User> findByPage(Integer page, Integer rows);
}

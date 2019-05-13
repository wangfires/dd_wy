package com.baizhi.dao;

import com.baizhi.entity.Fuser;
import com.baizhi.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    Integer findOneWeek();
    Integer findTwoWeek();
    Integer findThreeWeek();
    Integer findFourWeek();
    Integer findFiveWeek();
    List<Fuser> findBySex(String sex);
}
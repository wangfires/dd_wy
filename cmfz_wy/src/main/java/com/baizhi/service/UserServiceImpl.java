package com.baizhi.service;

import com.baizhi.aspect.TestAspect;
import com.baizhi.dao.UserMapper;
import com.baizhi.entity.Fuser;
import com.baizhi.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer findOneWeek() {
        return userMapper.findOneWeek();
    }

    @Override
    public Integer findTwoWeek() {
        return userMapper.findTwoWeek();
    }

    @Override
    public Integer findThreeWeek() {
        return userMapper.findThreeWeek();
    }

    @Override
    public Integer findFourWeek() {
        return userMapper.findFourWeek();
    }

    @Override
    public Integer findFiveWeek() {
        return userMapper.findFiveWeek();
    }

    @Override
    public List<Fuser> findBySex(String sex) {
        return userMapper.findBySex(sex);
    }

    @Override
    @Transactional
    @TestAspect(value = "用户添加")
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setCreatedate(new Date());
        userMapper.insertSelective(user);
    }

    @Override
    @Transactional
    @TestAspect(value = "用户删除")
    public void delete(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    @TestAspect(value ="用户修改")
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public PageInfo<User> findByPage(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<User> specials = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(specials);

        return pageInfo;
    }
}

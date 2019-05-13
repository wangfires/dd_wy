package com.baizhi.service;

import com.baizhi.aspect.TestAspect;
import com.baizhi.dao.SpecialMapper;
import com.baizhi.entity.Special;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SpecialServiceImpl implements SpecialService {
    @Autowired
    private SpecialMapper specialMapper;
    @Override
    @Transactional
    @TestAspect(value = "专辑添加")
    public void add(Special special) {
        special.setCreatedate(new Date());
        special.setId(UUID.randomUUID().toString());

        specialMapper.insertSelective(special);
    }

    @Override
    @Transactional
    @TestAspect(value = "专辑删除")
    public void delete(String id) {
        specialMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    @TestAspect(value = "专辑更新")
    public void update(Special special) {
        specialMapper.updateByPrimaryKeySelective(special);
    }

    @Override
    public PageInfo<Special> findByPage(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Special> specials = specialMapper.selectAll();
        PageInfo<Special> pageInfo = new PageInfo<>(specials);

        return pageInfo;
    }

    @Override
    public List<Special> findAll() {
        return specialMapper.selectAll();
    }
}

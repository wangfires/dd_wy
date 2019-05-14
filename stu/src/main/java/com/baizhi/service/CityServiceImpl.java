package com.baizhi.service;

import com.baizhi.dao.CityDao;
import com.baizhi.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CityServiceImpl implements CityService {
@Autowired
private CityDao cityDao;
    @Override
    @Transactional
    public void add(City city) {
        city.setId(UUID.randomUUID().toString());
        city.setCreatedate(new Date());
        cityDao.add(city);

    }

    @Override
    @Transactional
    public void delete(String id) {
        cityDao.delete(id);
    }

    @Override
    @Transactional
    public void update(City city) {
cityDao.update(city);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public List<City> findByPage(Integer start, Integer rows) {
        return cityDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return cityDao.findTotals();
    }
}

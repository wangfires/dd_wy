package com.baizhi.service;

import com.baizhi.entity.City;

import java.util.List;

public interface CityService {
    void add(City city);
    void delete(String id);
    void update(City city);
    List<City> findAll();
    List<City> findByPage(Integer start,Integer rows);
    Long findTotals();
}

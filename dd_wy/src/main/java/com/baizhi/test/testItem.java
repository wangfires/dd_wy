package com.baizhi.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.ItemDao;
import com.baizhi.entity.Item;
import com.baizhi.util.MybatisUtil;

public class testItem {
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		ItemDao itemDao = sqlSession.getMapper(ItemDao.class);
		List<Item> list = itemDao.selectByOrderId("7266eedc-dcca-4f18-ba9a-133818815ebd");
		System.out.println(list);
	}
}

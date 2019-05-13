package com.baizhi.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.TypeDao;
import com.baizhi.entity.Type;
import com.baizhi.util.MybatisUtil;

public class testType {
	public static void main(String[] args) {
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		Type type = typeDao.selectById("138e08b4-e0da-49fd-b11c-c1cfc3476a8c");
		System.out.println(type);
		}
		
	}


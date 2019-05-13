package com.baizhi.test;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.TypeDao;
import com.baizhi.util.MybatisUtil;

public class testCoon {
	public static void main(String[] args) throws SQLException {
		System.out.println("begin?");
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		System.out.println(sqlSession);
		TypeDao typeDao = sqlSession.getMapper(TypeDao.class);
		System.out.println(typeDao);
		System.out.println("end?");
	}
}

package com.baizhi.test;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.MybatisUtil;

public class testUser {
	public static void main(String[] args) {
		
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
//		UserDao userDao = sqlSession.getMapper(UserDao.class);
//		User user=new User("111aa","11","111","111","11","1","11",new Date());
//		
//		try {
//			User checkUser = userDao.selectByEmail(user.getEmail());
//			if(checkUser==null){
//				user.setId(UUID.randomUUID().toString());
//				user.setSalt(MD5Utils.getSalt());
//				user.setPassword(MD5Utils.getPassword(user.getPassword()+MD5Utils.getSalt()));
//				user.setCreate_date(new Date());
//				System.out.println(user);
//				userDao.add(user);
//				MybatisUtil.commit();
//				HttpSession session = ServletActionContext.getRequest().getSession();
//				session.setAttribute("checkUser", user);
//				
//			}else{
//				throw new RuntimeException("该邮箱已存在！！！");
//			}
//			
//		} catch (Exception e) {
//			MybatisUtil.rollback();
//		e.printStackTrace();
//			
//			// TODO: handle exception
//		}
//		MybatisUtil.close();
		String s = MD5Utils.getPassword("123456"+"Rh6JPixW");
		System.out.println();
		System.out.println(s.equals("c9faae96b9f7ccb30cdd9c0dcd373a06"));
	}
}

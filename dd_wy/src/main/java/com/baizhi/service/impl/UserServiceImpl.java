package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.MybatisUtil;

public class UserServiceImpl implements UserService{

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		
			User checkUser = userDao.selectByEmail(user.getEmail());
			if(checkUser==null){
				user.setId(UUID.randomUUID().toString());
				user.setSalt(MD5Utils.getSalt());
				
				user.setPassword(MD5Utils.getPassword(user.getPassword()+user.getSalt()));
				user.setStatus("正常");
				user.setCreate_date(new Date());
				System.out.println(user);
				try {
					userDao.add(user);
					HttpSession session = ServletActionContext.getRequest().getSession();
					session.setAttribute("User", user);
					MybatisUtil.commit();
				} catch (Exception e) {
					MybatisUtil.rollback();
				}
				finally{
					MybatisUtil.close();
				}
			}else{
				throw new RuntimeException("该邮箱已存在！！！");
			}
			
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		System.out.println(user);
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User checkUser=null;
		try{
			 checkUser = userDao.selectByEmail(user.getEmail());
			 System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.close();
		}
			if(checkUser!=null){
				
				if(checkUser.getPassword().equals(MD5Utils.getPassword(user.getPassword()+checkUser.getSalt()))){
					HttpSession session = ServletActionContext.getRequest().getSession();
					session.setAttribute("User", checkUser);
				}else{
					throw new RuntimeException("密码不正确！！！");
				}
			}else{
				throw new RuntimeException("邮箱不存在！！！");
			}
			
			if(checkUser.getStatus().contains("冻结")){
				throw new RuntimeException("账户已被冻结，请联系管理员！");
			}
			return checkUser;
		}

	@Override
	public void active(String inputEmailCode) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String emailCode1=(String) session.getAttribute("emailcode");
		System.out.println(emailCode1);
		
		User checkUser = (User) session.getAttribute("User");
		System.out.println(checkUser);
		
		emailCode1.equals(inputEmailCode);
		if(emailCode1.equals(inputEmailCode)){
			checkUser.setCode(inputEmailCode);
			try{
				userDao.active(checkUser.getId(), inputEmailCode);
				session.setAttribute("User", checkUser);
				MybatisUtil.commit();
			}catch(Exception e){
				e.printStackTrace();
				MybatisUtil.rollback();
				throw new RuntimeException("用户激活失败");
				
			}finally{
				MybatisUtil.close();
			}
		}else{
			throw new RuntimeException("邮箱验证码错误！！");
		}
		
	}

	@Override
	public void updateStatus(String id, String status) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		if("正常".equals(status)){
			status="冻结";
		}else{
			status="正常";
		}
		try{
			
			userDao.updateStatus(id, status);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		List<User> list = new ArrayList<User>();
		list=userDao.selectAll();
		MybatisUtil.close();
		return list;
	}
	
	}

	

	


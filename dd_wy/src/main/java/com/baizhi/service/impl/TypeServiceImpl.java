package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.TypeDao;
import com.baizhi.entity.Type;
import com.baizhi.service.TypeService;
import com.baizhi.util.MybatisUtil;

public class TypeServiceImpl implements TypeService{
	
	@Override
	public void save(Type type) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		try{
			String id = UUID.randomUUID().toString();
			type.setId(id);
			System.out.println(type);
			typeDao.add(type);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		try{
			typeDao.delete(id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	public List<Type> showAll() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		List<Type> list= typeDao.selectAll();
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Type> selectByParentId(String parentId) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		List<Type> list= typeDao.selectByParentId(parentId);
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Type> selectByLevels(Integer levels) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		List<Type> list= typeDao.selectByLevels(levels);
		MybatisUtil.close();
		return list;
	}

	@Override
	public Type selectByName(String name) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		Type type =typeDao.selectByName(name);
		MybatisUtil.close();
		return type;
	}

	@Override
	public List<Type> selectAllFirst() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		List<Type> list=new ArrayList<Type>();
		try {
			list=typeDao.selectAllFirst();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			MybatisUtil.close();
		}
		return list;
	}

	@Override
	public Type selectFirstById(String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		Type type = new Type(); 
		try{
			type=typeDao.selectFirstById(id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}
		finally{
			MybatisUtil.close();
		}
		return type;
	}

	@Override
	public Type selectById(String id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		Type type = new Type();
		try{
			type=typeDao.selectById(id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}
		finally{
			MybatisUtil.close();
		}
		return type;
	}

}

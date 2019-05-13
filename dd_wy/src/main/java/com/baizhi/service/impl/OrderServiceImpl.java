package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.dao.BookDao;
import com.baizhi.dao.ItemDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.Cart;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.OrderService;
import com.baizhi.util.MybatisUtil;

public class OrderServiceImpl implements OrderService{

	@Override
	public void saveOrder(Address address) {
		// TODO Auto-generated method stub
		//获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user=(User) session.getAttribute("User");
		Double total =(Double) session.getAttribute("total");
		Map<String, Object> cartmap = (Map<String, Object>) session.getAttribute("cartmap");
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		ItemDao itemDao = sqlSession.getMapper(ItemDao.class);
		BookDao bookDao = sqlSession.getMapper(BookDao.class);
		address.setUser_id(user.getId());
		try{
			//判断是否是新地址
			if(address.getId()==null || "".equals(address.getId())){
				address.setId(UUID.randomUUID().toString());
				System.out.println(address);
				addressDao.add(address);
				
			}else{
				//旧地址  判断地址是否发生了改变
				Address checkAddress = addressDao.selectById(address.getId());
				
				if(!checkAddress.equals(address)){
					//不存在  修改地址
					addressDao.update(address);
				}	
			}
			//添加订单
			Order order=new Order();
			order.setId(UUID.randomUUID().toString());
			Date date = new Date();
			order.setOrder_no(String.valueOf(date.getTime()));
			
			session.setAttribute("orderNo", order.getOrder_no());
			order.setUser_id(user.getId());
			order.setTotal(total);
			order.setCreate_date(date);
			order.setAddress_id(address.getId());
			order.setStatus("未支付");
			System.out.println(order);
			orderDao.add(order);
			//添加订单项
			for (Entry<String,Object> entry : cartmap.entrySet()) {
				
				Item item=new Item();
				item.setId(UUID.randomUUID().toString());
				item.setBook_id(entry.getKey());
				item.setBook(((Cart) entry.getValue()).getBook());
				item.setCount(((Cart) entry.getValue()).getCount());
				item.setBook_buyprice(((Cart) entry.getValue()).getBook().getDprice());
				item.setCreate_date(date);
				item.setOrder_id(order.getId());
				itemDao.add(item);
				//修改图书数据
			bookDao.updateCount(entry.getKey(), ((Cart) entry.getValue()).getCount());
			}
			//移除购物车
			session.removeAttribute("cartmap");
			MybatisUtil.commit();
		}catch(Exception e){
			MybatisUtil.rollback();
			throw new RuntimeException("添加订单失败");
		}
	}

	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		List<Order> list = new ArrayList<Order>();
		try{
			list=orderDao.selectAllOrder();
		}catch(Exception e){
			throw new RuntimeException("查询订单失败！！");
		}finally{
			MybatisUtil.close();
		}
		return list;
	}
}

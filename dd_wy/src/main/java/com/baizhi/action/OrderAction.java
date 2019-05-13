package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.service.ItemService;
import com.baizhi.service.OrderService;
import com.baizhi.service.impl.ItemServiceImpl;
import com.baizhi.service.impl.OrderServiceImpl;
import com.opensymphony.xwork2.Action;

public class OrderAction {
	private Address addr;
	private String orderId;
	
	public String getOrderId() {
		return orderId;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	private List<Order> list;
	private List<Item> items;
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	ItemService is = new ItemServiceImpl();
	OrderService os = new OrderServiceImpl();
	public String addOrder(){
		
		if("".equals(addr.getName()) ||"".equals(addr.getLocal())||"".equals(addr.getPhone())||"".equals(addr.getZip_code())){
			return Action.ERROR;
		}
		try{
			os.saveOrder(addr);
		}catch(Exception e){
			String message = e.getMessage();
		}
		return Action.SUCCESS;
	}
	public String showAll(){
		try{
			list=os.findAllOrder();
			
		}catch(Exception e){
			String message=e.getMessage();
		}
		return Action.SUCCESS;
	}
	public String showItem(){
		try{
			items=is.findByOrderId(orderId);
			System.out.println(items);
		}catch(Exception e){
			String message=e.getMessage();
		}
		return Action.SUCCESS;
	}
}

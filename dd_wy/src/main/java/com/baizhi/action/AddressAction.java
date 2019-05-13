package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.opensymphony.xwork2.Action;

public class AddressAction {
	private Address addr;
	private List<Address> list;
	
	public Address getAddr() {
		return addr;
	}
	public List<Address> getList() {
		return list;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}
	AddressService as = new AddressServiceImpl();
	public String findByUserId(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("User");
		list = as.findByUserId(user.getId());
		System.out.println(list);
		return Action.SUCCESS;
	}
	public String saveAddress(){
		as.save(addr);
		return Action.SUCCESS;
	}
	public String findById(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("User");
		list = as.findByUserId(user.getId());
		addr=as.findById(addr.getId());
		System.out.println(addr);
		return Action.SUCCESS;
	}
	
}

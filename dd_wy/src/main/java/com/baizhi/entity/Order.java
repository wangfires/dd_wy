package com.baizhi.entity;

import java.util.Date;

public class Order {
	private String id;
	private String order_no;
	private Double total;
	private Date create_date;
	private String status;
	private String address_id;
	private Address address;
	private String user_id;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String order_no, Double total, Date create_date,
			String status, String address_id, Address address, String user_id) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.total = total;
		this.create_date = create_date;
		this.status = status;
		this.address_id = address_id;
		this.address = address;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_no=" + order_no + ", total="
				+ total + ", create_date=" + create_date + ", status=" + status
				+ ", address_id=" + address_id + ", address=" + address
				+ ", user_id=" + user_id + "]";
	}
	public String getId() {
		return id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public Double getTotal() {
		return total;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public String getStatus() {
		return status;
	}
	public String getAddress_id() {
		return address_id;
	}
	public Address getAddress() {
		return address;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}

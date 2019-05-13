package com.baizhi.entity;

import java.util.Date;

public class Cart {
	private String id;
	private Book book;
	private Integer count;
	private Date createDate;
	private String orderId;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String id, Book book, Integer count, Date createDate,
			String orderId) {
		super();
		this.id = id;
		this.book = book;
		this.count = count;
		this.createDate = createDate;
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", book=" + book + ", count=" + count
				+ ", createDate=" + createDate + ", orderId=" + orderId + "]";
	}
	public String getId() {
		return id;
	}
	public Book getBook() {
		return book;
	}
	public Integer getCount() {
		return count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	
}

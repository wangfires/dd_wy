package com.baizhi.entity;

import java.util.Date;

public class Item {
	private String id;
	private String order_id;
	private Double book_buyprice;
	private String book_id;
	private Book book;
	private Integer count;
	private Date create_date;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String id, String order_id, Double book_buyprice,
			String book_id, Book book, Integer count, Date create_date) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.book_buyprice = book_buyprice;
		this.book_id = book_id;
		this.book = book;
		this.count = count;
		this.create_date = create_date;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", order_id=" + order_id + ", book_buyprice="
				+ book_buyprice + ", book_id=" + book_id + ", book=" + book
				+ ", count=" + count + ", create_date=" + create_date + "]";
	}
	public String getId() {
		return id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public Double getBook_buyprice() {
		return book_buyprice;
	}
	public String getBook_id() {
		return book_id;
	}
	public Book getBook() {
		return book;
	}
	public Integer getCount() {
		return count;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public void setBook_buyprice(Double book_buyprice) {
		this.book_buyprice = book_buyprice;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
}

package com.baizhi.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Cart;
import com.baizhi.service.BookService;
import com.baizhi.service.impl.BookServiceImpl;
import com.opensymphony.xwork2.Action;

public class CartAction {
	private String bookId;
	private Integer count;
	public String getBookId() {
		return bookId;
	}
	public Integer getCount() {
		return count;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	BookService bs = new BookServiceImpl();
	public String addCart(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String,Object> cartmap =(Map<String, Object>) session.getAttribute("cartmap");
	
		if(cartmap==null){	
			cartmap=new HashMap<String,Object>();
		}
		if(cartmap.containsKey(bookId)){
			
			Cart cart1=(Cart) cartmap.get(bookId);
			Book book = bs.selectById(bookId);
			cart1.setBook(book);
			cart1.setCount(cart1.getCount()+1);
			cartmap.put(bookId, cart1);
		}else{
			Cart cart1 =new Cart();
			Book book=bs.selectById(bookId);
			cart1.setBook(book);
			cart1.setCount(1);
			
			cartmap.put(bookId,cart1);
			
		}
		session.setAttribute("cartmap", cartmap);
		calc();
		return Action.SUCCESS;
	}
	public void calc(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String,Object> cartmap =(Map<String, Object>) session.getAttribute("cartmap");
		Double total=0d;
		Double save=0d;
		
		for (String bookId : cartmap.keySet()) { 
			
			Cart cart1=(Cart) cartmap.get(bookId);
			System.out.println(cart1.getBook().getDprice());
			System.out.println(cart1.getCount());
			total+=cart1.getBook().getDprice()*cart1.getCount();
			save+=(cart1.getBook().getDprice()-cart1.getBook().getPrice())*cart1.getCount();
		}
		session.setAttribute("total", total);
		session.setAttribute("save", save);
	}
	public String update(){
		 if(count == null || count <0||count>2147483647){
				
				return Action.ERROR;
			}else {
			HttpSession session = ServletActionContext.getRequest().getSession();
			Map<String,Object> cartmap =(Map<String, Object>) session.getAttribute("cartmap");
			
			
			Cart cart1 = (Cart) cartmap.get(bookId);
			
			cart1.setCount(count);
			cartmap.put(bookId, cart1);
			calc();
			return Action.SUCCESS;
		}
		
	}
	public String remove(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String,Object> cartmap =(Map<String, Object>) session.getAttribute("cartmap");
		cartmap.remove(bookId);
		calc();
		return Action.SUCCESS;
	}
}


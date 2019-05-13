package com.baizhi.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Type;
import com.baizhi.service.BookService;
import com.baizhi.service.TypeService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.TypeServiceImpl;
import com.opensymphony.xwork2.Action;

public class BookAction {
	private File cover;
	private Integer page;


	private String coverFileName;
	
	private Book book;
	private String id;
	private Integer count;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	private List<Book> list;
	private List<Book> b2;
	
	private List<Book> news;
	private List<Book> recommends;
	private List<Book> sales;
	private List<Book> newSales;
	
	private List<Type> type;
	private Type t;
	
	private String key;
	public Type getT() {
		return t;
	}
	
	BookService bs = new BookServiceImpl();
	TypeService ts = new TypeServiceImpl();
	
	
	public String save(){
		String path = ServletActionContext.getRequest().getRealPath("/upload");
		if(cover!=null && coverFileName!=null){
			try {
				FileUtils.copyFile(cover, new File(path,coverFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			book.setCover(coverFileName);
			book.setSale(0);
		}
		bs.addBook(book);
		return Action.SUCCESS;
	}
	public String selectType(){
		type=ts.selectByLevels(2);
		
		return Action.SUCCESS;
	}
	public String remove(){
		String id = book.getId();
		bs.deleteBook(id);
		return Action.SUCCESS;
	}
	public String showAll(){
		list=bs.selectAll();
		
		return Action.SUCCESS;
	}
	public String select(){
		book=new Book();
		
		
		
		if(key.equals("name")){
			book.setName(content);
		}else if(key.equals("author")){
			book.setAuthor(content);
		}else if(key.equals("press")){
			book.setPress(content);
		}
		list=bs.selectByLike(book);
	
		return Action.SUCCESS;
	}
	public String update() throws Exception{
		if(coverFileName!=null){
			FileInputStream is = new FileInputStream(cover);
			String realPath = ServletActionContext.getRequest().getRealPath("/upload");
			FileOutputStream os = new FileOutputStream(new File(realPath+"/"+coverFileName));
			int len = 0;
			byte [] b =new byte[1024];
			while(true){
				len=is.read(b);
				if(len==-1)break;
				os.write(b, 0, len);
			}
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
		
		
		book.setCover(coverFileName);
		
	
		bs.updateBook(book);
		return Action.SUCCESS;
	}
	public String selectById(){
		type=ts.selectByLevels(2);
		String id = book.getId();
		
		book = bs.selectById(id);
		
		System.out.println(book);
		return Action.SUCCESS;
	}
	public String download() throws Exception{
		System.out.println(coverFileName);
		if(coverFileName!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			String realPath = request.getRealPath("/upload");
			FileInputStream is = new FileInputStream(new File(realPath+"/"+coverFileName));
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/inline");
			response.setHeader("content-disposition", "inline;coverFileName"+coverFileName);
			ServletOutputStream os = response.getOutputStream();
			int len = 0;
			byte [] b = new byte[1024];
			while(true){
				len = is.read(b);
				if(len==-1)break;
				os.write(b,0,len);
			}
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
		return Action.NONE;
		
	}
	public String mainPage(){
		type=ts.selectAllFirst();
		sales=bs.selectBySale();
		news = bs.selectByCreateDate();
		recommends=bs.selectRecommend();
		newSales=bs.selectByNewAndCreateDate();
		
		return Action.SUCCESS;
	}	
	
	public String secondPage(){
		
		t =ts.selectById(id);
		if(page==null||page<=0){
			page=1;
		}
		
		
		
		System.out.println(t);
		if(t.getLevels()==1){
			t=ts.selectFirstById(id);	
			list = bs.findByFirstPage(page, id);
		
			for (Book book : list) {
				System.out.println(book);
			}
			count = bs.count1(id);
		}else if(t.getLevels()==2){
			
			t=ts.selectFirstById(t.getParentId());                                     
			list=bs.findByPage(page,id);
			count = bs.count(id);
		}
		if(list.size()==0){
			page=0;
		}
		Integer a = bs.count1(t.getId());
		t.setCount(a);
		
		for (Type type : t.getType1()) {
			Integer b = bs.count(type.getId());
			type.setCount(b);
			
		}
		return Action.SUCCESS;
	}
	public String detail(){
		book=bs.selectById(book.getId());
		return Action.SUCCESS;
	}
	
	
	public Book getBook() {
		return book;
	}
	public List<Book> getList() {
		return list;
	}
	public List<Type> getType() {
		return type;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
	public void setType(List<Type> type) {
		this.type = type;
	}
	public File getCover() {
		return cover;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCover(File cover) {
		this.cover = cover;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Book> getB2() {
		return b2;
	}
	public void setB2(List<Book> b2) {
		this.b2 = b2;
	}
	public List<Book> getNews() {
		return news;
	}
	public List<Book> getRecommends() {
		return recommends;
	}
	public List<Book> getSales() {
		return sales;
	}
	public List<Book> getNewSales() {
		return newSales;
	}
	public void setNews(List<Book> news) {
		this.news = news;
	}
	public void setRecommends(List<Book> recommends) {
		this.recommends = recommends;
	}
	public void setSales(List<Book> sales) {
		this.sales = sales;
	}
	public void setNewSales(List<Book> newSales) {
		this.newSales = newSales;
	}
	public void setT(Type t) {
		this.t = t;
	}
	private String content;
	public String getKey() {
		return key;
	}
	public String getContent() {
		return content;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
}

package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.ImageUtil;
import com.baizhi.util.MD5Utils;
import com.opensymphony.xwork2.Action;

public class UserAction {
	private String code;
	private String emailCode;
	private User user;
	private String id;
	private String status;
	private String message;
	private String inputCode;
	private List<User> list;
	public String getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public List<User> getList() {
		return list;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public String getInputCode() {
		return inputCode;
	}
	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
	UserService us = new UserServiceImpl();
	
	
	
	public String getCode() {
		return code;
	}
	public String getEmailCode() {
		return emailCode;
	}
	public User getUser() {
		return user;
	}
	public String getMessage() {
		return message;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//验证码
	public void getImage() throws IOException{
		char[] char1 = ImageUtil.getRandomChar();
		String code =String.copyValueOf(char1);
		ServletActionContext.getRequest().getSession().setAttribute("code", code);
		BufferedImage image = ImageUtil.getImage(char1);
		ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
		ImageIO.write(image, "png", outputStream);
		outputStream.close();
	}
	//注册
	public String regist(){
		String s = (String) ServletActionContext.getRequest().getSession().getAttribute("code");
		
		try {
			if(!s.equalsIgnoreCase(code)){
				throw new RuntimeException("验证码出错");
			}
			us.regist(user);
		} catch (Exception e) {
			message=e.getMessage();
			System.out.println("message:"+message);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	public String login(){
		try{
			us.login(user);
			
			return Action.SUCCESS;
		}catch(Exception e){
			message=e.getMessage();
			return "error";
		}
		
	}
	public String sendEmail(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String salt=MD5Utils.getSalt();
		User loginuser = (User) session.getAttribute("User");
		System.out.println(loginuser);
		session.setAttribute("emailcode",salt);
		//SendEmailUtil.sendMessage(loginuser.getEmail(), salt);
		return Action.SUCCESS;
		
	}
	public String emailCode(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User checkUser = (User) session.getAttribute("User");
		String code=(String) session.getAttribute("emailcode");
		
		return Action.SUCCESS;
	}
	
	public String inputCode(){
		System.out.println("111"+inputCode);
		try{
			
			us.active(inputCode);
			
			return Action.SUCCESS;
		}catch(Exception e){
			message=e.getMessage();
			return Action.ERROR;
		}
	}
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return Action.SUCCESS;
	}
	public String updateStatus(){
		us.updateStatus(id, status);
		return Action.SUCCESS;
	}
	public String showAll(){
		list=us.findAll();
		return Action.SUCCESS;
	}
}

package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.impl.AdminServiceImpl;
import com.baizhi.util.ImageUtil;
import com.baizhi.util.MybatisUtil;
import com.opensymphony.xwork2.Action;

public class AdminAction {
	private Admin admin;
	private String message;
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	AdminService as=new AdminServiceImpl();
	public String login(){
		String s =null;
		Admin loginAdmin=as.login(admin);
		
		
		String s1 = (String) ServletActionContext.getRequest().getSession().getAttribute("code");
		
		try{
			if(!code.equalsIgnoreCase(s1)){
				s=Action.ERROR;
				throw new RuntimeException("验证码错误！！！");		
			}
			if(loginAdmin ==null){
				s=Action.ERROR;
				throw new RuntimeException("账号不存在！！！");				
			}else if(loginAdmin !=null&&!admin.getPassword().equals(loginAdmin.getPassword())){
				s=Action.ERROR;
				throw new RuntimeException("密码不正确！！！");	
			}else{
				s=Action.SUCCESS;
			}
		}catch(Exception e){
			message = e.getMessage();
			try {
				message = URLEncoder.encode(message, "utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		ServletActionContext.getRequest().getSession().setAttribute("login", loginAdmin);
		return s;
		
	}
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return Action.SUCCESS;
	}
	public void getImage() throws IOException{
		char[] char1 = ImageUtil.getRandomChar();
		String code =String.copyValueOf(char1);
		ServletActionContext.getRequest().getSession().setAttribute("code", code);
		BufferedImage image = ImageUtil.getImage(char1);
		ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
		ImageIO.write(image, "png", outputStream);
		 outputStream.close();
	}
}

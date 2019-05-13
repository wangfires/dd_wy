package com.baizhi.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UserInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		//获取登陆标记
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("User");
		if(user==null){
			//未登录
			return "login";
		}else{
			if(user.getCode()==null||"".equals(user.getCode())){
				//已登录  未激活
				return "active";
			}else{
				//已登录  已激活
				ai.invoke();
				return "ok";
			}
		}
		
	}

}

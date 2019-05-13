package com.baizhi.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AdminLogin implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		//获取登陆标记
		Object o = ServletActionContext.getRequest().getSession().getAttribute("login");
		if(o!=null){
			//放行
			actionInvocation.invoke();
		}
		return "login";
	}

}

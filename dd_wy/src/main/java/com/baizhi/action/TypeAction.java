package com.baizhi.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Type;
import com.baizhi.service.TypeService;
import com.baizhi.service.impl.TypeServiceImpl;
import com.opensymphony.xwork2.Action;

public class TypeAction {
	private String message;
	private Type type ;
	private List<Type> list;
	TypeService ts = new TypeServiceImpl();
	public String showAll(){
		
		list=ts.showAll();
	
		return Action.SUCCESS;
	}
	public String saveType(){
		Type type2 = ts.selectByName(type.getName());
		String s="" ;
		try{
			if(type2!=null){
				if(type.getParentId()!=null){
					s="error";
				}else{
					s="error2" ;
				}
				
				throw new RuntimeException("已存在的类别！！！");	
			}
			else{
				if(type.getParentId()!=null){
					type.setLevels(2);
				}else{		
					type.setLevels(1);
				}
				s= Action.SUCCESS;
				ts.save(type);
		}
		}catch(Exception e){
			message=e.getMessage();
		}
		
		return s;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String removeType(){
		
		List<Type> list1=ts.selectByParentId(type.getId());
		System.out.println(list1);
		if(list1.size()!=0){
			return Action.ERROR;
		}else{
			ts.remove(type.getId());
			return Action.SUCCESS;
		}
		
	}
	public String findParent(){
		list=ts.selectByLevels(1);
		return Action.SUCCESS;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public List<Type> getList() {
		return list;
	}
	public void setList(List<Type> list) {
		this.list = list;
	}
	
}

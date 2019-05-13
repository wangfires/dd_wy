package com.baizhi.entity;

import java.util.List;

public class Type {
	private String id;
	private String name;
	private String parentId;
	private Integer levels;
	private Type type;
	private List<Type> type1;
	private Integer count;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", parentId=" + parentId
				+ ", levels=" + levels + ", type=" + type + ", type1=" + type1
				+ ", count=" + count + "]";
	}
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public String getParentId() {
		return parentId;
	}
	public Integer getLevels() {
		return levels;
	}
	public Type getType() {
		return type;
	}
	public List<Type> getType1() {
		return type1;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public void setType1(List<Type> type1) {
		this.type1 = type1;
	}
	

	
}

package com.baizhi.entity;

import java.util.Date;

public class User {
	private String id;
	private String email;
	private String password;
	private String salt;
	private String nickname;
	private String status;
	private String code;
	private Date create_date;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String email, String password, String salt,
			String nickname, String status, String code, Date create_date) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.nickname = nickname;
		this.status = status;
		this.code = code;
		this.create_date = create_date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", salt=" + salt + ", nickname=" + nickname + ", status="
				+ status + ", code=" + code + ", create_date=" + create_date
				+ "]";
	}
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getSalt() {
		return salt;
	}
	public String getNickname() {
		return nickname;
	}
	public String getStatus() {
		return status;
	}
	public String getCode() {
		return code;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
}

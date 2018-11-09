package com.login.project.loginDemo.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_name")
	private String userName;
	
	private String token;
	
	@Column(name = "password")
	private String password;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTs")
	private Date createTime;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateTs")
	private Date updateTime;
	
	private Date expireTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public User() {
		super();
		this.createTime = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(this.createTime);
		calendar.add(calendar.DATE, 14);
		this.updateTime = createTime;
		this.expireTime = calendar.getTime();
	}
	public User(String username, String password) {
		super();
		this.setUserName(username);
		this.setPassword(password);
		this.createTime = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(this.createTime);
		calendar.add(calendar.DATE, 14);
		this.updateTime = createTime;
		this.expireTime = calendar.getTime();
	}
	
	
}

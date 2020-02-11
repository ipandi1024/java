package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private Integer id;
	private String name;
	private Date birthday;
	private Double money;
	
	public User() {
	}
	
	public User(Integer id, String name, Date birthday, Double money) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.money = money;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + ", money=" + money + "]";
	}
	
	

}

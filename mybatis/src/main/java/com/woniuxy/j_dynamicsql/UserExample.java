package com.woniuxy.j_dynamicsql;

import java.util.Date;
import java.util.List;

public class UserExample {
	
	private Integer id; 
	
	private String name;
	
	private Integer maxId;  
	
	private List<Integer> ids;

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
	public Integer getMaxId() {
		return maxId;
	}
	public void setMaxId(Integer maxId) {
		this.maxId = maxId;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
}

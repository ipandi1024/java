package com.woniuxy.k_di2;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Foo {
	private List list;
	private Set set;
	private Map map;
	private String[] strs;
	private Properties props;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public String[] getStrs() {
		return strs;
	}
	public void setStrs(String[] strs) {
		this.strs = strs;
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
}

package com.woniuxy.l_lazyload;

import java.io.Serializable;
import java.util.Set;

public class Dept implements Serializable {
	private Integer did;
	private String dname;
	private Set<Emp> emps;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname + "]";
	}
}

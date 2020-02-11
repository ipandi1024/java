package com.woniu.page;

public interface Dialect {
	public String getPageSql(String sql,int offset,int limit);
}

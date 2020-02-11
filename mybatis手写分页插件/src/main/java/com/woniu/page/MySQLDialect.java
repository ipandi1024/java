package com.woniu.page;

public class MySQLDialect implements Dialect {

	@Override
	public String getPageSql(String sql, int offset, int limit) {
		// TODO Auto-generated method stub
		return sql + " limit "+offset+","+limit;
	}

}

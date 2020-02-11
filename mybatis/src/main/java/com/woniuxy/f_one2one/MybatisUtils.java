package com.woniuxy.f_one2one;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sf;
	
	static {
		InputStream in = MybatisUtils.class.getResourceAsStream("mybatis-config.xml");
		sf = new SqlSessionFactoryBuilder().build(in);
	}
	
	public static SqlSession getSqlSession() {
		return sf.openSession(true); 
	}
	
	
}

package com.woniuxy.e_$;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
 #{}  和  ${}  的区别
 1. #{} 会在参数钱前后添加引号
    ${} 不会在参数钱前后添加引号
 2. ${} 底层使用的是jdbc中的Statement，没有使用占位符（？）
 	#{} 底层使用的是jdbc中的PreparedStatement，有使用占位符（？）
 3. ${}有sql注入漏洞的危险，#{}没有！！
 
 什么时候使用${} :  填装 表名 和 列名时 ，应该使用${}
 什么时候使用#{} : 填装 表中的值的时候，应该使用#{}


*/

public class App {
	
	@Test
	public void test() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		Map map = new HashMap();
		map.put("col", "money");
		List<User> list = mapper.find(map);
		for (User user : list) {
			System.out.println(user);
			
		}
		// ===================================================================
		s.close();
		
	}
	
	@Test
	public void test2() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		Map map = new HashMap();
		map.put("name", "'abc' or 1=1");
		List<User> list = mapper.find2(map);
		for (User user : list) {
			System.out.println(user);
			
		}
		// ===================================================================
		s.close();
		
	}
	
	
	
}

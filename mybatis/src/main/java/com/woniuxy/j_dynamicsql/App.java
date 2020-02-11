package com.woniuxy.j_dynamicsql;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class App {
	@Test
	public void test() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		
		UserExample ue = new UserExample();
//		ue.setId(1);
//		ue.setName("andy");
//		ue.setMaxId(10);
//		ue.setIds(Arrays.asList(11,13,15,17));
		
		
		List<User> list = mapper.find4(ue);
		
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
		
		User user = new User();
		user.setId(15);
		user.setName("¶À¹Â¾Å½£");
		user.setBirthday(new Date());
		user.setMoney(1000d);
		
		
		mapper.update(user);
		
		// ===================================================================
		s.close();
		
	}
	
	
}

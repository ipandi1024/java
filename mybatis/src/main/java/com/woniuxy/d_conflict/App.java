package com.woniuxy.d_conflict;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class App {
	@Test
	public void test() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		List<User> list = mapper.findAll2();
		for (User user : list) {
			System.out.println(user);
		}
		// ===================================================================
		s.close();
	}
	
}

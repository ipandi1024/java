package com.woniuxy.c_dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class App {
	@Test
	public void testSave() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		User user = new User();
		user.setName("bb");
		UserMapper mapper = s.getMapper(UserMapper.class);
		mapper.save(user); 
		// ===================================================================
		s.close();
	}
	
	@Test
	public void testDelete() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		mapper.delete(24);
		// ===================================================================
		s.close();
	}
}

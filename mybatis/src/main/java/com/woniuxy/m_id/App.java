package com.woniuxy.m_id;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class App {
	
	@Test
	public void test() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		User user = new User();
		user.setName("ÀÔ»®");
		mapper.save(user);
		// ===================================================================
		s.close();
		
	}
	
	
	
	
	
}

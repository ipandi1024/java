package com.woniuxy.i_func;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class App {
	@Test
	public void test() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		List<Map> list = mapper.find3();
		
		for (Map map : list) {
			System.out.println(map);
		}
		// ===================================================================
		s.close();
	}
	
}

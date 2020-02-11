package com.woniuxy.g_one2many;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class App {
	
	@Test
	public void test() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		
//		DeptMapper mapper = s.getMapper(DeptMapper.class);
//		Dept d = mapper.findOne(2);
//		System.out.println(d);
//		System.out.println(d.getEmps());
		
		EmpMapper mapper = s.getMapper(EmpMapper.class);
		Emp e = mapper.findOne(1);
		System.out.println(e);
		System.out.println(e.getDept());
		
		// ===================================================================
		s.close();
		
	}
	
	
	
}

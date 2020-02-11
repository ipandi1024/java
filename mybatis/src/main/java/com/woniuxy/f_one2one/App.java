package com.woniuxy.f_one2one;

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
		
//		HusbandMapper mapper = s.getMapper(HusbandMapper.class);
//		Husband h = mapper.findOne(1);
//		System.out.println(h);
//		System.out.println(h.getWife());
		
		WifeMapper mapper = s.getMapper(WifeMapper.class);
		Wife w = mapper.findOne(1);
		System.out.println(w);
		System.out.println(w.getHusband());
		
		// ===================================================================
		s.close();
		
	}
	
	
	
}

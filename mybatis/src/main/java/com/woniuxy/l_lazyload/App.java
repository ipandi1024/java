package com.woniuxy.l_lazyload;

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
		DeptMapper mapper = s.getMapper(DeptMapper.class);
		Dept d = mapper.findOne(1);
		
		System.out.println(d);
		
		System.out.println("Enter..");
		System.in.read();
		
		
		System.out.println(d.getEmps());
		
		/*
		 ע�⣺����ʱӦ��ʹ��dept.getDname()������ӳټ����Ƿ����óɹ�����Ϊ���ֱ�����dept����Ļ�������dept��toString�в�û
		�з���emps��������ֱ�Ӽ���Ա���������!
		 */
		
		// ===================================================================
		s.close();
		
	}
	
	
	@Test
	public void test2() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		EmpMapper mapper = s.getMapper(EmpMapper.class);
		
		List<Emp> list = mapper.findByDid(1);
		
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
		// ===================================================================
		s.close();
		
	}
	
	
	
}

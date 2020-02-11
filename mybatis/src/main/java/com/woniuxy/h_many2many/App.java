package com.woniuxy.h_many2many;

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
//		TeacherMapper mapper = s.getMapper(TeacherMapper.class);
//		Teacher t = mapper.findOne(2);
//		System.out.println(t);
//		System.out.println(t.getStudents());
		StudentMapper mapper = s.getMapper(StudentMapper.class);
		Student stu = mapper.findOne(1);
		System.out.println(stu);
		System.out.println(stu.getTeachers());
		// ===================================================================
		s.close();
		
	}
	
	
	
}

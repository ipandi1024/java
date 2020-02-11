package com.woniuxy.e_$;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
 #{}  ��  ${}  ������
 1. #{} ���ڲ���Ǯǰ���������
    ${} �����ڲ���Ǯǰ���������
 2. ${} �ײ�ʹ�õ���jdbc�е�Statement��û��ʹ��ռλ��������
 	#{} �ײ�ʹ�õ���jdbc�е�PreparedStatement����ʹ��ռλ��������
 3. ${}��sqlע��©����Σ�գ�#{}û�У���
 
 ʲôʱ��ʹ��${} :  ��װ ���� �� ����ʱ ��Ӧ��ʹ��${}
 ʲôʱ��ʹ��#{} : ��װ ���е�ֵ��ʱ��Ӧ��ʹ��#{}


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

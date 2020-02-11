package com.woniuxy.k_cache;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
	ʲô�ǻ��棺
		�������һƬ�ڴ档��map��
	
	��������ã�
		�����ݸ��ӽ���ʹ���ߡ��Ӷ���߳�������ܡ�  
	
	mybatis�е�һ�����棺 ���ص㣩
	a. mybatis��һ�����棬��SqlSession����Ļ��档 
		Ҳ����˵��ֻҪ��SqlSession�ر��ˣ���ôһ������Ҳ���ͷ��ˣ�
		����˵��һ�����治�ܿ�Ự����
	b. mybatis��һ��������ʵ��SqlSession�ڲ���װ��һ��HashMap��
	   	��Ȼ��map���Ǳض�Ҫ�洢����ֵ�ԣ������ǣ���map�ļ�ֵ��ʲô�� ֵ����ʲô��
	   
		��ֵ����ɣ�
			statementId + rowBounds + 	���ݸ�JDBC��SQL + ���ݸ�JDBC�Ĳ���ֵ
			���id		  rowBounds����	 sql���			sql���Ĳ���
			
		��mapper.find(11);Ϊ�����ò�ѯʹ�õļ�ֵ�ǣ� 
			find + null + ��select * from user where id = ?�� +  11
			
	c. ִ����close clearCache update delete insert�ͻ����һ������
			
	mybatis�Ķ�������
	a. mybatis�Ķ������棬��SqlSessionFactory����Ļ��档
	 	Ҳ����˵��ֻҪ��SqlSessionFactory�ر��ˣ���ô��������Ҳ���ͷ��ˣ�
		���Զ���������Կ�Ự���Ͼ�SqlSessionFactory��������������ͬ��SqlSession��
		Ҳ����˵��SqlSessionFactory�����������У��ж��SqlSession���������ڣ�
		SqlSessionFactory����������Ӧ��ͬ��������������webӦ��������ʱ��SqlSessionFactory�ͱ�������
		֪��webӦ�ñ�ж�ص�ʱ��SqlSessionFactory�ű��رգ�
	b. mybatis�Ķ���������ʵ��SqlSessionFactory�ڲ���װ��һ��HashMap��
		��������ļ�ֵ�����һ������ļ�ֵ�����һ���ģ� 
	c. mybaits�Ķ������棬Ĭ���ǹر��ŵģ�������Ч���ģ���mybatis��һ�������ǿ����ģ�Ҳ�޷��رգ�
	d. ���ö���������Ч���������������������������
		1) ����������
			<settings>
				<setting name="cacheEnabled" value="true"/>
			</settings>
		2) ����������
			<cache />
	e. ִ����close clearCache update delete insert�ͻ���ն�������
	
	f. ��Ȼ����������Կ�Ự����ô��Ȼ������ϵͳ�����и���İ�������ΪʲôĬ���ǹر��ŵ��أ���
	��Ϊ�������沢�����õ�Խ���Խ�á� ����ھ�������ѯ�Ĳ���������ʹ�ö������棬����ھ����޸ĵĲ������ʺ��ö������档
*/		

public class App {
	
	// ��ʾһ�����治�ܿ�Ự
	@Test
	public void test() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		
		UserMapper mapper = s.getMapper(UserMapper.class);
		
		User user = mapper.find(11);
		User user2 = mapper.find(11);
		User user3 = mapper.find(11);
		
		System.out.println(user);
		System.out.println(user2);
		System.out.println(user3);
		
		
		// �޸�
//		User u = new User();
//		u.setId(7);
//		u.setName("����");
//		mapper.update(u);
		
		
		// ===================================================================
		s.close();
		
		System.out.println("===========================================================");
		
		
		SqlSession s2 = MybatisUtils.getSqlSession();
		// ===================================================================
		
		UserMapper mapper2 = s2.getMapper(UserMapper.class);
		
		User user4 = mapper2.find(11);
		User user5 = mapper2.find(11);
		User user6 = mapper2.find(11);
		
		System.out.println(user4);
		System.out.println(user5);
		System.out.println(user6);
		
		// ===================================================================
		s2.close();
	}
	
	
	// ����һ������ײ��map�ļ�ֵ��
	@Test
	public void test2() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		
		UserMapper mapper = s.getMapper(UserMapper.class);
		
//		User user = mapper.find(11);
//		User user2 = mapper.find(11);
//		System.out.println(user);
//		System.out.println(user2);
		
		UserExample ue = new UserExample();
		ue.setId(11);
		User user = mapper.find3(ue);
		ue.setName("abc");
//		ue.setId(12);
		User user2 = mapper.find3(ue);
		System.out.println(user);
		System.out.println(user2);
		
		// ===================================================================
		s.close();
		
	}
	
	
	// ����RowBounds��ʹ��
	@Test
	public void test3() throws Exception {
		SqlSession s = MybatisUtils.getSqlSession();
		// ===================================================================
		
		UserMapper mapper = s.getMapper(UserMapper.class);
		RowBounds rb = new RowBounds(3,2);
		List<User> list = mapper.find4(rb);
		for (User user : list) {
			System.out.println(user);
		}
		
		// ���һ������
		// s.clearCache();
		
		// �޸ġ�ɾ�������ӣ���������һ���������գ���
		User u = new User();
		u.setId(7);
		u.setName("�����");
		mapper.update(u);
		
		RowBounds rb2 = new RowBounds(3,2);
		List<User> list2 = mapper.find4(rb2);
		for (User user : list2) {
			System.out.println(user);
		}
		
		
//		RowBounds rb3 = new RowBounds(3,2);
//		List<User> list3 = mapper.find4(rb3);
//		for (User user : list2) {
//			System.out.println(user);
//		}
		
		// ===================================================================
		s.close();
		
	}
	
}

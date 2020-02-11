package com.woniuxy.a_hello;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class App {
	
	@Test
	public void testSave() throws Exception {
		// ����mybatis�������ļ�
		// ��App.class�ֽ�������·����ʼѰ��mybatis-config.xml
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		// ����SqlSessionFactory��SqlSessionFactory��ר���������� SqlSession��
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		// ��ȡһ���Ự������ĻỰ���Ǵ��������ݿ⿪ʼ�� ���ر������ݿ�����Ϊֹ�� ÿһ��SqlSession�����ж���װ��һ��Connection����
		// ע�⣬�ڻ�ȡ�Ự��ͬʱ�������Ѿ������ˣ���һ���hibernatw��һ����
		SqlSession s = sf.openSession();
		
		// ���µ�aa.save����ʾ
		/*
		 	aa��������ĳһ��������������ļ��� Ҫ��XXXMapper.xml�е�mapperԪ�ص�namespaceһ��
		 	saveҪ���������ļ��е�����idһ��
		*/
		User user = new User();
		user.setName("���޼�");
		user.setBirthday(new Date());
		user.setMoney(333d);
		
		s.insert("com.woniuxy.a_hello.UserMapper.save", user);
		
		// �ύ������Ȼ�������Զ������ģ������ύ���������ֶ��ύ��
		s.commit();
		// �رջỰ���������ǹر�mybatis�ĻỰ��ʵ���ϵײ��ǹر������ݿ����ӣ�  
		s.close();
	}
	
	@Test
	public void testDelete() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		// ��ͨ�� sf.openSession();��ȡ�Ự�����ʱ�����������true�����ʾ�������s.close()��ʱ���Զ��ύ��
		SqlSession s = sf.openSession(true);
		s.delete("com.woniuxy.a_hello.UserMapper.delete", 2);
		s.close();
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession(true);
		User user = new User();
		user.setId(15);
		user.setName("��ɺɺ");
		user.setBirthday(new Date(0));
		user.setMoney(222d);
		s.update("com.woniuxy.a_hello.UserMapper.update", user);
		s.close();
	}
	
	
	@Test
	public void testFindAll() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession(true);
		List<User> list = s.selectList("com.woniuxy.a_hello.UserMapper.findAll");
		for (User user : list) {
			System.out.println(user);
		}
		s.close();
	}
	
	
	@Test
	public void testFindOne() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession(true);
//		List<User> list = s.selectList("com.woniuxy.a_hello.UserMapper.findOne",1);
//		System.out.println(list);
		
		User user = s.selectOne("com.woniuxy.a_hello.UserMapper.findOne",1);
		System.out.println(user);
		s.close();
	}
	
	
}

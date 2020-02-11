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
		// 加载mybatis主配置文件
		// 从App.class字节码所在路径开始寻找mybatis-config.xml
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		// 创建SqlSessionFactory，SqlSessionFactory是专门用来生成 SqlSession的
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		// 获取一个会话，这里的会话，是从连接数据库开始， 到关闭了数据库连接为止。 每一个SqlSession对象中都封装了一个Connection对象
		// 注意，在获取会话的同时，事务已经开启了，这一点和hibernatw不一样！
		SqlSession s = sf.openSession();
		
		// 以下的aa.save，表示
		/*
		 	aa用来查找某一个具体的子配置文件， 要与XXXMapper.xml中的mapper元素的namespace一致
		 	save要与子配置文件中的语句的id一致
		*/
		User user = new User();
		user.setName("张无极");
		user.setBirthday(new Date());
		user.setMoney(333d);
		
		s.insert("com.woniuxy.a_hello.UserMapper.save", user);
		
		// 提交事务，虽然事务是自动开启的，但是提交，还必须手动提交。
		s.commit();
		// 关闭会话，表面上是关闭mybatis的会话，实际上底层是关闭了数据库连接！  
		s.close();
	}
	
	@Test
	public void testDelete() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		// 在通过 sf.openSession();获取会话对象的时候，如果传入了true，则表示事务会在s.close()的时候，自动提交！
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
		user.setName("张珊珊");
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

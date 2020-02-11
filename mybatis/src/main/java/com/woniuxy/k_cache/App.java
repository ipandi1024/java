package com.woniuxy.k_cache;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
	什么是缓存：
		缓存就是一片内存。（map）
	
	缓存的作用：
		让数据更接近于使用者。从而提高程序的性能。  
	
	mybatis中的一级缓存： （重点）
	a. mybatis的一级缓存，是SqlSession级别的缓存。 
		也就是说，只要把SqlSession关闭了，那么一级缓存也就释放了！
		简单来说，一级缓存不能跨会话！！
	b. mybatis的一级缓存其实是SqlSession内部封装的一个HashMap。
	   	既然是map，那必定要存储：键值对，问题是，该map的键值是什么？ 值有是什么？
	   
		键值的组成：
			statementId + rowBounds + 	传递给JDBC的SQL + 传递给JDBC的参数值
			语句id		  rowBounds对象	 sql语句			sql语句的参数
			
		以mapper.find(11);为例，该查询使用的键值是： 
			find + null + “select * from user where id = ?” +  11
			
	c. 执行了close clearCache update delete insert就会清空一级缓存
			
	mybatis的二级缓存
	a. mybatis的二级缓存，是SqlSessionFactory级别的缓存。
	 	也就是说，只要把SqlSessionFactory关闭了，那么二级缓存也就释放了！
		所以二级缓存可以跨会话，毕竟SqlSessionFactory就是用来创建不同的SqlSession，
		也就是说，SqlSessionFactory的生命周期中，有多个SqlSession的生命周期！
		SqlSessionFactory往往与整个应用同生共死，就是在web应用启动的时候，SqlSessionFactory就被创建了
		知道web应用被卸载的时候，SqlSessionFactory才被关闭！
	b. mybatis的二级缓存其实是SqlSessionFactory内部封装的一个HashMap。
		二级缓存的键值组成与一级缓存的键值组成是一样的！ 
	c. mybaits的二级缓存，默认是关闭着的，不会其效果的，而mybatis的一级缓存是开启的（也无法关闭）
	d. 想让二级缓存生效，必须添加配置来开启二级缓存
		1) 在主配置中
			<settings>
				<setting name="cacheEnabled" value="true"/>
			</settings>
		2) 在子配置中
			<cache />
	e. 执行了close clearCache update delete insert就会清空二级缓存
	
	f. 既然二级缓存可以跨会话，那么必然对提升系统性能有更大的帮助，那为什么默认是关闭着的呢？？
	因为二级缓存并不是用的越多就越好。 针对于经常被查询的操作，可以使用二级缓存，针对于经常修改的操作不适合用二级缓存。
*/		

public class App {
	
	// 演示一级缓存不能跨会话
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
		
		
		// 修改
//		User u = new User();
//		u.setId(7);
//		u.setName("刘备");
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
	
	
	// 测试一级缓存底层的map的键值：
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
	
	
	// 测试RowBounds的使用
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
		
		// 清空一级缓存
		// s.clearCache();
		
		// 修改、删除、增加，都会引起一级缓存的清空！！
		User u = new User();
		u.setId(7);
		u.setName("诸葛亮");
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

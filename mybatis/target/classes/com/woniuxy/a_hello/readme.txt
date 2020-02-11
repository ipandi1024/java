1. jdbc hibernate mybatis， 都是用于制作持久层的。

	从运行速度上来比较：
		jdbc > mybatis > hibernate
		
	从开发速度上来比较：
		hibernate > mybatis > jdbc
		
	从流程程度上来比较：
		mybatis > hibernate > jdbc
		
	mybatis为什么会比hibernate流行呢？ 因为现在的应用，大部分都要应对海量用户，要处理高并发。
	
	为了提高应用程序的查询性能，在持久层而言，势必要对sql语句进行优化，而hibernate最大的缺点就是无法直接编写sql语句
	而调优sql语句，必然少不了直接编辑sql语句， 这一点hibernate无法满足！ 所以才使用mybaits框架代替了hibernate
	毕竟在使用mybatis的时候，所有的sql语句，都必须手写，mybatis框架不会自动生成sql语句。
	
	注意，这并不意味着hibernate就过时了，hibernate对于那些访问量不高的应用还是首选！
	
	
	
2. 先把自行车骑起来！
	
	搭建mybatis开发环境
	
	a. 导入依赖（jar包）
	  <dependencies>
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis</artifactId>
		    <version>3.5.2</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.35</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
	  </dependencies>
	  
	b. 创建实体类：
		public class User implements Serializable {
			private Integer id;
			private String name;
			private Date birthday;
			private Double money;
			
			// getter and setter ...
		}
	
	c. 创建mybatis主配置文件
		<?xml version="1.0" encoding="UTF-8" ?>
		<!DOCTYPE configuration
		 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
		 "http://mybatis.org/dtd/mybatis-3-config.dtd">
		<configuration>
			<environments default="development">
				<environment id="development">
					<transactionManager type="JDBC" />
					<dataSource type="POOLED">
						<property name="driver" value="com.mysql.jdbc.Driver" />
						<property name="url" value="jdbc:mysql://localhost:3306/test" />
						<property name="username" value="root" />
						<property name="password" value="123" />
					</dataSource>
				</environment>
			</environments>
			<mappers>
			</mappers>
		</configuration>
	
	d. 创建mybatis子配置文件。
		<?xml version="1.0" encoding="UTF-8" ?>
		<!DOCTYPE mapper
		 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		<mapper namespace="aa">
			<insert id="save">
				insert into user values(null, 'andy', now(), 1000)
			</insert>
		</mapper>
		
	e. 在主配置中，引入子配置文件
		<mappers>
			<!-- 注意，以下路径中使用的是"/"隔开目录，而不是"."  -->
			<mapper resource="com/woniuxy/a_hello/UserMapper.xml"/>
		</mappers>
		
	f. 可以编写测试程序了:
		@Test
		public void test() throws Exception {
			// 加载mybatis主配置文件
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
			s.insert("aa.save");
			
			// 提交事务，虽然事务是自动开启的，但是提交，还必须手动提交。
			s.commit();
			// 关闭会话，表面上是关闭mybatis的会话，实际上底层是关闭了数据库连接！
			s.close();
			
		}

3. 让mybatis也能显示sql语句。
	a. 导入log4j依赖
	
	b. 添加log4j的配置文件： log4j.properties
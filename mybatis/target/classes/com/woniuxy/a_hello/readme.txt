1. jdbc hibernate mybatis�� �������������־ò�ġ�

	�������ٶ������Ƚϣ�
		jdbc > mybatis > hibernate
		
	�ӿ����ٶ������Ƚϣ�
		hibernate > mybatis > jdbc
		
	�����̶̳������Ƚϣ�
		mybatis > hibernate > jdbc
		
	mybatisΪʲô���hibernate�����أ� ��Ϊ���ڵ�Ӧ�ã��󲿷ֶ�ҪӦ�Ժ����û���Ҫ����߲�����
	
	Ϊ�����Ӧ�ó���Ĳ�ѯ���ܣ��ڳ־ò���ԣ��Ʊ�Ҫ��sql�������Ż�����hibernate����ȱ������޷�ֱ�ӱ�дsql���
	������sql��䣬��Ȼ�ٲ���ֱ�ӱ༭sql��䣬 ��һ��hibernate�޷����㣡 ���Բ�ʹ��mybaits��ܴ�����hibernate
	�Ͼ���ʹ��mybatis��ʱ�����е�sql��䣬��������д��mybatis��ܲ����Զ�����sql��䡣
	
	ע�⣬�Ⲣ����ζ��hibernate�͹�ʱ�ˣ�hibernate������Щ���������ߵ�Ӧ�û�����ѡ��
	
	
	
2. �Ȱ����г���������
	
	�mybatis��������
	
	a. ����������jar����
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
	  
	b. ����ʵ���ࣺ
		public class User implements Serializable {
			private Integer id;
			private String name;
			private Date birthday;
			private Double money;
			
			// getter and setter ...
		}
	
	c. ����mybatis�������ļ�
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
	
	d. ����mybatis�������ļ���
		<?xml version="1.0" encoding="UTF-8" ?>
		<!DOCTYPE mapper
		 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		<mapper namespace="aa">
			<insert id="save">
				insert into user values(null, 'andy', now(), 1000)
			</insert>
		</mapper>
		
	e. ���������У������������ļ�
		<mappers>
			<!-- ע�⣬����·����ʹ�õ���"/"����Ŀ¼��������"."  -->
			<mapper resource="com/woniuxy/a_hello/UserMapper.xml"/>
		</mappers>
		
	f. ���Ա�д���Գ�����:
		@Test
		public void test() throws Exception {
			// ����mybatis�������ļ�
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
			s.insert("aa.save");
			
			// �ύ������Ȼ�������Զ������ģ������ύ���������ֶ��ύ��
			s.commit();
			// �رջỰ���������ǹر�mybatis�ĻỰ��ʵ���ϵײ��ǹر������ݿ����ӣ�
			s.close();
			
		}

3. ��mybatisҲ����ʾsql��䡣
	a. ����log4j����
	
	b. ���log4j�������ļ��� log4j.properties
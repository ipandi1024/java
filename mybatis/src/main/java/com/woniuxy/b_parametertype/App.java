package com.woniuxy.b_parametertype;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class App {
	@Test
	public void test() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession(true);
		
		User user = new User();
		user.setName("¡ı±∏");
		user.setBirthday(new Date());
		user.setMoney(333d);
		s.insert("com.woniuxy.b_parametertype.UserMapper.save", user);
		
//		Foo f = new Foo();
//		f.setName("≤‹’√");
//		f.setBirthday(new Date());
//		f.setMoney(400d);
//		s.insert("com.woniuxy.b_parametertype.UserMapper.save", f);
		
//		Map map = new HashMap();	
//		map.put("name", "≤‹À¨");
//		map.put("birthday", new Date());
//		map.put("money", 500d);
//		s.insert("com.woniuxy.b_parametertype.UserMapper.save", map);
		
		s.close();
		
	}
}

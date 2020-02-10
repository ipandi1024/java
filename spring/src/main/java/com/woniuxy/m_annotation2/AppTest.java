package com.woniuxy.m_annotation2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/m_annotation2/applicationContext.xml");
		
		User u = (User) ctx.getBean("user");
		System.out.println(u);
		System.out.println(u.getCar());
		
	}
}

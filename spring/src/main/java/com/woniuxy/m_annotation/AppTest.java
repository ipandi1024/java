package com.woniuxy.m_annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/m_annotation/applicationContext.xml");
		
//		String[] names = ctx.getBeanDefinitionNames();
//		for (String name : names) {
//			System.out.println(name);
//		}
		
		User u = (User) ctx.getBean("user");
		System.out.println(u);
		
		
		
		
	}
}

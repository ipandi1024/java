package com.woniuxy.l_autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/l_autowire/applicationContext.xml");
		
		User u = (User) ctx.getBean("u");
		
		System.out.println(u);
		
		System.out.println(u.getCar());
		
	}
}

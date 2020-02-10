package com.woniuxy.j_scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/j_scope/applicationContext.xml");
		
		User u = (User) ctx.getBean("u");
		User u2 = (User) ctx.getBean("u");
		User u3 = (User) ctx.getBean("u");
		
		System.out.println(u == u2);
		System.out.println(u == u3);
		
		System.out.println("over");
		
		User u4 = (User) ctx.getBean("com.woniuxy.j_scope.User#0");
		System.out.println(u4);
		
		User u5 = (User) ctx.getBean("com.woniuxy.j_scope.User#1");
		System.out.println(u5);
		
		
		User u6 = ctx.getBean(User.class);
		System.out.println(u6);
		
		
		
	}
}

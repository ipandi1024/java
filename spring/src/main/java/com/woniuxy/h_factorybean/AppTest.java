package com.woniuxy.h_factorybean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/h_factorybean/applicationContext.xml");
		
		User u = (User) ctx.getBean("u");
		Object obj =  ctx.getBean("uf");
		
		System.out.println(u);
		System.out.println(obj + " " + obj.getClass());
		
		
		Class<?> clazz = ctx.getType("u");
		System.out.println(clazz + "~~~~~~~~~~~~");
		
		Class<?> clazz2 = ctx.getType("uf");
		System.out.println(clazz2 + "~~~~~~~~~~~~");
		
		
		Object obj2 =  ctx.getBean("uf");
		Object obj3 =  ctx.getBean("uf");
		
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println(obj2 == obj3);
		
		
		
	}
}

package com.woniuxy.k_di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/k_di/applicationContext.xml");
		
		User u = (User) ctx.getBean("u5");
		System.out.println(u);
		System.out.println(u.getCar());
		
//		Car c = (Car) ctx.getBean("c10");
//		
//		System.out.println(c.getColor() == null);
		
		
		
	}
}

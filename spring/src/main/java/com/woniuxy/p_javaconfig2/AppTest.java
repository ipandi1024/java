package com.woniuxy.p_javaconfig2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {
	
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new AnnotationConfigApplicationContext(RootConfig.class);
		
		User u = (User) ctx.getBean("user");
		
		System.out.println(u);
		System.out.println(u.getCar());
		
	}
}

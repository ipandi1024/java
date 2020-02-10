package com.woniuxy.i_createbean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/i_createbean/applicationContext.xml");
		
		
		Object obj =  ctx.getBean("u");
		Object obj2 = ctx.getBean("u2");
		Object obj3 = ctx.getBean("u3");
		
		System.out.println(obj);
		System.out.println(obj2);
		System.out.println(obj3);
		
		System.out.println(obj.getClass());
		System.out.println(obj2.getClass());
		System.out.println(obj3.getClass());
	}
}

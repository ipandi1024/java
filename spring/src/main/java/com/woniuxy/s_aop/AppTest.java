package com.woniuxy.s_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/s_aop/applicationContext.xml");
		
		ICalc c = (ICalc) ctx.getBean("calcImpl");
		
		
		System.out.println(c.getClass());
		
		
		
		c.add(1, 2);
		
	}
}

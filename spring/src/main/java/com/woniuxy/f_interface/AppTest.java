package com.woniuxy.f_interface;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/f_interface/applicationContext.xml");
		
		Toy t =  (Toy) ctx.getBean("t");  
		
		t.play();
		
	}
}
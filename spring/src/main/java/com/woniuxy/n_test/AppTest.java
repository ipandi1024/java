package com.woniuxy.n_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 Ϊ��ʹ��spring�Ĳ���ģ�飬��Ҫ����һ��������spring-test
*/

// @RunWith���Ǹ���spring��ܣ��ɿ��������������spring��ioc����
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "applicationContext.xml")
public class AppTest {
	
	@Autowired
	private User user;
	
	@Autowired
	private Car car;
	
	@Test
	public void test() throws Exception {
		
		System.out.println(user);
		
		System.out.println(car);
		
	}
}

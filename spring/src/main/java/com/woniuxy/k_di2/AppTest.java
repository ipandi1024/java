package com.woniuxy.k_di2;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/k_di2/applicationContext.xml");
		
		Foo f = (Foo) ctx.getBean("f3");
		
		List list = f.getList();
		
		for (Object object : list) {
			System.out.println(object);
			
		}
		
//		Set set = f.getSet();
//		for (Object object : set) {
//			System.out.println(object);
//		}
		
		
//		Map map = f.getMap();
//		Set set = map.entrySet();
//		for (Object object : set) { 
//			System.out.println(object);
//		}
		
//		String[] strs = f.getStrs();
//		
//		for (String str : strs) {
//			System.out.println(str);
//		}
		
//		Properties props = f.getProps();
//		
//		Set set = props.entrySet();
//		
//		for (Object object : set) {
//			System.out.println(object);
//		}
	}
}

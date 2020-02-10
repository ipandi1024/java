package com.woniuxy.e_hello;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class AppTest {
	@Test
	public void test() throws Exception {

		// ����spring���������ļ������������ļ������ݶ����ص��ڴ�Ķ����У� Resource r��
		Resource r = new ClassPathResource("com/woniuxy/e_hello/applicationContext.xml");
		// �����Ѿ����������õ�r����������һ��������
		// ������ʲô����������һ����ͬ�����ã����ǰѾ����Ʒ���������ӿͻ��˴����н��
		// �ÿͻ��˴��������֪�������Ʒ��������
		BeanFactory bf = new XmlBeanFactory(r);

		// ������Ȼ�����˾��������������ӦΪ�����ǻ�û�����������Ʒ��ֻ���þ����Ʒ�����������ܽ���ˡ�
		User user = (User) bf.getBean("u");

		System.out.println(user);
	}

	// BeanFactory��ʵ�ʿ����У�������ʹ�ã�����ʹ�õ���ApplicationContext�����������

	@Test
	public void test2() throws Exception {
		

		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/e_hello/applicationContext.xml");
		User user = (User) ctx.getBean("u");
		User user2 = (User) ctx.getBean("u");  
		
		System.out.println(user);
		System.out.println(user2);
		
		System.out.println(user == user2);
		
		System.out.println("over");
	}
	
	// ApplicationContext��BeanFactory���ӽӿڣ� ����ApplicationContext�Ĺ��ܸ����ǿ�󣡣�
	
	
	// ���Ʒ�ת��
	// ��ǰ������Ҫ�Լ�ʵ��������Ȼ����ʹ�á� ��������Spring��ioc������ʵ��������Ĺ������������������
	// ��������Ҫʹ��ĳ�������ʱ��ֱ��������Ҫ���ɣ���
	
	// ��ô�����Ǻ�ʱʵ����������أ�  �����ڴ���spring ioc������ʱ���������Ѿ������õ�beanͳͳʵ���������ˣ�
	
	
}
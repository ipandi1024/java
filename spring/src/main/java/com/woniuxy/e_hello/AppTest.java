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

		// 加载spring的主配置文件，把主配置文件的内容都加载到内存的对象中： Resource r。
		Resource r = new ClassPathResource("com/woniuxy/e_hello/applicationContext.xml");
		// 根据已经加载了配置的r对象，来创建一个工厂。
		// 无论是什么工厂，都有一个共同的作用：就是把具体产品的类名，从客户端代码中解耦。
		// 让客户端代码根本不知道具体产品的类名。
		BeanFactory bf = new XmlBeanFactory(r);

		// 这里仍然出现了具体的类名，那是应为，我们还没有制作抽象产品，只能用具体产品的类名来接受结果了。
		User user = (User) bf.getBean("u");

		System.out.println(user);
	}

	// BeanFactory在实际开发中，几乎不使用，经常使用的是ApplicationContext这个容器！！

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
	
	// ApplicationContext是BeanFactory的子接口， 所以ApplicationContext的功能更多更强大！！
	
	
	// 控制反转：
	// 以前我们需要自己实例化对象，然后再使用。 现在有了Spring的ioc容器，实例化对象的工作就由容器来完成了
	// 当我们需要使用某个对象的时候，直接向容器要即可！！
	
	// 那么容器是何时实例化对象的呢？  就是在创建spring ioc容器的时候，容器就已经把配置的bean统统实例化出来了！
	
	
}
package com.woniuxy.g_beanlife;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 bean的生命周期：
 1. 当在程序中创建spring ioc容器的时候， spring ioc容器就会去加载spring的主配置文件。（利用ClassPathXmlApplicationContext构造器加载）
 2. 当spring ioc容器在加载spring主配置的时候，就会发现bean的配置
 3. 当spring ioc容器发现一bean的时候，就调用该bean的无参构造器。 也就是实例化。（这就要求，bean所属的类必须有一个无参构造器）
 4. 当spring ioc容器实例化完一个bean之后，就会填充属性，也就是调用对象的setter方法。
 5. 当spring ioc容器设置完属性之后，就会判断bean所属的类，是否实现了BeanNameAware接口
 		如果实现了BeanNameAware接口，就会调用该结构的setBeanName方法
 		如果没实现BeanNameAware接口，就直接进入下一步
 6. 判断bean所属的类，有没有实现BeanFactoryAware接口
 		如果实现了BeanFactoryAware接口，就会调用该接口的setBeanFactory方法
 		如果没实现BeanFactoryAware接口，就直接进入下一步
 7. 判断bean所属的类，有没有实现ApplicationContextAware接口
 	 	如果实现了ApplicationContextAware接口，就会调用该结构的setApplicationContex方法
 		如果没实现ApplicationContextAware接口，就直接进入下一步
 8. 判断其他bean是否实现了BeanPostProcessor接口
 		如果其他bean实现了BeanPostProcessor接口，就会调用其他bean的 postProcessBeforeInitialization 方法 （注意，spring ioc容器还必须管理这个所谓的“其他bean”）
 		如果没实现BeanPostProcessor接口，就直接进入下一步
 9. 判断bean所属的类，是否实现了InitializingBean接口
 		如果实现了InitializingBean接口，就会调用该街欧酷的afterPropertiesSet方法
 		如果没实现InitializingBean接口，就直接进入下一步
 10. 判断在spring的主配置文件中，是否在bean元素上配置了init-method属性
 		如果配置了，则调用init-method属性所指定的方法
 		如果没配置，就直接进入下一步
 11. 判断其他bean是否实现了BeanPostProcessor接口
 		如果其他bean实现了BeanPostProcessor接口，就会调用其他bean的 postProcessAfterInitialization 方法 （注意，spring ioc容器还必须管理这个所谓的“其他bean”）
 		如果没实现BeanPostProcessor接口，就直接进入下一步
 		
 12. 此时，bean已经进入spring ioc容器中了， 客户端就可以从spring ioc容器中获取bean，bean就可以使用了！！！
 
 13. 当我们关闭Spring ioc容器的时候， 判断bean所属的类，是否实现了DisposableBean接口
 		如果实现了DisposableBean接口，就会调用该街欧酷的destroy方法
 		如果没实现DisposableBean接口，就直接进入下一步
 14. 当我们关闭Spring ioc容器的时候，spring ioc还会判断bean的配置中，是否配置了destroy-method方法
 		如果配置了，则调用destroy-method属性所指定的方法
 		如果没配置，就完了。
*/

public class AppTest {
	@Test
	public void test() throws Exception {
		ClassPathXmlApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/g_beanlife/applicationContext.xml");
		
//		Resource r = new ClassPathResource("com/woniuxy/g_beanlife/applicationContext.xml");
//		XmlBeanFactory bf = new XmlBeanFactory(r);
//		System.out.println("=================================");
//		Foo f  = (Foo) bf.getBean("f");
//		bf.addBeanPostProcessor(f);
//		bf.getBean("u");
		
		Object u  =  ctx.getBean("u");
		System.out.println(u.getClass());
//		u.eat();
		
//		ctx.close();
	}
}

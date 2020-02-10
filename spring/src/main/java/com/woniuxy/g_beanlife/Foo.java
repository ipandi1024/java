package com.woniuxy.g_beanlife;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class Foo implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
//		User u = (User) bean;
//		
//		// 判断bean是否实现了某个接口
//		if(bean instanceof Namable) {
//			u.setName("花木兰");
//		}
//		
//		System.out.println("before: " + beanName + ", " + bean);
//		
//		
//		// 为目标对象，制作代理对象
		Object proxy = Proxy.newProxyInstance(Foo.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("剥个蒜");
				Object r = method.invoke(bean, args);
				System.out.println("漱个口，咽下去！");
				return r;
			}
		});
		
		
		return proxy;  // 如果这里返回null，则生命周期立即“戛然而止”
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after: " + beanName + ", " + bean);
		
		// after方法所返回的对象，就会直接进入spring的ioc容器中！！
		return bean;
	}
}

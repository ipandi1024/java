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
//		// �ж�bean�Ƿ�ʵ����ĳ���ӿ�
//		if(bean instanceof Namable) {
//			u.setName("��ľ��");
//		}
//		
//		System.out.println("before: " + beanName + ", " + bean);
//		
//		
//		// ΪĿ����������������
		Object proxy = Proxy.newProxyInstance(Foo.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("������");
				Object r = method.invoke(bean, args);
				System.out.println("�����ڣ�����ȥ��");
				return r;
			}
		});
		
		
		return proxy;  // ������ﷵ��null�������������������Ȼ��ֹ��
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after: " + beanName + ", " + bean);
		
		// after���������صĶ��󣬾ͻ�ֱ�ӽ���spring��ioc�����У���
		return bean;
	}
}

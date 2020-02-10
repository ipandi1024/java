package com.woniuxy.g_beanlife;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class User implements Serializable, BeanNameAware,BeanFactoryAware,ApplicationContextAware,
	InitializingBean, DisposableBean, Namable {
	private Integer id;
	private String name;
	
	public User() {
		System.out.println("User.User()");
	}
	
	public void abc() {
		System.out.println("User.abc()");
	}
	public void xyz() {
		System.out.println("User.xyz()");
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("User.setName()");
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("User.setBeanName():" + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		
		User u = (User) beanFactory.getBean("u");
		
		System.out.println("User.setBeanFactory():" + u);
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		User u = (User) ctx.getBean("u");
		
		System.out.println("User.setApplicationContext():" + u);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("User.afterPropertiesSet()");
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("User.destroy()");
	}
	
	public void eat() {
		System.out.println("≥‘”Õ∆√√Ê...");
	}
	
}

package com.woniuxy.m_annotation2;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class User implements Serializable {
	@Value("11")
	private Integer id;
	@Value("张杰")
	private String name;

	/*
	 @Autowired表示自动装配，按照类型自动装配
	 1. 按照类型找到1个，就装配成功
	 2. 按照类型找到多个，就转而按照名称装配！
	 		a. 如果找到1个，就装配成功
	 		b. 如果找不到，就报错。
	 		c. 如果找到多个，只可能是：一个在xml中，另一个是扫包扫出来的，优先使用xml中
	 3. 按照类型找不到
	 		如果@Autowired的required属性取值为ture，就报错！
	 		如果@Autowired的required属性取值为false，就不报错，而是使用默认值
	@Autowired(required = false)
	*/

	/*
	 	@Reource 直接按照名称装配
	 	1. 按照名称找到一个, 就装配工程
	 	2. 按照名称找到多个, 只可能是：一个在xml中，另一个是扫包扫出来的，优先使用xml中
	 	3. 按照名称找不到, 就转而按照类型找
	 		a. 找到一个，就装配陈宫
	 		b. 找到多个，就报错
	 		c. 找不到，就报错
	*/
	@Resource  
	private Car car;
	
	public User() {
	}
	
	public User(Integer id, String name) {
		System.out.println("User.User(Integer, String)");
		this.id = id;
		this.name = name;
	}
	
	

	public User(Integer id, String name, Car car) {
		System.out.println("User.User(Integer, String, Car)");
		this.id = id;
		this.name = name;
		this.car = car;
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
		this.name = name;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}

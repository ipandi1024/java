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
	@Value("�Ž�")
	private String name;

	/*
	 @Autowired��ʾ�Զ�װ�䣬���������Զ�װ��
	 1. ���������ҵ�1������װ��ɹ�
	 2. ���������ҵ��������ת����������װ�䣡
	 		a. ����ҵ�1������װ��ɹ�
	 		b. ����Ҳ������ͱ���
	 		c. ����ҵ������ֻ�����ǣ�һ����xml�У���һ����ɨ��ɨ�����ģ�����ʹ��xml��
	 3. ���������Ҳ���
	 		���@Autowired��required����ȡֵΪture���ͱ���
	 		���@Autowired��required����ȡֵΪfalse���Ͳ���������ʹ��Ĭ��ֵ
	@Autowired(required = false)
	*/

	/*
	 	@Reource ֱ�Ӱ�������װ��
	 	1. ���������ҵ�һ��, ��װ�乤��
	 	2. ���������ҵ����, ֻ�����ǣ�һ����xml�У���һ����ɨ��ɨ�����ģ�����ʹ��xml��
	 	3. ���������Ҳ���, ��ת������������
	 		a. �ҵ�һ������װ��¹�
	 		b. �ҵ�������ͱ���
	 		c. �Ҳ������ͱ���
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

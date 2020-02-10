package com.woniuxy.p_javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// ֻҪ��һ���������������@Configurationע�⣬����Ͳ�����һ����ͨ���ˣ�����һ���������ļ�����
// �����ļ�����ֻ����xml�� ���ǵģ��� ��spring4�У������һ���µ����������һ��java������Ϊspring���������ļ��ģ�

// ��ô���µ�����࣬����һ���߱�java���������ļ�����Ȼ�������Ҳ�������ļ�����ô֮ǰxml�����ļ������������飬�����Ҳ��������

@Configuration
public class RootConfig {
	/*
	 <bean id="u" class="com.woniuxy.p_javaconfig.User">
	 	<property name="id" value="22" />
	 	<property name="name" value="����" />
	 </bean>
	*/
	@Bean
	public User u() {
		User u = new User();
		u.setId(22);
		u.setName("����");
		return u;
	}
	
	/*
	<bean id="u2" class="com.woniuxy.p_javaconfig.User" scope="prototype">
		<property name="id" value="33" />
		<property name="name" value="����" />
	</bean>
	*/
	@Bean
	@Scope("prototype")
	public User u2() {
		User u = new User();
		u.setId(33);
		u.setName("����");
		return u;
	}
	
	/*
	 	<bean id="c3" class="com.woniuxy.p_javaconfig.Car">
	 		<property name="brand" value="����" />
			<property name="color" value="��ɫ" />
	 	</bean>
		<bean id="u3" class="com.woniuxy.p_javaconfig.User">
			<property name="id" value="44" />
			<property name="name" value="����ǿ" />
			<property name="car" ref="c3" />
		</bean>
	*/
	@Bean
	public Car c3() {
		Car c = new Car();
		c.setBrand("����");
		c.setColor("��ɫ");
		return c;
	}
	
	@Bean
	public User u3() {
		User u = new User();
		u.setId(44);
		u.setName("����ǿ");
		u.setCar(c3());
		return u;
	}
	
	
	/*
	 	<bean id="c4" class="com.woniuxy.p_javaconfig.Car">
	 		<property name="brand" value="����" />
			<property name="color" value="��ɫ" />
	 	</bean>
		<bean id="u4" class="com.woniuxy.p_javaconfig.User" autowire="byName">
			<property name="id" value="55" />
			<property name="name" value="������" />
		</bean>
	 */
	@Bean
	public Car c4() {
		Car c = new Car();
		c.setBrand("����");
		c.setColor("��ɫ");
		return c;
	}
	
	@Bean
	public User u4(Car car) {   // ֻҪд���������͵�ͬ��xml�е��Զ�װ�䡣
		User u = new User();
		u.setId(55);
		u.setName("������");
		u.setCar(car);
		return u;
	}
	
}

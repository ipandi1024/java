package com.woniuxy.p_javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// 只要在一个类上上面加上了@Configuration注解，该类就不再是一个普通类了，而是一个“配置文件”。
// 配置文件不是只能是xml吗？ 不是的！！ 在spring4中，提出了一种新的理念，就是以一个java类来作为spring的主配置文件的！

// 那么以下的这个类，就是一个具备java语句的配置文件！既然下面的类也是配置文件，那么之前xml配置文件能做到的事情，这个类也能做到！

@Configuration
public class RootConfig {
	/*
	 <bean id="u" class="com.woniuxy.p_javaconfig.User">
	 	<property name="id" value="22" />
	 	<property name="name" value="哈哈" />
	 </bean>
	*/
	@Bean
	public User u() {
		User u = new User();
		u.setId(22);
		u.setName("哈哈");
		return u;
	}
	
	/*
	<bean id="u2" class="com.woniuxy.p_javaconfig.User" scope="prototype">
		<property name="id" value="33" />
		<property name="name" value="嘻嘻" />
	</bean>
	*/
	@Bean
	@Scope("prototype")
	public User u2() {
		User u = new User();
		u.setId(33);
		u.setName("嘻嘻");
		return u;
	}
	
	/*
	 	<bean id="c3" class="com.woniuxy.p_javaconfig.Car">
	 		<property name="brand" value="奥拓" />
			<property name="color" value="绿色" />
	 	</bean>
		<bean id="u3" class="com.woniuxy.p_javaconfig.User">
			<property name="id" value="44" />
			<property name="name" value="王宝强" />
			<property name="car" ref="c3" />
		</bean>
	*/
	@Bean
	public Car c3() {
		Car c = new Car();
		c.setBrand("奥拓");
		c.setColor("绿色");
		return c;
	}
	
	@Bean
	public User u3() {
		User u = new User();
		u.setId(44);
		u.setName("王宝强");
		u.setCar(c3());
		return u;
	}
	
	
	/*
	 	<bean id="c4" class="com.woniuxy.p_javaconfig.Car">
	 		<property name="brand" value="奥妙" />
			<property name="color" value="红色" />
	 	</bean>
		<bean id="u4" class="com.woniuxy.p_javaconfig.User" autowire="byName">
			<property name="id" value="55" />
			<property name="name" value="贾乃亮" />
		</bean>
	 */
	@Bean
	public Car c4() {
		Car c = new Car();
		c.setBrand("奥妙");
		c.setColor("红色");
		return c;
	}
	
	@Bean
	public User u4(Car car) {   // 只要写出参数，就等同于xml中的自动装配。
		User u = new User();
		u.setId(55);
		u.setName("贾乃亮");
		u.setCar(car);
		return u;
	}
	
}

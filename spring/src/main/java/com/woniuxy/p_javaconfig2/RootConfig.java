package com.woniuxy.p_javaconfig2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 <context:component-scan basePackages="com.woniuxy.p_javaconfig2" />
*/
@Configuration
@ComponentScan(basePackages = "com.woniuxy.p_javaconfig2")
public class RootConfig {
	
	@Bean
	public Car c() {
		Car c = new Car();
		c.setBrand("°ÂÃØ");
		c.setColor("ºÚÉ«");
		return c;
	}
	
}

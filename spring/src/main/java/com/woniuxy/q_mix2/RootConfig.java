package com.woniuxy.q_mix2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
	
	@Bean
	public User u2() {
		User u = new User();
		u.setId(100);
		u.setName("��ʮ��");
		return u;
	}
	
	@Bean
	public Car c() {
		Car c = new Car();
		c.setBrand("�ɻ�");
		c.setColor("��ɫ");
		return c;
	}

}

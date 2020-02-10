package com.woniuxy.q_mix4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public User u() {
		User u = new User();
		u.setId(666);
		u.setName("ÍõÕÑ¾ý");
		return u;
	}
	
}

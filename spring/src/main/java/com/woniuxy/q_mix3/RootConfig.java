package com.woniuxy.q_mix3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("com/woniuxy/q_mix3/applicationContext.xml")
public class RootConfig {
	
	@Bean
	public User u2() {
		User u = new User();
		u.setId(100);
		u.setName("Î÷Ê©");
		return u;
	}

}

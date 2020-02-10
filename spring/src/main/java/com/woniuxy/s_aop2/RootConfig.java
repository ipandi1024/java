package com.woniuxy.s_aop2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy  // <aop:aspectj-autoproxy />
public class RootConfig {
	
	@Bean
	public ICalc c() {
		return new CalcImpl();
	}
	
	@Bean
	public ICalc c2() {
		return new CalcImpl();
	}
	
}

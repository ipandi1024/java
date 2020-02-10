package com.woniuxy.s_aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class A {
	
	@Before("execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))")
	public void f1() {
		System.out.println("f1...");
	}
	
	@After("execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))")
	public void f2() {
		System.out.println("f2...");
	}
}

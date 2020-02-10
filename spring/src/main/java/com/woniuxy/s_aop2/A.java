package com.woniuxy.s_aop2;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 	以下代码就是4个通知的底层实现：
 	
 	1. 4个通知中，一定会执行到的是： 前置和后置。
 	2. 4个通知中，有2个通知不会同时出现，也不会同时不出现： 返回通知和异常通知。 
 	3. 4个通知中，只有返回通知才能获取到目标方法的返回值
 	4. 4个通知中，只有异常通知才能获取到目标方法抛出的异常
 	
 
 	try {
 		// 前置通知
 		Object r = method.invoke(target, args);
 		// 返回通知
 		return r;
 	} catch(Exception e) {
 		// 异常通知
 	} finally {
 		// 后置通知
 	} 
*/

@Component
@Aspect
public class A {

	@Pointcut("execution(public int com.woniuxy.s_aop2.CalcImpl.sub(..))")
	public void abc() {
	}
	
	
	@Before("abc()")
	public void before(JoinPoint jp) {
		
		// 获取到本次所拦截的方法的方法签名
		Signature s = jp.getSignature();
		System.out.println("前置通知:" + s.getName() + Arrays.toString(jp.getArgs())); 
		
	}
	
	@AfterReturning(value = "abc()", returning = "r")
	public void afterReturning(Object r) {
		System.out.println("返回通知:  " + r);
	}
	
	@AfterThrowing(value = "abc()", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("异常通知: " + ex);
	}
	
	@After("abc()")
	public void after() {
		System.out.println("后置通知");
	}
	
}



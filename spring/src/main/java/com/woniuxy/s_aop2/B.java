package com.woniuxy.s_aop2;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class B {

	/*
	 @Around是环绕通知，
	 	该通知必须有一个参数： ProceedingJoinPoint（连接点）
	 	该通知必须有返回值： Object
	*/
//	@Around("execution(* com.woniuxy.s_aop2.CalcImpl.add(int, int)) "
//			+ " or execution(* com.woniuxy.s_aop2.CalcImpl.sub(int, int)) ")
	
//	@Around("execution(* com.woniuxy.s_aop2.CalcImpl.add(int, int)) and bean(c)")
	
	@Around("execution(* com.woniuxy.s_aop2.CalcImpl.add(int, int)) and args(x,y)")
	public Object around(ProceedingJoinPoint pjp, int x, int y) {
		try {
			System.out.println("前置通知B:" + x + "," + y + ", " + Arrays.toString(pjp.getArgs()));
			//调用目标方法
			Object r = 1;
			r = pjp.proceed();
			System.out.println("返回通知B: " + r);
			return r;  
		} catch (Throwable e) {
			System.out.println("异常通知B: " + e);
			throw new RuntimeException(e);
		} finally { 
			System.out.println("后置通知B");
		}
		
	}
	
}

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
 	���´������4��֪ͨ�ĵײ�ʵ�֣�
 	
 	1. 4��֪ͨ�У�һ����ִ�е����ǣ� ǰ�úͺ��á�
 	2. 4��֪ͨ�У���2��֪ͨ����ͬʱ���֣�Ҳ����ͬʱ�����֣� ����֪ͨ���쳣֪ͨ�� 
 	3. 4��֪ͨ�У�ֻ�з���֪ͨ���ܻ�ȡ��Ŀ�귽���ķ���ֵ
 	4. 4��֪ͨ�У�ֻ���쳣֪ͨ���ܻ�ȡ��Ŀ�귽���׳����쳣
 	
 
 	try {
 		// ǰ��֪ͨ
 		Object r = method.invoke(target, args);
 		// ����֪ͨ
 		return r;
 	} catch(Exception e) {
 		// �쳣֪ͨ
 	} finally {
 		// ����֪ͨ
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
		
		// ��ȡ�����������صķ����ķ���ǩ��
		Signature s = jp.getSignature();
		System.out.println("ǰ��֪ͨ:" + s.getName() + Arrays.toString(jp.getArgs())); 
		
	}
	
	@AfterReturning(value = "abc()", returning = "r")
	public void afterReturning(Object r) {
		System.out.println("����֪ͨ:  " + r);
	}
	
	@AfterThrowing(value = "abc()", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("�쳣֪ͨ: " + ex);
	}
	
	@After("abc()")
	public void after() {
		System.out.println("����֪ͨ");
	}
	
}



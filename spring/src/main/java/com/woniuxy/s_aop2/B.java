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
	 @Around�ǻ���֪ͨ��
	 	��֪ͨ������һ�������� ProceedingJoinPoint�����ӵ㣩
	 	��֪ͨ�����з���ֵ�� Object
	*/
//	@Around("execution(* com.woniuxy.s_aop2.CalcImpl.add(int, int)) "
//			+ " or execution(* com.woniuxy.s_aop2.CalcImpl.sub(int, int)) ")
	
//	@Around("execution(* com.woniuxy.s_aop2.CalcImpl.add(int, int)) and bean(c)")
	
	@Around("execution(* com.woniuxy.s_aop2.CalcImpl.add(int, int)) and args(x,y)")
	public Object around(ProceedingJoinPoint pjp, int x, int y) {
		try {
			System.out.println("ǰ��֪ͨB:" + x + "," + y + ", " + Arrays.toString(pjp.getArgs()));
			//����Ŀ�귽��
			Object r = 1;
			r = pjp.proceed();
			System.out.println("����֪ͨB: " + r);
			return r;  
		} catch (Throwable e) {
			System.out.println("�쳣֪ͨB: " + e);
			throw new RuntimeException(e);
		} finally { 
			System.out.println("����֪ͨB");
		}
		
	}
	
}

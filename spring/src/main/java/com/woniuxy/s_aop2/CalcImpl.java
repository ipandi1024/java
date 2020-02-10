package com.woniuxy.s_aop2;

public class CalcImpl implements ICalc {

	@Override
	public int add(int a, int b) {
		int r = a + b;
		System.out.println("CalcImpl.add()");
		return r;
	}

	@Override
	public int sub(int a, int b) {
		int r = a - b;
		System.out.println("CalcImpl.sub()");
		return r;
	}

	@Override
	public int div(int a, int b) {
		int r = a / b;
		System.out.println("CalcImpl.div()");
		return r;
	}

	@Override
	public double cube(int a) {
		int r = a * a * a;
		System.out.println("CalcImpl.cube()");
		return r;
	}

	@Override
	public double sqrt(int a) {
		double r = Math.sqrt(a);
		System.out.println("CalcImpl.sqrt()");
		return r;
	}
	
}

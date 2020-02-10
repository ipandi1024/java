package com.woniuxy.t_xmlaop;

public class CalcImpl implements ICalc {

	public int add(int a, int b) {
		int r = a + b;
		System.out.println("CalcImpl.add()");
		return r;
	}

	public int sub(int a, int b) {
		int r = a - b;
		System.out.println("CalcImpl.sub()");
		return r;
	}

	public int div(int a, int b) {
		int r = a / b;
		System.out.println("CalcImpl.div()");
		return r;
	}

	public double cube(int a) {
		int r = a * a * a;
		System.out.println("CalcImpl.cube()");
		return r;
	}

	public double sqrt(int a) {
		double r = Math.sqrt(a);
		System.out.println("CalcImpl.sqrt()");
		return r;
	}
	
}

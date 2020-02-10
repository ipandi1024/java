package com.woniuxy.r_noaop;

/*
 客户改变需求，要求加入日志。 参数校验....
 这样势必要在每一个方法中写出代码！ 这样会导致代码急剧膨胀
*/

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
}

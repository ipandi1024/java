package com.woniuxy.r_noaop;

/*
 �ͻ��ı�����Ҫ�������־�� ����У��....
 �����Ʊ�Ҫ��ÿһ��������д�����룡 �����ᵼ�´��뼱������
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

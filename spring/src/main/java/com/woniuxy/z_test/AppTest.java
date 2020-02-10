package com.woniuxy.z_test;

import static org.junit.Assert.*;

import org.junit.Test;

interface Vampire {
	void drinkblood();
}

interface Monster {
	void destroy();
}

class Dracula implements Vampire, Monster {
	
	@Override
	public void destroy() {
		System.out.println("���ƻ���");
	}
	
	@Override
	public void drinkblood() {
		System.out.println("��ϴ��ϴ��������");
	}
}

public class AppTest {
	@Test
	public void test() throws Exception {
		Dracula d = new Dracula();
		d.drinkblood();
		d.destroy();
	}
}
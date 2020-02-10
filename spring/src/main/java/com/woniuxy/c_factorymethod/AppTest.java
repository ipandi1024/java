package com.woniuxy.c_factorymethod;

import java.awt.peer.FramePeer;

import org.junit.Test;

/*
��������
*/
interface Food {
	void eat();
}
class Hamburgerabc implements Food {
	public void eat() {
		System.out.println("����������ֵ��ӵ�У�");
	}
}
class FrenchFired implements Food {
	@Override
	public void eat() {
		System.out.println("��������������͸��������");
	}
}


interface FoodFactory {
	Food getFood();
}	
class HamburgerFactory implements FoodFactory {
	@Override
	public Food getFood() {
		return new Hamburgerabc();
	}
}
class FrenchFiredFactory implements FoodFactory {
	@Override
	public Food getFood() {
		return new FrenchFired();
	}
}

interface Drink {
	void drink();
}
class Cola implements Drink {
	@Override
	public void drink() {
		System.out.println("���¿��֣������������ţ���");
	}
}
class IcePeak implements Drink {
	@Override
	public void drink() {
		System.out.println("���壬��С�ͺ���");
	}
}

interface DrinkFactory {
	Drink getDrink();
}
class ColaFactory implements DrinkFactory {
	@Override
	public Drink getDrink() {
		return new Cola();
	}
}
class IcePeakFactory implements DrinkFactory {

	@Override
	public Drink getDrink() {
		return new IcePeak();
	}
	
}

class Service {
	
	public void taste(FoodFactory ff, DrinkFactory df) {
		Food food = ff.getFood();
		
		Drink drink = df.getDrink();
		
		System.out.println("��ί1");
		food.eat();
		drink.drink();
		System.out.println("��ί2");
		food.eat();
		drink.drink();
		System.out.println("��ί3");
		food.eat();
		drink.drink();
		
	}
	
}

// =========================ʱ����==================================


public class AppTest {
	@Test
	public void test() throws Exception {

		Service s = new Service();
	
		s.taste(new HamburgerFactory(), new ColaFactory());
//		FoodFactory ff = new FrenchFiredFactory();
//		Food food = ff.getFood();
//		food.eat();

	}
}

/*
 �ŵ㣺
 1. �����������ģʽҲ�߱��򵥹����������ŵ㣺�Ѿ����Ʒ�������ӿͻ����н��������
 2. �����������ͷ��˼򵥹����У���չ�²�Ʒ�ͻ�Υ������ԭ������⡣
 
ȱ�㣺
 1. �����Ѿ�֪�����ڹ�������ģʽ֮�£�ÿ����չһ�������Ʒ����ô��Ҫ���׵ض�����һ�������ࡣ
 ���������ж����Ʒ�ȼ�������£�������������ͻᱬըʽ������
 
 2. ���ж����Ʒ�ȼ���ʱ�򣬲�ͬ�ȼ��Ĳ�Ʒ�п��ܴ��䲻����
  
  
Ϊ�˽������������ȱ�㣬���ǲ�ѧϰ���󹤳���
	
*/
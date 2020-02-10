package com.woniuxy.d_abstractfactory;

import org.junit.Test;

/*
��������
*/
interface Food {
	void eat();
}
class Hamburger2334 implements Food {
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

interface Drink {
	void drink();
}
class Cola implements Drink {
	@Override
	public void drink() {
		System.out.println("���¿��֣������������ţ���");
	}
}
class IcePeak2 implements Drink {
	@Override
	public void drink() {
		System.out.println("���壬��С�ͺ���");
	}
}

interface Toy {
	void play();
}


interface Factory {
	Food getFood();
	Drink getDrink();
}	
class KFCFactory implements Factory {
	@Override
	public Food getFood() {
		return new Hamburger2334();
	}

	@Override
	public Drink getDrink() {
		return new Cola();
	}
}
class SanQinFactory implements Factory {
	@Override
	public Food getFood() {
		return new FrenchFired();
	}

	@Override
	public Drink getDrink() {
		return new IcePeak2();
	}
}



class Service {
	
	public void taste(Factory f) {
		Food food = f.getFood();
		
		Drink drink = f.getDrink();
		
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

class A implements Food {

	@Override
	public void eat() {
		
	}
	
}

class B implements Drink {

	@Override
	public void drink() {
		
	}
	
}

class MDLFactory implements Factory{

	@Override
	public Food getFood() {
		return new A();
	}

	@Override
	public Drink getDrink() {
		return new B();
	}
	
}


public class AppTest {
	@Test
	public void test() throws Exception {
		Service s = new Service();
		s.taste(new MDLFactory());
//		FoodFactory ff = new FrenchFiredFactory();
//		Food food = ff.getFood();
//		food.eat();

	}
}

/*
 �ŵ㣺
 1. ���м򵥹����͹����������ŵ㣡
 2. �����˹����������
 
 
ȱ�㣺
 1. ȱ�㣬��ͬ��Ʒ�ȼ��еĲ�Ʒ����������
 2. ������һ���µĲ�Ʒ�ȼ���ʱ�򣬾ͻ�Υ������ԭ��
 
 ���ԣ���һ��ϵͳ�еĲ�Ʒ�ȼ��ȽϹ̶���ʱ��ſ��Կ���ʹ�ó��󷽷���������ã���
 
 
  
  
Ϊ�˽������������ȱ�㣬���ǲ�ѧϰ���󹤳���
	
*/
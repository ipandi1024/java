package com.woniuxy.c_factorymethod;

import java.awt.peer.FramePeer;

import org.junit.Test;

/*
工厂方法
*/
interface Food {
	void eat();
}
class Hamburgerabc implements Food {
	public void eat() {
		System.out.println("汉堡包，你值得拥有！");
	}
}
class FrenchFired implements Food {
	@Override
	public void eat() {
		System.out.println("薯条，晶晶亮，透心凉！！");
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
		System.out.println("百事可乐，就是这样自信！！");
	}
}
class IcePeak implements Drink {
	@Override
	public void drink() {
		System.out.println("冰峰，从小就喝它");
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
		
		System.out.println("评委1");
		food.eat();
		drink.drink();
		System.out.println("评委2");
		food.eat();
		drink.drink();
		System.out.println("评委3");
		food.eat();
		drink.drink();
		
	}
	
}

// =========================时空线==================================


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
 优点：
 1. 工厂方法设计模式也具备简单工厂的所有优点：把具体产品的类名从客户端中解耦出来。
 2. 工厂方法还客服了简单工厂中，扩展新产品就会违反开闭原则的问题。
 
缺点：
 1. 我们已经知道，在工厂方法模式之下，每多扩展一个具体产品，那么都要配套地多制作一个工厂类。
 这样，在有多个产品等级的情况下，工厂类的数量就会爆炸式增长！
 
 2. 当有多个产品等级的时候，不同等级的产品有可能搭配不当。
  
  
为了解决工厂方法的缺点，我们才学习抽象工厂。
	
*/
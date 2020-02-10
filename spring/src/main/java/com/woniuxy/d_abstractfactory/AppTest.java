package com.woniuxy.d_abstractfactory;

import org.junit.Test;

/*
工厂方法
*/
interface Food {
	void eat();
}
class Hamburger2334 implements Food {
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

interface Drink {
	void drink();
}
class Cola implements Drink {
	@Override
	public void drink() {
		System.out.println("百事可乐，就是这样自信！！");
	}
}
class IcePeak2 implements Drink {
	@Override
	public void drink() {
		System.out.println("冰峰，从小就喝它");
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
 优点：
 1. 具有简单工厂和工厂方法的优点！
 2. 减少了工厂类的数量
 
 
缺点：
 1. 缺点，不同产品等级中的产品不能灵活搭配
 2. 当增加一个新的产品等级的时候，就会违反开闭原则
 
 所以，当一个系统中的产品等级比较固定的时候才可以考虑使用抽象方法，否则别用！！
 
 
  
  
为了解决工厂方法的缺点，我们才学习抽象工厂。
	
*/
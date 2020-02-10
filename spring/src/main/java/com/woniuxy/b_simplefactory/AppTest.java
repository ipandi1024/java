package com.woniuxy.b_simplefactory;

import org.junit.Test;

/*
 简单工厂
*/
interface Food {
	void eat();
}
class Hamburger implements Food {
	public void eat() {
		System.out.println("汉堡包，你值得拥有！");
	}
}

class FoodFactory {
	public static Food getFood(int n) {
		Food food = null;
		switch (n) {
			case 1:
				food = new Hamburger();
				break;
		}
		return food;
	}
}

// =========================时空线==================================

class FrenchFired implements Food {
	@Override
	public void eat() {
		System.out.println("油炸法国佬");
	}
}

public class AppTest {
	@Test
	public void test() throws Exception {
		Food f = FoodFactory.getFood(1);
		f.eat();
	}
}

/*
 优点：
 1. 有了简单工厂之后，作者就算把具体类型修改了，客户端也不知道！！
 这样具体类型也就从客户端代码中解耦出来了！！
 
缺点：
  1. 客户端程序猿不得不记住常量与具体类名的映射关系，比如 1 对应 汉堡包，  2 对应 薯条  3 对应 凉皮 .....
    这对客户端程序猿不友好！
    
  2. 当客户端后期需要增加一个新的产品时，那就不得不去修改作者的源代码！ 这样势必会违反开闭原则！！
  
  
  3. 当产品类很多的时候，这个简单工厂就会变得十分臃肿！！ 因为要针对于每一个产品，编写一个case，所以会有很多case
  
  
杠点：
	1. 有了简单工厂，产品的具体类名就从客户端解耦了，以后就算具体类名被作者改了，客户端也不知道！！
	但是，这个简单工厂本身的类名如果变了呢？
	
	解答： 工厂的是一个逻辑上的接口， 作者有责任保证接口的稳定性。 所以工厂的名字是趋向于稳定的。
	
为了解决简单工厂的缺点，我们才使用工厂方法设计模式！ 参见下一个包！
*/
package com.woniuxy.a_init;

import org.junit.Test;

/*
 学习设计模式，必须要知道，开发代码的角色有2种：
 1. 作者， 又叫做服务器端程序猿
 		主要负责制作功能，比如struts2的作者就是服务器的程序猿。
 2. 用户，又叫做客户端程序猿
 		主要负责调用别人做好的功能，我们这些使用struts的程序猿就是客户端程序猿。
 		
 还必须要知道，在客户端程序猿使用框架开发的时候，手上往往没有框架的源代码！
 
===================================================================

工厂模式相关概念：
1. 抽象产品，就是代码中的interface或者abstract class
2. 具体产品，就是代码中的class
3. 产品簇（后面讲）
4. 产品等级（后面讲）
*/

interface Food {
	void eat();
}

class Hamburger implements Food {
	public void eat() {
		System.out.println("汉堡包，你值得拥有！");
	}
}

// =========================时空线==================================

public class AppTest {
	@Test
	public void test() throws Exception {
		Food f = new Hamburger();
		f.eat();
	}
}

/*
 	开发一时爽，后期火葬场！！
 	
 	此时上层代码直接依赖于下层的具体类名，当下层的具体类名发生变化时，上层也要跟着一起修改，这样就是所谓的“高耦合”！
 	
*/
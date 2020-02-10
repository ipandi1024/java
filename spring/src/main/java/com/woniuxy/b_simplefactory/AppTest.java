package com.woniuxy.b_simplefactory;

import org.junit.Test;

/*
 �򵥹���
*/
interface Food {
	void eat();
}
class Hamburger implements Food {
	public void eat() {
		System.out.println("����������ֵ��ӵ�У�");
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

// =========================ʱ����==================================

class FrenchFired implements Food {
	@Override
	public void eat() {
		System.out.println("��ը������");
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
 �ŵ㣺
 1. ���˼򵥹���֮�����߾���Ѿ��������޸��ˣ��ͻ���Ҳ��֪������
 ������������Ҳ�ʹӿͻ��˴����н�������ˣ���
 
ȱ�㣺
  1. �ͻ��˳���Գ���ò���ס���������������ӳ���ϵ������ 1 ��Ӧ ��������  2 ��Ӧ ����  3 ��Ӧ ��Ƥ .....
    ��Կͻ��˳���Գ���Ѻã�
    
  2. ���ͻ��˺�����Ҫ����һ���µĲ�Ʒʱ���ǾͲ��ò�ȥ�޸����ߵ�Դ���룡 �����Ʊػ�Υ������ԭ�򣡣�
  
  
  3. ����Ʒ��ܶ��ʱ������򵥹����ͻ���ʮ��ӷ�ף��� ��ΪҪ�����ÿһ����Ʒ����дһ��case�����Ի��кܶ�case
  
  
�ܵ㣺
	1. ���˼򵥹�������Ʒ�ľ��������ʹӿͻ��˽����ˣ��Ժ����������������߸��ˣ��ͻ���Ҳ��֪������
	���ǣ�����򵥹��������������������أ�
	
	��� ��������һ���߼��ϵĽӿڣ� ���������α�֤�ӿڵ��ȶ��ԡ� ���Թ������������������ȶ��ġ�
	
Ϊ�˽���򵥹�����ȱ�㣬���ǲ�ʹ�ù����������ģʽ�� �μ���һ������
*/
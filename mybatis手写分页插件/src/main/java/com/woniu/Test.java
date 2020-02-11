package com.woniu;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
	//volatile: 保持内存可见   保证指令不重排 但是没有保证原子性
	public static AtomicInteger  age = new AtomicInteger(0);//又没有保证原子性 有没有保证指令重排
	
	public static void main(String[] args) {
	
		for (int i = 0; i < 20; i++) {
			Thread r = new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 0; j < 2000; j++) {
						Test.age.getAndIncrement();
					}
				}
				
			});
			r.start();
		}
		while(Thread.activeCount()>1) {
			Thread.yield();
		}
		System.out.println(Test.age.get());
	}
}

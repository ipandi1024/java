package com.woniu.thread;

import java.util.concurrent.CountDownLatch;

public class Test2 {

	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(10);
		
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						latch.await();
						MyObject.create();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//一直进行阻塞，至到你的countdown的计数器变成0.所有的线程同时开始运行。
				}
			};
			t.start();
			latch.countDown();//每次进行递减操作，至到计数器达到0的位置，释放全部的线程
		}
		
		
		
		
		
	}
}

package com.woniu.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {

	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(100);
		
		ExecutorService executor = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 100; i++) {
			executor.submit(new Callable() {
				public Object call() throws Exception {
					// TODO Auto-generated method stub
					System.out.println("before");
					latch.await();
					System.out.println("execute finish");
					return null;
				}
				
			});
			latch.countDown();
		}
		
	}
}

package com.woniu.thread;

public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread() {
				public void run() {
					MyObject.create();
				}
			};
			thread.start();
		}
	}
}

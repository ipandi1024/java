package com.woniu.thread;

public class MyObject {
	private static MyObject object;
	private MyObject() {
		System.out.println("new instance");
	}
	
	public static MyObject create() {
		if(object==null) {
			object =  new MyObject();
		}
		return object;
	}
}

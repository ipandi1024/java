package com.woniu;

import java.util.Timer;
import java.util.TimerTask;

public class JavaTimer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("ÎÒğIÁË");
			}
		},1000,3000);
	}
}

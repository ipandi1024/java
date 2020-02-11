package com.woniu;

import redis.clients.jedis.Jedis;

public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		//insert
		jedis.set("stname", "panfeng");
		//find
		System.out.println(jedis.get("stname"));
		//update
		jedis.set("stname", "gaopeng");
		
		//delete
		//jedis.del("stname");
		System.out.println(jedis.get("stname"));
		
		jedis.expire("stname", 3);
		
		Thread.sleep(3000);
		
		System.out.println(jedis.get("stname"));
		
		//find
		System.out.println(jedis.get("stname"));
	}
}

package com.woniu;

import redis.clients.jedis.Jedis;

public class Test5 {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.flushDB();//清空当前库
		jedis.flushAll();//清空所有库
		
		//add
		jedis.zadd("persons", 160, "高鹏");
		jedis.zadd("persons", 190, "潘凤");
		jedis.zadd("persons", 150, "王斌");
		jedis.zadd("persons", 185, "陈籍");
		
		//delete
		jedis.zrem("persons", "高鹏");
		
		//findAll
		System.out.println(jedis.zrange("persons", 0, -1));
		
		
	}
}

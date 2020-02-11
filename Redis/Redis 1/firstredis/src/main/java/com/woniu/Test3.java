package com.woniu;

import redis.clients.jedis.Jedis;

public class Test3 {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.flushDB();//清空当前库
		jedis.flushAll();//清空所有库
		
		//add
		jedis.rpush("persons", "高鹏");
		jedis.rpush("persons", "潘峰");
		jedis.rpush("persons", "王斌");
		jedis.rpush("persons", "张涛");
		
		//delete
		jedis.lrem("persons", 0, "王斌");
		
		//findById
		System.out.println(jedis.lindex("persons", 2));;
		
		//update
		jedis.lset("persons", 2, "潘凤");//
		
		//list
		//System.out.println(jedis.lrange("persons", 0, 2));
		//System.out.println(jedis.lrange("persons", 0, jedis.llen("persons")));
		System.out.println(jedis.lrange("persons", 0, -1));
	}
}

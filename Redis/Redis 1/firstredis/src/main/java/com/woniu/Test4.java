package com.woniu;

import redis.clients.jedis.Jedis;

public class Test4 {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.flushDB();//清空当前库
		jedis.flushAll();//清空所有库
		
		//add
		jedis.sadd("persons", "潘凤");
		jedis.sadd("persons", "潘小凤");
		jedis.sadd("persons", "潘大凤");
		jedis.sadd("persons", "潘二凤");
		
		//delete
		//jedis.srem("persons", "潘大凤");
		
		//findAll
		System.out.println(jedis.smembers("persons"));
		
//		//
//		System.out.println(jedis.spop("persons"));
//		
//		System.out.println(jedis.smembers("persons"));
		
		System.out.println(jedis.scard("persons"));
		
		
	}
}

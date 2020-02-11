package com.woniu;

import redis.clients.jedis.Jedis;

public class Test6 {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.flushDB();//清空当前库
		jedis.flushAll();//清空所有库
		//add
		jedis.hset("person", "name","潘凤");
		jedis.hset("person", "sex","randome");
		jedis.hset("person", "age","耄耋");
		jedis.hset("person", "wife","翠花");
		
		jedis.hdel("person", "name");
		
		
		System.out.println(jedis.hget("person", "name"));
		
		System.out.println(jedis.hkeys("person"));
		
		System.out.println(jedis.hvals("person"));
		
		
	}
}

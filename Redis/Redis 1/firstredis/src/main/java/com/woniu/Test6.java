package com.woniu;

import redis.clients.jedis.Jedis;

public class Test6 {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.flushDB();//��յ�ǰ��
		jedis.flushAll();//������п�
		//add
		jedis.hset("person", "name","�˷�");
		jedis.hset("person", "sex","randome");
		jedis.hset("person", "age","���");
		jedis.hset("person", "wife","�仨");
		
		jedis.hdel("person", "name");
		
		
		System.out.println(jedis.hget("person", "name"));
		
		System.out.println(jedis.hkeys("person"));
		
		System.out.println(jedis.hvals("person"));
		
		
	}
}

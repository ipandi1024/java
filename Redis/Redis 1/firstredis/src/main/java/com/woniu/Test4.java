package com.woniu;

import redis.clients.jedis.Jedis;

public class Test4 {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.flushDB();//��յ�ǰ��
		jedis.flushAll();//������п�
		
		//add
		jedis.sadd("persons", "�˷�");
		jedis.sadd("persons", "��С��");
		jedis.sadd("persons", "�˴��");
		jedis.sadd("persons", "�˶���");
		
		//delete
		//jedis.srem("persons", "�˴��");
		
		//findAll
		System.out.println(jedis.smembers("persons"));
		
//		//
//		System.out.println(jedis.spop("persons"));
//		
//		System.out.println(jedis.smembers("persons"));
		
		System.out.println(jedis.scard("persons"));
		
		
	}
}

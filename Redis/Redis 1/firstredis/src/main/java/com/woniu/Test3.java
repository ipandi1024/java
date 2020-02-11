package com.woniu;

import redis.clients.jedis.Jedis;

public class Test3 {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.flushDB();//��յ�ǰ��
		jedis.flushAll();//������п�
		
		//add
		jedis.rpush("persons", "����");
		jedis.rpush("persons", "�˷�");
		jedis.rpush("persons", "����");
		jedis.rpush("persons", "����");
		
		//delete
		jedis.lrem("persons", 0, "����");
		
		//findById
		System.out.println(jedis.lindex("persons", 2));;
		
		//update
		jedis.lset("persons", 2, "�˷�");//
		
		//list
		//System.out.println(jedis.lrange("persons", 0, 2));
		//System.out.println(jedis.lrange("persons", 0, jedis.llen("persons")));
		System.out.println(jedis.lrange("persons", 0, -1));
	}
}

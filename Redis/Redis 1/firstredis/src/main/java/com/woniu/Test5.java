package com.woniu;

import redis.clients.jedis.Jedis;

public class Test5 {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.flushDB();//��յ�ǰ��
		jedis.flushAll();//������п�
		
		//add
		jedis.zadd("persons", 160, "����");
		jedis.zadd("persons", 190, "�˷�");
		jedis.zadd("persons", 150, "����");
		jedis.zadd("persons", 185, "�¼�");
		
		//delete
		jedis.zrem("persons", "����");
		
		//findAll
		System.out.println(jedis.zrange("persons", 0, -1));
		
		
	}
}

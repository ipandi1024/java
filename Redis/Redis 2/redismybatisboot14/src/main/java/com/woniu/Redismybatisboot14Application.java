package com.woniu;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@MapperScan("com.woniu.mapper")
public class Redismybatisboot14Application {
//	@Resource
//	private RedisTemplate redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Redismybatisboot14Application.class, args);
	}
	
//	public RedisTemplate redisTemplate2() {
//		RedisTemplate redisTemplate2 = new RedisTemplate();
//		JedisPoolConfig poolConfig=new JedisPoolConfig();  
//		
//		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig); 
//		redisTemplate2.setConnectionFactory(redisTemplate.getConnectionFactory());
//		
//		
//		return redisTemplate2;
//	}
	
}

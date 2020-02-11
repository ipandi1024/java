package com.woniu.controller;

import javax.annotation.Resource;
import javax.websocket.Session;

import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserinfoController {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@GetMapping("say")
	public String say() {
		redisTemplate.opsForValue().set("uname", "zsf");
		redisTemplate.opsForList().rightPush("person", "zsf1");
		redisTemplate.opsForList().rightPush("person", "zsf2");
		redisTemplate.opsForList().rightPush("person", "zsf3");
		redisTemplate.opsForHash().put("school", "name", "蜗牛学院");
		
		return "ok";
	}
	
	@GetMapping("get")
	public String get() {
		System.out.println(redisTemplate.opsForValue().get("uname"));
		
		System.out.println(redisTemplate.opsForList().range("person", 0, -1));
		
		System.out.println(redisTemplate.opsForHash().get("school", "name"));
		
		
		return "ok";
	}
}

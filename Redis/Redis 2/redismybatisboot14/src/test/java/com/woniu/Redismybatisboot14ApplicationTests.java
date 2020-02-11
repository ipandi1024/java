package com.woniu;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Redismybatisboot14ApplicationTests {
	@Resource
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void ddd() {
		System.out.println(redisTemplate);
	}

}

package com.woniu.controller;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController {
	@Resource
	private RedissonClient redissClient;
	
	//库存以前放在数据库中，现在放在Redis中
	@Resource
	private RedisTemplate<String, Integer> redisTemplate;
	
	private AtomicInteger buyCount;
	
	//初始化工作   启动的时候读取数据库获取数据库的库存
	@GetMapping("init")
	public String init() {
		redisTemplate.opsForValue().set("count", 5);
		buyCount = new AtomicInteger(0);
		return "初始化完毕";
	}
	
	//Buy的行为，买的时候库存要-1,用户购买的数量+1
	@GetMapping("buy")
	public String buy() {
		RLock rlock = redissClient.getLock("count");
		try {
			rlock.lock();
			int count = redisTemplate.opsForValue().get("count");
			count=count-1;
			if(count<0) {
				return "已经售罄，请明天再来";
			}
			redisTemplate.opsForValue().set("count",count);
			return "成功购买，购买了"+buyCount.incrementAndGet()+"件";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			rlock.unlock();
		}
		return null;
		
	}
	
	//查看用户现在买了几个
	@GetMapping("getCount")
	public String getCount() {
		return "总共购买了"+buyCount.get();
	}
}

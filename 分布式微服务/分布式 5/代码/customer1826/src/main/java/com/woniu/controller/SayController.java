package com.woniu.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class SayController {
	@Resource
	private RestTemplate restTemplate;
	
	@Value("${user.userSericeURL}")
    private String userSericeURL;
	
	@GetMapping("/say")
	@HystrixCommand(fallbackMethod="error")
	public String say() {
		return restTemplate.getForObject(userSericeURL+"findAll", String.class);
	}
	
	public String error() {
		System.out.println("发生降级");
		return "程序错误，发生降级";
	}
}

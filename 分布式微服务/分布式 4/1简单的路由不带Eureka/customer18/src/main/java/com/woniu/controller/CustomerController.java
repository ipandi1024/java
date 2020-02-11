package com.woniu.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {
	@Resource
	private RestTemplate restTemplate;
	@GetMapping("/getPerson")
	public String getPerson() {
		return restTemplate.getForObject("http://localhost:10000/goods/findAll", String.class);
	}
	
	@GetMapping("/getPerson2")
	public String getPerson2() {
		return restTemplate.getForObject("http://localhost:10000/orders/findPerson", String.class);
	}
	

}

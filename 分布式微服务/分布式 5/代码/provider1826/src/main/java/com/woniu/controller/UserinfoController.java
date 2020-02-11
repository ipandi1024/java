package com.woniu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserinfoController {
	@GetMapping("/findAll")
	public String findAll() throws InterruptedException {
		
		System.out.println("进入提供者了");
		//int i = 9/0;
		return "i love laohan";
	}
}

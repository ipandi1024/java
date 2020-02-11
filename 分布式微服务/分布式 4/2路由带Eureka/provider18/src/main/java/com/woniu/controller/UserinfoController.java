package com.woniu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserinfoController {
	@GetMapping("/findAll")
	public String findAll() {
		return "找到潘峰这个人了.";
	}
}

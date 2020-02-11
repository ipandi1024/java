package com.woniu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserinfoController {
	@GetMapping("/findPerson")
	public String findAll() {
		return "找到陆云.";
	}
}

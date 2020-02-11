package com.woniu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.netflix.zuul.http.ZuulServlet;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class Zuul18Application {

	public static void main(String[] args) {
		ZuulServlet dServlet;
		SpringApplication.run(Zuul18Application.class, args);
	}

}

package com.woniu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config18Application {

	public static void main(String[] args) {
		SpringApplication.run(Config18Application.class, args);
	}

}

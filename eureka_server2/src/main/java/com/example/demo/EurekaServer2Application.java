package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaServer
//@Controller
@RestController
public class EurekaServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer2Application.class, args);
	}

	@RequestMapping("welcome")
	public String welcome() {

		//return "welcome.html";
		return "hello,my port is 2222";
	}
}

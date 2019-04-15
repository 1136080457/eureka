package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class serviceRibbon {
	
	  @Autowired 
	  RestTemplate rest;
	  
	  @RequestMapping("welcome") 
	  public String testRibbon() {
	  //根据从eureka服务列表里发现的服务名去调用对应的方法(此URL是服务列表名/请求方法)，默认是轮询 
		  return rest.getForObject("http://Ribbon-test/welcome", String.class); 
	  }
	
	
	
	
}

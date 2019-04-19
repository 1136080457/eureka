package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class serviceRibbon {
	
	  @Autowired 
	  RestTemplate rest;
	  
	  @RequestMapping("welcome") 
	  public String testRibbon() {
	  //根据从eureka服务列表里发现的服务名去调用对应的方法(此URL是服务列表名/请求方法)，默认是轮询 
		  return rest.getForObject("http://Ribbon-test/welcome", String.class); 
	  }
	
	 @HystrixCommand(fallbackMethod="Hystrixfallback")//调用的服务挂掉或是出错后，会调用例外一个配置的方法
	@RequestMapping("testHystrix")
	public String testHystrix() {
		
		return rest.getForObject("http://Ribbon-test/findall", String.class);
	}
	
	public String Hystrixfallback() {
		//此方法需要与原方法要有相同的参数与返回值
		return "查询你妹啊，服务器都搞蹦了~~~";
	}
}

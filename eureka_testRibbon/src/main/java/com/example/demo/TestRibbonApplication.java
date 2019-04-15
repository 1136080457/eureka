package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import ribbon_config.ribbon_Configs;

@SpringBootApplication
@EnableDiscoveryClient // 目的是为了在服务列表中发现服务
@RibbonClient(configuration = ribbon_Configs.class, name = "Ribbon-test")  //配置负载均衡策略(具体策略的类和需要使用策略的服务名;没有配置在name中的服务，还是采用默认轮询的方式)
public class TestRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestRibbonApplication.class, args);
	}
	
	  
	  @Bean
	  @LoadBalanced //启用客户端负载均衡 (若无其他负载均衡的配置，默认是轮询)
	  RestTemplate restTemplate() { 
		  
		  return new RestTemplate(); 
	}
	  
	 

}

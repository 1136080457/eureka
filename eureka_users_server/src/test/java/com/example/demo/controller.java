package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	
	@RequestMapping("/select")
	public String select() {
		
		return "";
	}
	
	
}

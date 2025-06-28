package com.dipanshu.order_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@GetMapping("/hello")
	public String helloOrder() {
		return "Hello from order Service!";
	}


}

package com.dipanshu.inventory_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventorys")
public class InventoryController {
	
		@GetMapping("/hello")
		public String helloInventory() {
			return "Hello from inventory Service!";
		}
	

}

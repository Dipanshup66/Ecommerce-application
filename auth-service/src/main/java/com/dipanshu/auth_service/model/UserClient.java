package com.dipanshu.auth_service.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserClient {

	@GetMapping("/users/verify")
	public boolean verify(@RequestParam String email, @RequestParam String password);

	@GetMapping("/users/by-email")
	public UserDto getUserByEmail(@RequestParam String email);

}

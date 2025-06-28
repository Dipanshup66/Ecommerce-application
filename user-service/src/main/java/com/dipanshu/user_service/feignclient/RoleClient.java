package com.dipanshu.user_service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dipanshu.common.dto.RoleDto;

@FeignClient(name = "role-service", url = "${ROLE_SERVICE_URL}")
public interface RoleClient {
	@GetMapping("/roles/{name}")
	RoleDto getRoleByName(@PathVariable String name);
}

package com.dipanshu.role_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dipanshu.common.controller.BaseController;
import com.dipanshu.common.dto.RoleDto;
import com.dipanshu.role_service.form.RoleForm;
import com.dipanshu.role_service.model.Role;
import com.dipanshu.role_service.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController extends BaseController<RoleForm, Role, RoleService> {

	private final RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		super(roleService);
		this.roleService = roleService;
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/{name}")
	public RoleDto getRoleByName(@PathVariable String name) {
		Role role = roleService.findByName(name);

		RoleDto dto = new RoleDto();
		dto.setId(role.getId());
		dto.setName(role.getName());

		return dto;
	}

}

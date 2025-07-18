package com.dipanshu.role_service.service;

import com.dipanshu.common.controller.BaseService;
import com.dipanshu.role_service.model.Role;

public interface RoleService extends BaseService<Role> {

	public Role getRoleByName(String name);

	public long createRole(Role role);

	public Role findByName(String name);
	

}

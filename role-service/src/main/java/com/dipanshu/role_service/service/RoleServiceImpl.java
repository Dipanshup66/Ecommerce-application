package com.dipanshu.role_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dipanshu.common.controller.BaseServiceImpl;
import com.dipanshu.role_service.model.Role;
import com.dipanshu.role_service.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleRepository> implements RoleService {

	@Autowired
	private RoleRepository repository;

	@Override
	public Role getRoleByName(String name) {

		return repository.findByName(name);
	}

	@Override
	public long createRole(Role role) {

		return repository.add(role);
	}

	@Override
	public Role findByName(String name) {

		return repository.findByName(name);
	}

}

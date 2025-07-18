package com.dipanshu.role_service.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dipanshu.common.controller.BaseRepositoryImpl;
import com.dipanshu.role_service.model.Role;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class RoleRepositoryImpl extends BaseRepositoryImpl<Role> implements RoleRepository {

	@Override
	public Class<Role> getDTOClass() {
		// TODO Auto-generated method stub
		return Role.class;
	}

	@Override
	public List<Predicate> getWhereClause(CriteriaBuilder builder, Root qRoot, Role dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findByName(String name) {
		String jpql = "SELECT u FROM Role u WHERE u.name = :name";
		return entityManager.createQuery(jpql, Role.class).setParameter("name", name).getSingleResult();
	}

}

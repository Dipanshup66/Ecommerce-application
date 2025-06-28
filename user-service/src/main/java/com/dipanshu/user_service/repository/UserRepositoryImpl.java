package com.dipanshu.user_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dipanshu.common.controller.BaseRepositoryImpl;
import com.dipanshu.user_service.model.User;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

	@Override
	public Class<User> getDTOClass() {
		// TODO Auto-generated method stub
		return User.class;
	}

	@Override
	public List<Predicate> getWhereClause(CriteriaBuilder builder, Root qRoot, User dto) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		if (dto != null) {
			if (dto.getId() != null) {
				whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
			}
		}
		return whereCondition;
	}

	@Override
	public boolean existsByEmail(String email) {
		String jpql = "SELECT COUNT(u) FROM User u WHERE u.email = :email";
		Long count = entityManager.createQuery(jpql, Long.class).setParameter("email", email).getSingleResult();
		return count > 0;
	}

	@Override
	public boolean existsByUsername(String username) {
		String jpql = "SELECT COUNT(u) FROM User u WHERE u.name = :name";
		Long count = entityManager.createQuery(jpql, Long.class).setParameter("name", username).getSingleResult();
		return count > 0;
	}

}

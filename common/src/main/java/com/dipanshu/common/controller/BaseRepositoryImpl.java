package com.dipanshu.common.controller;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public abstract class BaseRepositoryImpl<T extends BaseEntity> implements BaseRepository<T> {

	@PersistenceContext
	public EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public long add(T dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(T dto) {
		entityManager.merge(dto);
	}

	public void delete(T dto) {
		entityManager.remove(dto);

	}

	public T findByPk(long pk) {
		T dto = entityManager.find(getDTOClass(), pk);
		return dto;
	}

	public T findByUniquekey(String attribute, Object val) {
		Class<T> dtoClass = getDTOClass();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(dtoClass);

		Root<T> qRoot = cq.from(dtoClass);

		Predicate condition = builder.equal(qRoot.get(attribute), val);

		cq.where(condition);

		TypedQuery<T> query = entityManager.createQuery(cq);

		List<T> list = query.getResultList();

		T dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}

		return dto;

	}

	public abstract Class<T> getDTOClass();

	public abstract List<Predicate> getWhereClause(CriteriaBuilder builder, Root qRoot, T dto);

	public List search(T dto, int pageNo, int pageSize) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = builder.createQuery(getDTOClass());
		Root<T> qRoot = cq.from(getDTOClass());

		List<Predicate> predicateList = getWhereClause(builder, qRoot, dto);
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		TypedQuery<T> tq = entityManager.createQuery(cq);
		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}
		List<T> list = tq.getResultList();

		return list;
	}

}

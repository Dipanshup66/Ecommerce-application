package com.dipanshu.common.controller;

import java.util.List;

import jakarta.persistence.EntityManager;

public interface BaseRepository<T extends BaseEntity> {

	public long add(T dto);

	public void update(T dto);

	public void delete(T dto);

	public T findByPk(long pk);

	public T findByUniquekey(String attribute, Object val);

	public List search(T dto, int pageNo, int pageSize);

	public void setEntityManager(EntityManager entityManager);

}

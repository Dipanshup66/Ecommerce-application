package com.dipanshu.common.controller;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

	public long add(T dto);

	public List search(T dto, int pageNo, int pageSize);

	public T findById(long id);

	public void delete(long id);

	public void update(T dto);

}

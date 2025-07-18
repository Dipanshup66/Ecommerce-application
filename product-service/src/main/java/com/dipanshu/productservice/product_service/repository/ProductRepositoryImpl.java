package com.dipanshu.productservice.product_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dipanshu.common.controller.BaseRepositoryImpl;
import com.dipanshu.productservice.product_service.model.Product;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository {

	@Override
	public Class<Product> getDTOClass() {
		// TODO Auto-generated method stub
		return Product.class;
	}

	@Override
	public List<Predicate> getWhereClause(CriteriaBuilder builder, Root qRoot, Product dto) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		if (dto != null) {
			if (dto.getId() != null) {
				whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				whereCondition.add(builder.like(qRoot.get("name"), "%" + dto.getName()));
			}
			if (dto.getBrand() != null && dto.getBrand().length() > 0) {
				whereCondition.add(builder.like(qRoot.get("brand"), "%" + dto.getBrand()));
			}
			if (dto.getColor() != null && dto.getColor().length() > 0) {
				whereCondition.add(builder.like(qRoot.get("color"), "%" + dto.getColor()));
			}
			if (dto.getDescription() != null && dto.getDescription().length() > 0) {
				whereCondition.add(builder.like(qRoot.get("description"), "%" + dto.getDescription()));
			}
		}
		return whereCondition;
	}

	@Override
	public boolean existsBySku(String sku) {
		String jpql = "SELECT COUNT(p) FORM Product p WHERE p.sku = :sku";
		Long count = entityManager.createQuery(jpql, Long.class).setParameter("sku", sku).getSingleResult();
		return count > 0;
	}

	@Override
	public boolean existsByName(String name) {
		String jpql = "SELECT COUNT(p) FORM Product p WHERE p.name = :name";
		Long count = entityManager.createQuery(jpql, Long.class).setParameter("name", name).getSingleResult();
		return count > 0;
	}

}

package com.dipanshu.productservice.product_service.service;

import com.dipanshu.common.controller.BaseService;
import com.dipanshu.productservice.product_service.model.Product;

public interface ProductService extends BaseService<Product> {

	public void addProduct(Product product);

}

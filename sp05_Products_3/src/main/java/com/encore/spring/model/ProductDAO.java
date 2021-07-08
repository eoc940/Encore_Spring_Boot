package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Product;

public interface ProductDAO {
	List<Product> getAllProduct() throws Exception;
	List<Product> getAllProduct(Product product) throws Exception;
	int addProduct(Product product) throws Exception;
}

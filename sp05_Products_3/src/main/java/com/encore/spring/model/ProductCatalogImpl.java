package com.encore.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Product;

@Service
public class ProductCatalogImpl implements ProductCatalog {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<Product> getAllProduct() throws Exception {
		
		return productDAO.getAllProduct();
	}

	@Override
	public List<Product> getAllProduct(Product product) throws Exception {
		
		return productDAO.getAllProduct(product);
	}

	@Override
	public int addProduct(Product product) throws Exception {
		return productDAO.addProduct(product);

	}

}

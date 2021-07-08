package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.MyProduct;

public interface MyProductDAO {
	void addProduct(MyProduct vo) throws Exception;
	List<MyProduct> findByProductName(String words)throws Exception;
	List<MyProduct> findProducts()throws Exception;
	List<MyProduct>  findByProductMaker(String words)throws Exception;
}

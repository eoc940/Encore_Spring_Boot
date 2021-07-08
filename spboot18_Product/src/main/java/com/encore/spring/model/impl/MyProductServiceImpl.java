package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;
import com.encore.spring.model.MyProductService;

@Service
@Transactional
public class MyProductServiceImpl implements MyProductService{

	@Autowired
	private MyProductDAO myProductDAO;
	
	@Transactional
	@Override
	public void addProduct(MyProduct vo) throws Exception {
		myProductDAO.addProduct(vo);
		
	}

	@Override
	public List<MyProduct> findByProductName(String words) throws Exception {
		
		return myProductDAO.findByProductName(words);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return myProductDAO.findProducts();
	}

	@Override
	public List<MyProduct> findByProductMaker(String words) throws Exception {
		return myProductDAO.findByProductMaker(words);
	}

}

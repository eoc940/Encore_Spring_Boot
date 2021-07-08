package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final String NS = "ProductMapper.";
	
	@Override
	public void addProduct(MyProduct vo) throws Exception {
		sqlSession.insert(NS+"addProduct", vo);
		
	}

	@Override
	public List<MyProduct> findByProductName(String words) throws Exception {
		
		return sqlSession.selectList(NS+"findByProductName", words);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return sqlSession.selectList(NS+"findProducts");
	}

	@Override
	public List<MyProduct> findByProductMaker(String words) throws Exception {
		return sqlSession.selectList(NS+"findByProductMaker",words);
	}

}

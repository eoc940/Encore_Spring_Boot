package com.encore.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NS = "ProductMapper.";
	
	//필요없음
	@Override
	public List<Product> getAllProduct() throws Exception {
		
		return sqlSession.selectList(NS + "getAllProductList");
	}

	@Override
	public int addProduct(Product product) throws Exception {
		
		return sqlSession.insert(NS + "addProduct", product); 
	}

	@Override
	public List<Product> getAllProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS + "getAllProductList", product);
	}

}

package com.encore.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "ItemMapper.";
	
	@Override
	public List<Item> getItemList() throws Exception {
		
		return sqlSession.selectList(NS + "getItemList");
	}

	@Override
	public Item getItem(Integer itemid) throws Exception {
		
		return sqlSession.selectOne(NS + "getItem", itemid);
	}

}

package com.encore.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

@Repository
public class phoneDAOImpl implements IPhoneDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	final String NS = "sql.pms.mapper.";

	@Override
	public int insert(Phone phone) {
		return sqlSession.insert(NS+"insert",phone);
		
	}

	@Override
	public int delete(String num) {
		return sqlSession.delete(NS+"delete",num);
	}

	@Override
	public Phone select(Phone phone) {
		return sqlSession.selectOne(NS+"select",phone);
	}

	@Override
	public List<Phone> select() {
		return sqlSession.selectList(NS+"select",null);
	}

	@Override
	public UserInfo select(UserInfo user) {
		return sqlSession.selectOne(NS+"selectUser",user);
	}

}

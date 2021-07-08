package com.encore.spring.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.User;
@Repository
public class userDAOImpl implements userDAO {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}



	@Override
	public User getUser(String userId) throws Exception {
		return sqlSession.selectOne("userMapper.getUser",userId);
	}

	
}

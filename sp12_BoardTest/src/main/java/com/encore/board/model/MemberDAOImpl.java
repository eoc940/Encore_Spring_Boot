package com.encore.board.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.board.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	final String NS = "sql.member.mapper.";
	
	@Override
	public MemberVO selectUser(MemberVO vo) {
		return sqlSession.selectOne(NS + "selectUser", vo);
	}

}

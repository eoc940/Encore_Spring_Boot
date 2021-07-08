package com.encore.spring.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.vo.MemberVO;


@Repository
public class MemberDAOImpl implements MemberDAO {
	
	final String ns = "MemberMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	/* (non-Javadoc)
	 * @see com.ssafy.model.IMemberDAO#loginCheck(java.lang.String, java.lang.String)
	 */
	@Override
	public MemberVO loginCheck(MemberVO vo) throws SQLException{
		MemberVO pvo = sqlSession.selectOne(ns+"loginCheck", vo);
		return pvo;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IMemberDAO#add(com.ssafy.model.Member)
	 */
	@Override
	public void add(MemberVO vo) throws Exception {
		sqlSession.insert(ns+"add", vo);
	}
	
}








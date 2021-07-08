package com.encore.spring.dao;

import java.sql.SQLException;

import com.encore.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO loginCheck(MemberVO vo) throws SQLException;

	void add(MemberVO m) throws Exception;

}
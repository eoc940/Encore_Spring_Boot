package com.encore.spring.service;

import java.sql.SQLException;

import com.encore.spring.vo.MemberVO;

public interface MemberService {
	MemberVO loginCheck(MemberVO vo) throws SQLException;
	void add(MemberVO vo) throws Exception;
}

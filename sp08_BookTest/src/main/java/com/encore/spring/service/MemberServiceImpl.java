package com.encore.spring.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.dao.MemberDAO;
import com.encore.spring.vo.MemberVO;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO loginCheck(MemberVO vo) throws SQLException {
		
		return memberDAO.loginCheck(vo);
	}

	@Override
	public void add(MemberVO vo) throws Exception {
		memberDAO.add(vo);
		
	}

}

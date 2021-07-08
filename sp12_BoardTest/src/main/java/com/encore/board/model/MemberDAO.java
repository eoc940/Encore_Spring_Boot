package com.encore.board.model;

import com.encore.board.domain.MemberVO;

public interface MemberDAO {
	
	MemberVO selectUser(MemberVO vo);
	

}

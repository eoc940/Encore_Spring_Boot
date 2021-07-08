package com.encore.board.model;

import com.encore.board.domain.MemberVO;

public interface MemberService {
	MemberVO selectUser(MemberVO vo);
}

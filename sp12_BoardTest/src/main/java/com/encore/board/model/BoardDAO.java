package com.encore.board.model;

import java.util.List;

import com.encore.board.domain.BoardVO;

public interface BoardDAO {
	
	int write(BoardVO vo);
	String selectByNoForDate(int no);
	List<BoardVO> getBoardList();
	BoardVO getBoard(int no);
	void deleteBoard(int no);
	void updateBoard(BoardVO vo);
	void plusCount(int no);

}

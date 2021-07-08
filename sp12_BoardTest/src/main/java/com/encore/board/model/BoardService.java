package com.encore.board.model;

import java.util.List;

import com.encore.board.domain.BoardVO;

public interface BoardService {
	
	int write(BoardVO vo);
	List<BoardVO> getBoardList();
	BoardVO getBoard(int no);
	void deleteBoard(int no);
	void updateBoard(BoardVO vo);
	void plusCount(int no);

}
	

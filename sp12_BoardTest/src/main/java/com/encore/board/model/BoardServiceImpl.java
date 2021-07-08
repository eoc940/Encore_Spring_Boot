package com.encore.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	
	@Override
	public int write(BoardVO vo) {
		int row = boardDAO.write(vo);
		System.out.println("before vo_date :: " + vo.getWriteDate() );
		String date = boardDAO.selectByNoForDate(vo.getNo());
		vo.setWriteDate(date);
		System.out.println("after vo_date :: " + vo.getWriteDate() );
		return row;
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}

	@Override
	public BoardVO getBoard(int no) {
		return boardDAO.getBoard(no);
	}

	
	@Override
	public void deleteBoard(int no) {
		boardDAO.deleteBoard(no);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void plusCount(int no) {
		boardDAO.plusCount(no);
	}

	

}

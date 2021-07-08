package com.encore.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	final String NS = "sql.board.mapper."; // mapper namespace

	@Override
	public int write(BoardVO vo) {
		return sqlSession.insert(NS + "write", vo);
	}

	@Override
	public String selectByNoForDate(int no) {
		return sqlSession.selectOne(NS + "selectByNoForDate", no); 
	}

	@Override
	public List<BoardVO> getBoardList() {
		return sqlSession.selectList(NS + "getBoardList");
	}

	@Override
	public BoardVO getBoard(int no) {
		return sqlSession.selectOne(NS + "showContent", no);
	}

	@Override
	public void deleteBoard(int no) {
		sqlSession.delete(NS + "deleteBoard", no);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		sqlSession.update(NS + "updateBoard", vo);
	}

	@Override
	public void plusCount(int no) {
		sqlSession.update(NS + "plusCount", no);
	}

}

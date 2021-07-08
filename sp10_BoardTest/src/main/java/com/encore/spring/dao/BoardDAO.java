package com.encore.spring.dao;

import java.util.List;

import com.encore.spring.domain.Board;

public interface BoardDAO {

	void insert(Board vo) throws Exception;
	List<Board> selectAll() throws Exception;
	Board selectOne(String no) throws Exception;
	
}

package com.encore.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.encore.spring.domain.Board;

@Transactional
public interface BoardService {
	void insert(Board vo) throws Exception;
	List<Board> selectAll() throws Exception;
	Board selectOne(String no) throws Exception;
}

package com.encore.spring.service;

import java.util.List;

import com.encore.spring.vo.BookVO;

public interface BookService {
	
	void insertBook(BookVO vo) throws Exception;
	public List<BookVO> getBooks() throws Exception;
	List<BookVO> searchByTitle(String word) throws Exception;
	List<BookVO> searchByPublisher(String word) throws Exception;
	List<BookVO> searchByPrice(int price) throws Exception;
	BookVO searchByIsbn(String word) throws Exception;
	void delete(String word) throws Exception;
	BookVO getIsbn(String word) throws Exception;
	void update(BookVO vo) throws Exception;
}

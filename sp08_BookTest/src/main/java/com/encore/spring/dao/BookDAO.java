package com.encore.spring.dao;

import java.util.List;

import com.encore.spring.vo.BookVO;

public interface BookDAO {

	void insertBook(BookVO book) throws Exception;

	List<BookVO> getBooks() throws Exception;

	List<BookVO> searchByTitle(String title) throws Exception;

	List<BookVO> searchByPublisher(String publisher) throws Exception;

	List<BookVO> searchByPrice(int price) throws Exception;

	BookVO searchByIsbn(String isbn) throws Exception;
	
	BookVO getIsbn(String word) throws Exception;

	void delete(String isbn) throws Exception;
	void update(BookVO vo) throws Exception;
}
package com.encore.rest.service;

import java.util.List;

import com.encore.rest.vo.Book;

public interface BookService {
	
	boolean insertBook(Book vo) throws Exception;
	public List<Book> getBooks() throws Exception;
	List<Book> searchByTitle(String word) throws Exception;
	List<Book> searchByPublisher(String word) throws Exception;
	List<Book> searchByPrice(int price) throws Exception;
	Book searchByIsbn(String word) throws Exception;
	boolean delete(String word) throws Exception;
	Book getIsbn(String word) throws Exception;
	boolean update(Book vo) throws Exception;
}

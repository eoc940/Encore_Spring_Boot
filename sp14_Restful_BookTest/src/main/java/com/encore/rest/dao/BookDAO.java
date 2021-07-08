package com.encore.rest.dao;

import java.util.List;
import com.encore.rest.vo.Book;
public interface BookDAO {

	boolean insertBook(Book book) throws Exception;

	List<Book> getBooks() throws Exception;

	List<Book> searchByTitle(String title) throws Exception;

	List<Book> searchByPublisher(String publisher) throws Exception;

	List<Book> searchByPrice(int price) throws Exception;

	Book searchByIsbn(String isbn) throws Exception;
	
	Book getIsbn(String word) throws Exception;

	boolean delete(String isbn) throws Exception;
	boolean update(Book vo) throws Exception;
}
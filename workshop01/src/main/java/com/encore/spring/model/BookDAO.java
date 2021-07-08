package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Book;


public interface BookDAO {
	int addBook(Book vo) throws Exception;
	List<Book> findByBookTitle(String words)throws Exception;
	List<Book> findByBookIsbn(String words)throws Exception;
	List<Book> findBooks()throws Exception;
	List<Book>  findByBookAuthor(String words)throws Exception;
}

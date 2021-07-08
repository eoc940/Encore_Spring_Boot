package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Book;


public interface bookDAO {
	int addBook(Book book) throws Exception;
	Book getBook(String isbn) throws Exception;
	List<Book> findByisbn(String isbn) throws Exception;
	List<Book> findByAuthor(String author) throws Exception;
	List<Book> findBytitle(String title) throws Exception;
	List<Book> getBookList() throws Exception;
}

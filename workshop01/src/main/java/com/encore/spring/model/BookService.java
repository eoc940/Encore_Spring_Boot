package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Book;


//Transaction처리는  1) 설정문서 2)인터페이스  3)~IMpl
public interface BookService {
	void addBook(Book vo) throws Exception;
	List<Book> findByBookTitle(String words)throws Exception;
	List<Book> findByBookIsbn(String words)throws Exception;
	List<Book> findBooks()throws Exception;
	List<Book>  findByBookAuthor(String words)throws Exception;
}

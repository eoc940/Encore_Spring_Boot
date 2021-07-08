package com.encore.spring.model;

import com.encore.spring.domain.Book;

public interface BookDAO {
	void addBook(Book book) throws Exception;
	
}

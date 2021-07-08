package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.spring.domain.Book;
import com.encore.spring.model.BookDAO;
import com.encore.spring.model.BookService;


@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDAO bookDAO;
	
	
	@Transactional
	@Override
	public void addBook(Book vo) throws Exception {
		bookDAO.addBook(vo);
		
	}

	@Override
	public List<Book> findByBookTitle(String words) throws Exception {
		return bookDAO.findByBookTitle(words);
	}

	@Override
	public List<Book> findByBookIsbn(String words) throws Exception {
		return bookDAO.findByBookIsbn(words);
	}

	@Override
	public List<Book> findBooks() throws Exception {
		return bookDAO.findBooks();
	}

	@Override
	public List<Book> findByBookAuthor(String words) throws Exception {
		return bookDAO.findByBookAuthor(words);
	}

}

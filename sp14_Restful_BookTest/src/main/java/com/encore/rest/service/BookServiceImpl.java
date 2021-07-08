package com.encore.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.rest.dao.BookDAO;
import com.encore.rest.vo.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public boolean insertBook(Book vo) throws Exception {
		return bookDAO.insertBook(vo);
	}

	@Override
	public List<Book> getBooks() throws Exception {

		return bookDAO.getBooks();
	}

	@Override
	public List<Book> searchByTitle(String word) throws Exception {

		return bookDAO.searchByTitle(word);
	}

	@Override
	public List<Book> searchByPublisher(String word) throws Exception {
		
		return bookDAO.searchByPublisher(word);
	}

	@Override
	public List<Book> searchByPrice(int price) throws Exception {

		return bookDAO.searchByPrice(price);
	}

	@Override
	public Book searchByIsbn(String word) throws Exception {

		return bookDAO.searchByIsbn(word);
	}

	@Override
	public boolean delete(String word) throws Exception {
		return bookDAO.delete(word);		
	}

	@Override
	public Book getIsbn(String word) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.getIsbn(word);
	}

	@Override
	public boolean update(Book vo) throws Exception {
		return bookDAO.update(vo);
		
	}
}

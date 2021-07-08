package com.encore.spring.model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Book;
@Service
public class bookServiceImpl implements bookService{
	
	@Autowired
	private bookDAO bookDAO;
	@Autowired
	public void setBookDAO(bookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public int addBook(Book book) throws Exception {
		return bookDAO.addBook(book);
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return bookDAO.getBook(isbn);
	}

	@Override
	public List<Book> getBookList() throws Exception {
		return bookDAO.getBookList();
	}

	@Override
	public List<Book> findByisbn(String isbn) throws Exception {
		return bookDAO.findByisbn(isbn);
	}

	@Override
	public List<Book> findByAuthor(String author) throws Exception {
		return bookDAO.findByAuthor(author);
	}

	@Override
	public List<Book> findBytitle(String title) throws Exception {
		return bookDAO.findBytitle(title);
	}

}

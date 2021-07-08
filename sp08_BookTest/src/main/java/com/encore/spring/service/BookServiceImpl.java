package com.encore.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.dao.BookDAO;
import com.encore.spring.vo.BookVO;
@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public void insertBook(BookVO vo) throws Exception {
		bookDAO.insertBook(vo);
	}

	@Override
	public List<BookVO> getBooks() throws Exception {

		return bookDAO.getBooks();
	}

	@Override
	public List<BookVO> searchByTitle(String word) throws Exception {

		return bookDAO.searchByTitle(word);
	}

	@Override
	public List<BookVO> searchByPublisher(String word) throws Exception {
		
		return bookDAO.searchByPublisher(word);
	}

	@Override
	public List<BookVO> searchByPrice(int price) throws Exception {

		return bookDAO.searchByPrice(price);
	}

	@Override
	public BookVO searchByIsbn(String word) throws Exception {

		return bookDAO.searchByIsbn(word);
	}

	@Override
	public void delete(String word) throws Exception {
		bookDAO.delete(word);
		
	}

	@Override
	public BookVO getIsbn(String word) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.getIsbn(word);
	}

	@Override
	public void update(BookVO vo) throws Exception {
		bookDAO.update(vo);
		
	}

}

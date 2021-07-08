package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Book;
import com.encore.spring.model.BookDAO;

@Repository
public class BookDAOImpl implements BookDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final String NS = "BookMapper.";
	
	@Override
	public int addBook(Book vo) throws Exception {
		int result = sqlSession.insert(NS+"addBook",vo);
		return result;
	
		
	}

	@Override
	public List<Book> findByBookTitle(String words) throws Exception {
		
		return sqlSession.selectList(NS+"findByBookTitle", words);
	}

	@Override
	public List<Book> findBooks() throws Exception {
		return sqlSession.selectList(NS+"findBooks");
	}

	@Override
	public List<Book> findByBookIsbn(String words) throws Exception {
		return sqlSession.selectList(NS+"findByBookIsbn",words);
	}
	
	@Override
	public List<Book> findByBookAuthor(String words) throws Exception {
		return sqlSession.selectList(NS+"findByBookAuthor",words);
	}


}

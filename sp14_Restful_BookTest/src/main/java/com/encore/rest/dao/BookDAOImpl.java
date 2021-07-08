package com.encore.rest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.rest.vo.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	final String ns = "BookMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean insertBook(Book vo) throws Exception{	
		return sqlSession.insert(ns+"insertBook", vo)==1 ? true : false;
	}
	

	@Override
	public List<Book> getBooks() throws Exception{
        List<Book> list = sqlSession.selectList(ns+"getBooks");        

        return list;
	}
	
	@Override
	public List<Book> searchByTitle(String word) throws Exception{
        List<Book> list = sqlSession.selectList(ns+"searchByTitle", word);
        return list;
	}

	@Override
	public List<Book> searchByPublisher(String word) throws Exception{

		 List<Book> list = sqlSession.selectList(ns+"searchByPublisher", word);        

        return list;
	}

	@Override
	public List<Book> searchByPrice(int price) throws Exception{
		List<Book> list = sqlSession.selectList(ns+"searchByPrice", price+"");
        return list;
	}

	@Override
	public Book searchByIsbn(String word) throws Exception{
        
       Book vo = sqlSession.selectOne(ns+"searchByIsbn", word);
        

        return vo;
	}


	@Override
	public boolean delete(String word) throws Exception{
		return sqlSession.delete(ns+"delete", word)==1 ? true : false;
	}
	
	
	public Book getIsbn(String word) throws Exception{
		
        return sqlSession.selectOne(ns+"getIsbn", word);
	}
	
	public boolean update(Book vo) throws Exception{
		return sqlSession.update(ns+"update", vo)==1 ? true : false;
	}
	
}

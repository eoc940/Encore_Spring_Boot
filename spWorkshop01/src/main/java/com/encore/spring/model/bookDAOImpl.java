package com.encore.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Book;
@Repository
public class bookDAOImpl implements bookDAO {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int addBook(Book book) throws Exception {
		int result=sqlSession.insert("bookMapper.addBook",book);
		return result;
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return sqlSession.selectOne("bookMapper.getBook",isbn);
	}

	@Override
	public List<Book> getBookList() throws Exception {
		return sqlSession.selectList("bookMapper.getBookList");
	}

	@Override
	public List<Book> findByisbn(String isbn) throws Exception {
		return sqlSession.selectList("bookMapper.findByisbn",isbn);
	}

	@Override
	public List<Book> findByAuthor(String author) throws Exception {
		return sqlSession.selectList("bookMapper.findByAuthor",author);
	}

	@Override
	public List<Book> findBytitle(String title) throws Exception {
		return sqlSession.selectList("bookMapper.findBytitle",title);
	}


}

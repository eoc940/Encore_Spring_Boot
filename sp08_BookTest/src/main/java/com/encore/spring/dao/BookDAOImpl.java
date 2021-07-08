package com.encore.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.vo.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {
	final String ns = "BookMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertBook(BookVO vo) throws Exception{	
		sqlSession.insert(ns+"insertBook", vo);
	}
	
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#search()
	 */
	@Override
	public List<BookVO> getBooks() throws Exception{
        List<BookVO> list = sqlSession.selectList(ns+"getBooks");        

        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#searchByTitle(java.lang.String)
	 */
	@Override
	public List<BookVO> searchByTitle(String word) throws Exception{
        List<BookVO> list = sqlSession.selectList(ns+"searchByTitle", word);
        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#searchByPublisher(java.lang.String)
	 */
	@Override
	public List<BookVO> searchByPublisher(String word) throws Exception{

		 List<BookVO> list = sqlSession.selectList(ns+"searchByPublisher", word);        

        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#searchByPrice(int)
	 */
	@Override
	public List<BookVO> searchByPrice(int price) throws Exception{
		List<BookVO> list = sqlSession.selectList(ns+"searchByPrice", price+"");
        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#search(java.lang.String)
	 */
	@Override
	public BookVO searchByIsbn(String word) throws Exception{
        
       BookVO vo = sqlSession.selectOne(ns+"searchByIsbn", word);
        

        return vo;
	}

	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#delete(java.lang.String)
	 */
	@Override
	public void delete(String word) throws Exception{
		sqlSession.delete(ns+"delete", word);
	}
	
	
	public BookVO getIsbn(String word) throws Exception{
		
        return sqlSession.selectOne(ns+"getIsbn", word);
	}
	
	public void update(BookVO vo) throws Exception{
		sqlSession.update(ns+"update", vo);
	}
	
	public static void main(String[] args) throws Exception {
		BookVO b = new BookDAOImpl().searchByIsbn("1233-111-111");
		System.out.println(b);
	}
	
}

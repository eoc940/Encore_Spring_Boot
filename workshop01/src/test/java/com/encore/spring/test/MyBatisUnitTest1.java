package com.encore.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.spring.domain.Book;


//MyBatisFramework 단위테슽으...
public class MyBatisUnitTest1 {

	public static void main(String[] args) throws Exception {
		//1. 설정문서 읽어들여서
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3.Sql Session
		SqlSession session = factory.openSession();
		
		//4. 쿼리문 실행
		/*
		 * List<Book> list = session.selectList("BookMapper.findByBookTitle","stop");
		 * 
		 * for(Book vo : list) System.out.println(vo);
		 * 
		 * System.out.println("\n=====================================\n");
		 */
		
		/*
		 * Book vo = new Book(); vo.setIsbn("111"); vo.setTitle("콩쥐팥쥐");
		 * vo.setCatalogue("무"); vo.setNation("한국"); vo.setPublisher("길벗");
		 * vo.setPublish_date("1995-10-21"); vo.setAuthor("aaa"); vo.setPrice(1500);
		 * vo.setCurrency("1200원"); vo.setDescription("해피엔딩");
		 * System.out.println(":: 1. addBook(INSERT)  ? ");
		 * session.insert("BookMapper.addBook",vo); session.commit();
		 * 
		 * 
		 * System.out.println(vo.getIsbn()+" 등록 성공");
		 */
		
	
		List<Book> list1 = session.selectList("BookMapper.findBooks");
		 for(Book vo : list1) System.out.println(vo);
	
		
		

	}

}

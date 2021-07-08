package com.encore.spring.test;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.encore.spring.domain.Book;
import com.encore.spring.model.bookDAOImpl;
import com.encore.spring.model.bookServiceImpl;




public class BookTestApp02 {

	public static void main(String[] args) throws Exception {
		
//		
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext(
//								new String[] {"/config/bookservice02.xml"});
//		//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
//		bookService bookService = (bookService)context.getBean("bookServiceImpl");
//								
								
						
		SqlSessionFactory factory = FactoryService.getFactory();
		SqlSession session = factory.openSession();
		
		bookDAOImpl dao = new bookDAOImpl();
		dao.setSqlSession(session);
		
		bookServiceImpl bookService= new bookServiceImpl();
		bookService.setBookDAO(dao);

		Book vo1 = new Book();
		vo1.setAuthor("작가444");
		vo1.setCatalogue("카탈로그444");
		vo1.setCurrency("444");
		vo1.setDescription("444");
		vo1.setIsbn("444-444-444");
		vo1.setNation("프랑스");
		vo1.setPrice(23000);
		vo1.setPublishDate("2020-01-01");
		vo1.setPublisher("xxx");
		vo1.setTitle("책444");
		
		//1. bookMapper.addBook Test 
		System.out.println("1. addBook :: "+ bookService.addBook(vo1));
		
		//2. bookMapper.getBook Test  :: insert 확인 
		System.out.println("2. getBook :: "+ bookService.getBook(vo1.getIsbn()));	
		
		//4. bookMapper.getBookList Test  :: Dynamic Query 확인
		System.out.println("4. getBookList :: "+ bookService.getBookList());
		
		//List<Book> list = bookService.findByAuthor("encore");
		//List<Book> list = bookService.findByAuthor("encore");
		List<Book> list = bookService.findBytitle("spring");
		
		for(Book b:list) {
			System.out.println(b);
		}
		
		
		
	}
	
}

package com.encore.spring.test;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.encore.spring.domain.User;
import com.encore.spring.model.userDAOImpl;
import com.encore.spring.model.userServiceImpl;




public class UserTestApp3 {

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
		
		userDAOImpl dao = new userDAOImpl();
		dao.setSqlSession(session);
		
		userServiceImpl userService= new userServiceImpl();
		userService.setUserDAO(dao);

		User user=dao.getUser("admin");
		System.out.println(user);
		
		
	}
	
}

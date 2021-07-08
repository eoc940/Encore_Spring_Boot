package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Book;
import com.encore.spring.model.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("addBook.do")
	public ModelAndView insert(Book pvo) throws Exception{
		
		System.out.println("폼으로부터 받은 데이타 "+pvo.getIsbn()); //0
		
		bookService.addBook(pvo); //여기서 dao, sqlSession, 디비 로 가서 id 값이 자동증가...--> 그 값을 다시 vo에 set해주기 떄문에
		
		System.out.println("폼으로부터 받은 데이타 "+pvo.getIsbn()); //6,7...
		return new ModelAndView("book/bookSuccess", "info", pvo);
	}
	
	@RequestMapping("bookSearch.do")
	public ModelAndView getProducts(String word, String command) throws Exception{
		String viewName = "";
		List<Book> list = null;
		
		if(command.equals("findByBookTitle")) {
			list = bookService.findByBookTitle(word);
			viewName=  "find_result";
		}else if(command.equals("findByBookIsbn")) {
			list = bookService.findByBookIsbn(word);
			viewName=  "find_result";
		}else if(command.equals("findByBookAuthor")) {
			list = bookService.findByBookAuthor(word);
			viewName=  "find_result";
		}
		return new ModelAndView(viewName, "list", list);		
	}
}





















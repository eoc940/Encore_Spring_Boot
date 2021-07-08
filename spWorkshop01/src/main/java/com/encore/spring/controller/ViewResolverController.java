package com.encore.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Book;
import com.encore.spring.domain.User;
import com.encore.spring.model.bookService;
import com.encore.spring.model.userService;

@Controller
public class ViewResolverController {
	@Autowired
	private userService userService;
	@Autowired
	private bookService bookService;
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, String userId,String userPass) throws Exception {
		String path="error";
		User user= userService.getUser(userId);
		HttpSession session = request.getSession();
		if(user!=null) {
			if(user.getPassword().equals(userPass)) {
				session.setAttribute("vo", user);
				path="loginSucess";
			}
		}
		return new ModelAndView(path);
	}
	
	//BeanNameViewResolver 컨트롤러가 어떻게 연결되는지...
	@RequestMapping("book/addBook.do")
	public ModelAndView register(Book pvo) throws Exception {
		bookService.addBook(pvo);
		System.out.println("폼으로부터 받은 데이타 "+pvo.getIsbn());
		return new ModelAndView("bookSuccess", "info", pvo);//book/bookSuccess.jsp
	}
	@RequestMapping("book/bookSearch.do")
	public ModelAndView search(String word, String command) throws Exception {
		List<Book> list = null;
		System.out.println(command);
		if((command==null)||(command.equals(""))) {
			list=bookService.getBookList();
		}
		else if(command.equals("findByTitle")) {
			list = bookService.findBytitle(word);
		}else if(command.equals("findByIsbn")) {
			list = bookService.findByisbn(word);
		}else if(command.equals("findByAuthor")) {
			list = bookService.findByAuthor(word);
		}
		return new ModelAndView("bookSearch", "list", list);
	}
}

package com.encore.spring.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.encore.spring.service.BookService;
import com.encore.spring.vo.BookVO;


@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("bookList.do")
	public ModelAndView getBooks() throws Exception{
		List<BookVO> list=bookService.getBooks();
		
		for(BookVO b : list) System.out.println(b);
		
		return new ModelAndView("book/bookList","list",list); //web-inf/views/book/bookList
	}
	
	@RequestMapping("bookRegister.do")
	public ModelAndView register(BookVO book,HttpServletRequest request ,HttpSession session) throws Exception{
		System.out.println("register BookVO before ::"+book);
		
		String isbn1 = request.getParameter("isbn1").trim();
		String isbn2 = request.getParameter("isbn2").trim();
		String isbn3 = request.getParameter("isbn3").trim();
		book.setIsbn(isbn1+"-"+isbn2+"-"+isbn3);
		
		System.out.println("Resister BookVO after :: "+book);
		
		String msg = "";
		String path = "Error.jsp";
		
		try {
			bookService.insertBook(book);; //정상적으로 book이 add되었다.
			// 디비에 성공적으로 등록을 하면 다시 이곳으로 리턴된다.
			msg = "책 정보가 정상적으로 디비에 저장되었습니다";
			path = "result.jsp"; 
		}catch(Exception e) {
			// 디비에 성공적으로 등록을 하지 못하면
			System.out.println(e);
			msg = "책 정보 저장중..오류발생...";
		}
		//바인딩
		session.setAttribute("msg", msg);  
		return new ModelAndView("redirect:"+path);
		//requset로 하면 ModelAndView에서 servlet-context통해 view안에 result를 넣어둠
		//result.jsp 파일은 views 밖에 있기때문에 session으로 해야됨
	}
	
	@RequestMapping("bookSearch.do")
	public ModelAndView search(String searchField, String searchText, HttpServletRequest request) throws Exception{
		System.out.println(searchField+','+searchText);
		
		List<BookVO> list = null;
		String path = "find_fail";
		
		try {
			switch(searchField) {
			case "TITLE":
				list = bookService.searchByTitle(searchText);
				break;
			case "PUBLISHER":
				list = bookService.searchByPublisher(searchText);
				break;
			case "PRICE":
				list = bookService.searchByPrice(Integer.parseInt(searchText));
				break;
			default:
				list = bookService.getBooks();
			}
			path = "book/bookList";
			request.setAttribute("field", searchField);
			request.setAttribute("text", searchText);
			
		}catch(Exception e) {
			System.out.println(e);
			request.setAttribute("msg", "도서 검색중 오류 발생했습니다.");
		}
		
		return new ModelAndView(path,"list",list);
	}
	
	@RequestMapping("bookDesc.do")
	public ModelAndView desc(String isbn, HttpServletRequest request) {
		
		String path = "find_fail.jsp";
		BookVO book = null;
		
		try {
			
			book = bookService.searchByIsbn(isbn);
			path = "book/bookView";
			System.out.println(isbn);
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return new ModelAndView("JsonView", "book", book);
	}

}

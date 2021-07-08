package com.encore.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.service.BookService;
import com.encore.rest.vo.Book;

@RestController
@RequestMapping("api")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("book")
	public ResponseEntity<List<Book>> getAllBook() throws Exception {
		List<Book> books = bookService.getBooks();
		if(books.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(books, HttpStatus.OK);
	}
	
	// 특정한 isbn에 해당하는 책 1권을 받아오는 요청을 작성
	// contextpath/api/book/1233-111-111
	@GetMapping("book/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable String isbn) throws Exception {
		Book book = bookService.searchByIsbn(isbn);
		if(book==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(book, HttpStatus.OK);
	}
	
	// 특정한 책을 등록하는 기능..insert..doPost()
	@PostMapping("book")
	public ResponseEntity<Book> insertBook(@RequestBody Book book) throws Exception {
		boolean check = bookService.insertBook(book);
		if (!check) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK);
	}

	// 특정한 책을 수정하는 기능..update..doPut()
	@PutMapping("book")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) throws Exception {
		boolean check = bookService.update(book);
		
		if (!check) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK); // 가지고 나오는 거 없으므로 상태값만 넣어줌
	}
	
	// 특정한 책을 삭제하는 기능..delete..doDelete()
	@DeleteMapping("book/{isbn}")
	public ResponseEntity<List<Book>> deleteBook(@PathVariable String isbn) throws Exception {
		boolean check = bookService.delete(isbn);
		if (!check) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK); // 가지고 나오는 거 없으므로 상태값만 넣어줌
	}
	
	
	
	
}

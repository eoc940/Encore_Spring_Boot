package com.encore.rest.vo;

import java.io.Serializable;

/**
 *<pre>
 * 도서 정보를 저장하고, 전달하기 위한 클래스
 *</pre>
 */
public class Book implements Serializable{
	private String isbn;  
	private String title;
	private String catalogue="";
	private String nation;
	private String publishDate;
	private String publisher;	
	private String author;
	private int  price;
	private String currency;
	private String description;
	public Book() {
		super();
	}
	public Book(String isbn, String title, String catalogue, String nation,
			String publishDate, String publisher, String author, int price,
			String currency, String description) {
		super();
		setIsbn(isbn);
		setTitle(title);
		setCatalogue( catalogue);
		setNation(nation);
		setPublishDate(publishDate);
		setPublisher(publisher);
		setAuthor(author);
		setPrice(price);
		setCurrency(currency);
		setDescription(description);
	}
	public Book(String isbn, String title, String catalogue, String nation,
			String publishDate, String publisher, String author, int price,
			 String description) {
		super();
		setIsbn(isbn);
		setTitle(title);
		setCatalogue( catalogue);
		setNation(nation);
		setPublishDate(publishDate);
		setPublisher(publisher);
		setAuthor(author);
		setPrice(price);		
		setDescription(description);
	}
	public Book(String isbn, String title, String author, int price,String currency) {
		super();
		setIsbn(isbn);
		setTitle(title);
		setAuthor(author);
		setPrice(price);
		setCurrency(currency);
	}

	public Book(String isbn, String title, String author,String publisher, String description) {
		super();
		setIsbn(isbn);
		setTitle(title);	
		setAuthor(author);	
		setPublisher(publisher);
		setDescription(description);
	}
//	public Book(String isbn, String title, String catalogue, String author, String description) {
//		super();
//		setIsbn(isbn);
//		setTitle(title);
//		setCatalogue( catalogue);
//		setAuthor(author);
//		setDescription(description);
//	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=");
		builder.append(isbn);
		builder.append(", title=");
		builder.append(title);
		builder.append(", catalogue=");
		builder.append(catalogue);
		builder.append(", nation=");
		builder.append(nation);
		builder.append(", publishDate=");
		builder.append(publishDate);
		builder.append(", publisher=");
		builder.append(publisher);
		builder.append(", author=");
		builder.append(author);
		builder.append(", price=");
		builder.append(price);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
}
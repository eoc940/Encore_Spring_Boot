package com.encore.rest.dto;

public class Customer {

	private String name;
	private String message;
	public Customer(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}
	public Customer() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", message=" + message + "]";
	}
	
	
	
}

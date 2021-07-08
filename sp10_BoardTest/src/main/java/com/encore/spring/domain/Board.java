package com.encore.spring.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
public class Board implements Serializable {
	private int no        	 ;
	private String id        ;
	private String title     ;
	private String contents  ;
	private MultipartFile uploadFile;
	private String fileName;
	
	
	public Board() {};
	
	public Board(String id, String title, String contents, String fileName) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.fileName = fileName;
	}

	public Board(String id, String title, String contents, MultipartFile uploadFile) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.uploadFile = uploadFile;
	}

	public Board(int no, String id, String title,  String contents, MultipartFile uploadFile) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.uploadFile = uploadFile;
	}
	
	@Override
	public String toString() {
		return "Board [no=" + no + ", id=" + id + ", title=" + title + ", contents=" + contents + ", uploadFile="
				+ uploadFile + ", fileName=" + fileName + "]";
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	
}

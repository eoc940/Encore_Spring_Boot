package com.encore.pms.dto;
/*
 DROP TABLE userinfo;
  
 CREATE TABLE userinfo
 (id varchar(20) primary key,
  pw varchar(30) not null); 
 
 INSERT INTO userinfo (id, pw) VALUES('encore','1234');
 */
public class UserInfo {
	private String id;
	private String pw;

	public String getId() {
		return id;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pw=" + pw + "]";
	}

}

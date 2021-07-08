package com.encore.spring.vo;

public class MemberVO {
  private String id;
  private String pw;
  private String name;
  private String nickName;
  private String email;
  private String homePage;
  private String address;
  private String[] hobby;
public MemberVO() {
	super();
}
public MemberVO(String id, String pw, String name, String nickName,
		String email, String homePage, String address, String[] hobby) {
	super();
	this.id = id;
	this.pw = pw;
	this.name = name;
	this.nickName = nickName;
	this.email = email;
	this.homePage = homePage;
	this.address = address;
	this.hobby = hobby;
}
public String getId() {
	return id;
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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getHomePage() {
	return homePage;
}
public void setHomePage(String homePage) {
	this.homePage = homePage;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getHobby(){
	StringBuilder sb=new StringBuilder();
	for(String s: hobby){
		sb.append(s);
		sb.append(" ");
	}
	return sb.toString();
}
public void setHobby(String hobbys){
	this.hobby=hobbys.split(" ");
}
public void setHobby(String[] hobby) {
	this.hobby = hobby;
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Member [id=");
	builder.append(id);
	builder.append(", pw=");
	builder.append(pw);
	builder.append(", name=");
	builder.append(name);
	builder.append(", nickName=");
	builder.append(nickName);
	builder.append(", email=");
	builder.append(email);
	builder.append(", homePage=");
	builder.append(homePage);
	builder.append(", address=");
	builder.append(address);
	builder.append(", hobby=");
//	builder.append(getHobby());
	builder.append("]");
	return builder.toString();
}
  
}

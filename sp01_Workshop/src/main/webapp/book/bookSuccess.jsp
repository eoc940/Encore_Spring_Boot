<%@page import="servlet.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>결과 페이지</h2><br>
	<h3>${book.title} 정상적으로 저장되었습니다</h3><br><br>
	
	<a href="book/Book.html">추가등록</a>
	
	<a href="front.do?command=showBooks">도서목록</a>

</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서정보</title>


<style>
 th{text-align:"center"; background-color:lightgray;}

</style>
</head>
<body>

<h3 align="center">도서 목록 보기 </h3><p>

<form action="bookSearch.do"  method="get" align ="right">
		<input type="hidden" name="action" value="search">
<select name="searchField" id="searchField" >
	<option value="">====아래에서 선택하세요 ====</option>
	<option value="findByBookTitle">제목으로 검색하기</option>
	<option value="findByBookIsbn">isbn으로 검색하기</option>
	<option value="findByBookAuthor">저자로 검색하기</option>
</select>
<input type="text" name="word"><br><br>
<input type="submit" value="검색">
</form>
<table border="1" width="850" bgcolor="white" align="center">

	
	<tr>
		<th>도서번호</th>
		<th>도서명</th>
		<th>도서분류</th>
		<th>저자</th>
	</tr>
	
	<c:forEach items="${list}" var="bo">
	<tr>	
		<td>${bo.isbn}</td>
		<td><a href="#" onclick="startRequest()" id="title">${bo.title}</a></td>
		<td>${bo.catalogue}</td>
		<td>${bo.author}</td>
		
	</tr>
	</c:forEach>
</table>

	<h6 align="center"> <a href="../Book.jsp" >도서검색하기</a></h6>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/basic.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
	<h2>게시판 목록</h2>
	<table border="2px">
		<thead>
			<tr>
				<th>번호</th><th>제목</th><th>내용</th><th>아이디</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.no}</td><td><a href="boardDetail.do?no=${board.no}">${board.title}</a></td><td>${board.contents}</td><td>${board.id}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<button onClick="location.href='/spring/index.jsp'">메인으로</button >
</body>
</html>
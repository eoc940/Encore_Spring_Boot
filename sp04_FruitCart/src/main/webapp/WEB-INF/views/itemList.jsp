<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Fruit Total List 1.</h1>
<table align="center">
	<tr>
		<c:forEach items="${list}" var="item">
			<td>
				<a href="itemView.do?itemNumber=${item.itemNumber}"><img alt="" src="${item.url}" width="150" height="150"></a><br>
				상품명 : ${item.name}<br>
				가 격 : ${item.price}
				
			</td>
		</c:forEach>
	</tr>
</table>
<c:if test="${!empty fruits}">
<h2 align="center"><font color="purple">오늘 본 상품들</font></h2>
<!-- 오늘 본 상품정보를 이곳에다가 테이블 형식으로 출력해보세요 :: forEach -->
<table align="center" bgcolor="lightgray">
	<tr>
		<c:forEach items="${fruits}" var="fruit">
			<td>
				<img alt="" src="${fruit}" width="100" height="100"><br>
			</td>
		</c:forEach>
	</tr>
</table>
</c:if>
</body>
</html>
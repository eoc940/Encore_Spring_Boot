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
<table align="center">
	
		<c:forEach items="${list}" var="item">
		<tr>
			<td>
				ID : ${item.id}&nbsp;&nbsp;
				제품명 : ${item.name}&nbsp;&nbsp;
				제조사 : ${item.maker}&nbsp;&nbsp;
				가 격 : ${item.price}
				
			</td>
		</tr>
		</c:forEach>
	
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${success eq 1}">
     등록 성공!!
</c:if>
<c:if test="${success eq 0}">
   등록 실패!!
</c:if>
<a href="productRegister.jsp">돌아가기</a>
</body>
</html>
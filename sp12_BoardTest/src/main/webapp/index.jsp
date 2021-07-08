<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout(){
		var f=confirm("로그아웃 하시겠습니까?");
		if(f)
			location.href="logout.do"; 
	}
</script>
</head>
<body>
<h2 align="center">Board Write, Update, Delete, Select</h2><p>

<c:choose>
<c:when test="${empty mvo}">
	<form method="post" action="login.do">		
		ID :<input type="text" name="id"><p>
		PASS :<input type="password" name="password"><p>
		<input type="submit" value="로그인">
	</form><p>
</c:when>
<c:otherwise>
${mvo.name} 님은 로그인 상태입니다..<br><br>
<a href="javascript:logout()">로그아웃</a><p><hr>
<a href="board/write.jsp"><img alt="게시판 글쓰기" src="img/write_btn.jpg" border="0"></a>
</c:otherwise>
</c:choose>

<a href="list.do"><img alt="게시판 목록" src="img/list_btn.jpg" border="0"></a>
</body>
</html>





























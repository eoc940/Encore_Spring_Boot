<%--
로그아웃 로직 
1. 세션에 바인딩 된 정보가 있다면 
2. 세션을 죽인다. invalidate()
3. 다시 홈으로/ 로그인 페이지로

 --%>

<%@page import="com.encore.spring.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	User vo = (User) session.getAttribute("vo");
	if(vo==null){//로그인 안된 상태이다..
%>
	<b><a href="login.html">로그인</a></b>
	
	<%
	}else{//로그인 된 상태라면 
		session.invalidate();
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logoutpop(){
		alert("LOG OUT");
	}
</script>
</head>
<body onload="return logoutpop()">
	<b>로그아웃 되셨습니다</b><br/>
	<a href="../index.jsp">HOME</a>
</body>
</html>







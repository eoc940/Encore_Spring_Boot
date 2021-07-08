<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${!empty loginUser}">
	<div>
		${loginUser.id}님 로그인 되었습니다  &nbsp; <a href="logout.do">로그아웃</a>
	</div>
</c:if>

<h2><b>${title}</b></h2>
<!--<c:url value="/js/jquery-3.3.1.js" var="jquery" />
<script src="${jquery}"></script> -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
<link href="resources/css/basic.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
	<h2>파일 업로드 테스트</h2>
	<form action="addPost.do">
		제목: <input type="text" id="title" name="title">
		아이디: <input type="text" id="user_id" name="user_id">
		내용: <textarea rows="50" cols="20" id="content"></textarea>
		파일: <input type="file" name="uploadFile" id=""file">
		
		<input type="submit" value="작성"> 
		<input type="reset" id="btn" value="취소" />
	</form>
</body>
</html>
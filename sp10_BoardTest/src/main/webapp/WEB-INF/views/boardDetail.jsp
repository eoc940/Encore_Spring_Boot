<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardDetail</title>
<link href="resources/css/basic.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
	<h1>${vo.no} ${vo.title}</h1>
	<h2>${vo.id}</h2>
	<p>${vo.contents}</p>
	<a href="fileDown.do?filename=${vo.fileName}">${vo.fileName }</a><br>
	
	<a href="fileDown.do?filename=${vo.fileName}"><img alt="" src="${filepath}${vo.fileName}"></a>
	
	<br><br>
	 <button onclick="history.back()">목록보기</button> &nbsp;
	<button onClick="location.href='/spring/index.jsp'">메인으로</button >
</body>
</html>
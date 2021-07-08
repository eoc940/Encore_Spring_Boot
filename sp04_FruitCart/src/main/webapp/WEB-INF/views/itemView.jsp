<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
		$('#put').click(function() {
			localStorage.setItem("item", ${item});
		});
	
	});
	$(function() {
		$('#show').click(function() {
			
		});
	});
	
	
	//javascript
	function showAll() {
		
		
	}
	
</script>
<style type="text/css">
	#first {
		background-color: threedlightshadow;
	}
	*{
		color:navy;
	}
	
</style>
</head>
<body>

 
<h1 align="center"><b>${item.name}</b></h1>
<table align="center" width="600" id="first">
	<tr>
		<td align="center">
			조회수 : ${item.count} &nbsp;&nbsp;
			<button id="put">장바구니 담기</button>&nbsp;<button id="show">장바구니 확인</button>
		</td>
	</tr>
</table>
<table align="center" width="600">
	<tr>
		<td rowspan="3">
			<img alt="" src="${item.url}">
		</td>
		<td>종류 : ${item.name}</td>
	</tr>
	<tr>
		<td>가격 : ${item.price}</td>	
	</tr>
	<tr>
		<td>설명 : ${item.description}</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><a href="itemList.do">상품 목록 보기</a>
	</tr>
</table>
<table align="center">
	<c:forEach items="">
		
	</c:forEach>
</table>

</body>
</html>

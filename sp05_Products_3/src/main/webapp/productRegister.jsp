<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Product Register Form....</h2>
<form action="myProduct.do" method="post">
상품명 : <input type="text" name="name"><br><br>
제조사 : <input type="text" name="maker"><br><br>
가   격 : <input type="text" name="price"><br><br>
<input type="submit" value="상품등록">
</form>
++++++++++++++++++++++++++++

<form action="productSearchByName.do" method="post">
상품검색 : <input type="text" name="productName" placeholder="상품명을 입력하지 않으면 전체 검색됩니다">
<input type="submit" value="상품찾기">
</form>
<form action="productSearchByMaker.do" method="post">
제조사검색 : <input type="text" name="productMaker" placeholder="제품명을 입력하지 않으면 전체 검색됩니다">
<input type="submit" value="상품찾기"><br>
</form>
<form action="productSearchById.do" method="post">
ID검색 : <input type="text" name="productId" placeholder="ID을 입력하지 않으면 전체 검색됩니다">
<input type="submit" value="상품찾기">
</form>
</body>
</html>


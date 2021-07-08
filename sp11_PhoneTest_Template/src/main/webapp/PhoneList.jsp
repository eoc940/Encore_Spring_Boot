<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function deletePhone(){
		var values = [];
		var list = $("input[name='phoneCheck']");
		for(var i = 0; i < list.length; i++) {
			if(list[i].checked) {
				values.push(list[i].value);
			}
		}
		
		if(values.length == 0) {
			alert("휴대폰을 선택해주세요");
		}else {
			var alarm = confirm("정말 삭제하시겠습니까?");
			
			$.ajax({
				url : "delete.do",
				type : 'post',
				traditional:true,
				data : {values : values},
				success : function(rdata) {
					
					location.replace("searchPhone.do");
					alert("삭제 성공");
					
				},
				error:function(xhr, status, message) {
					alert("error : " + message);
				}
				
			});
		}
	}
</script>

</head>
<body>	
	<jsp:include page="/header.jsp" />
	
	<table>
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
			<th>삭제</th>
		</tr>		
		<c:forEach items="${phoneList}" var="phone">
			<tr>
				<td><a href="detail.do?num=${phone.num}">${phone.num}</a></td>
				<td>${phone.model}</td>
				<td>${phone.price}</td>
				<td>${phone.company.vendor}</td>
				<td><input type="checkbox" name="phoneCheck" value="${phone.num}"></td>
			</tr>
		</c:forEach>
	</table>
	<a href="regPhone.do">추가 등록</a>&nbsp;
	<a href="" onclick="deletePhone();" id="selectedDel">선택항목삭제</a><!-- 버튼 안만들고 href=""주고 위에서 ajax type post로 하면 onclick()시 실행된다 -->
</body>
</html>
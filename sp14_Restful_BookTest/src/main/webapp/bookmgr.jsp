<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
		width:800px;
		margin:0 auto;
	}
</style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#allBooks').click(function() {
			allBook(); //함수호출만 해준다
		});//click
	});//function
	
	function allBook() {
		//비동기 시작
		$.ajax({
			url:"api/book",
			type:'get', //post, put, delete 쓸 수 있음
			contentType:"application/json;charset=utf-8",
			
			error: function(xhr, status, message) {
				alert("error : " + message);
			},
			
			success: function(data) {
				//alert(data);
				$('#book-list').empty();
				$('#book-list').append("<ul>");
				for(var i=0; i<data.length; i++) {
					$('#book-list').append("<li onclick=bookInfo('" + data[i].isbn + "')>" +data[i].isbn + "</li>");//isbn이 연산으로 진행되어 문자열 처리 잘 해주어야 함
				}
				$('#book-list').append("</ul>");
			}//callback
		});//ajax
	}//allBook
	
	function bookInfo(isbn) {
		$.ajax({
			url:"api/book/" + isbn,
			type:"get",
			contentType:"application/json;charset=utf-8",
			
			error:function(xhr,status,message) {
				alert("error : " + message);
			},
			
			success:function(data) {
				
				$('#book-info').empty();
				var temp = "";
				temp += "<input type='button' value='추가' onclick=bookInsert()>"
				temp += "<input type='button' value='수정' onclick=bookUpdate()>"
				temp += "<input type='button' value='삭제' onclick=bookDelete('" + data.isbn +"')>" // ''이 data.isbn이 문자열이라는 것을 나타냄
				temp += "<table>";
				temp += "<tr><td>ISBN</td><td><input type='text' name='isbn' value='" + data.isbn +"'></td></tr>";
				temp += "<tr><td>제  목</td><td><input type='text' name='title' value='" + data.title +"'></td></tr>";
				temp += "<tr><td>저  자</td><td><input type='text' name='author' value='" + data.author +"'></td></tr>";
				temp += "<tr><td>출판사</td><td><input type='text' name='publisher' value='" + data.publisher +"'></td></tr>";
				temp += "<tr><td>상세내용</td><td><textarea name='description'>" + data.description + "</textarea></td></tr></table>";
				
				$('#book-info').append(temp);
				
			}
		});//ajax
		
	}//bookInfo
	
	function bookInsert() { // 하나의 Book 객체를 서버로 전송하는 기능...처음 나왔다...비동기로 보낸다(JSON 타입으로 바꿔서 전송)
		$.ajax({
			url:"api/book",
			type:"post",
			data:JSON.stringify({ // json 타입이라 { }넣어준다
				"isbn":$('input[name=isbn]').val(),
				"title":$('input[name=title]').val(),
				"author":$('input[name=author]').val(),
				"publisher":$('input[name=publisher]').val(),
				"description":$('textarea[name=description]').val()
			}),
			
			contentType:"application/json;charset=utf-8",
			
			error:function(xhr,status,message) {
				alert("error : " + message);	
			},
			success:function(data) {
				allBook();
			}
			
		});//ajax
	}//bookInsert
	
	function bookUpdate() {
		$.ajax({
			url:"api/book",
			type:"put",
			data:JSON.stringify({ // json 타입이라 { }넣어준다
				"isbn":$('input[name=isbn]').val(),
				"title":$('input[name=title]').val(),
				"author":$('input[name=author]').val(),
				"publisher":$('input[name=publisher]').val(),
				"description":$('textarea[name=description]').val()
			}),
			
			contentType:"application/json;charset=utf-8",
			
			error:function(xhr) {
				alert("error : " + xhr.status);	
			},
			success:function(data) {
				allBook();
			}
		});//ajax
	}
	
	function bookDelete(isbn) {
		$.ajax({
			url:"api/book/" + isbn,
			type:"delete",
			contentType:"application/json;charset=utf-8",
			
			error:function(xhr) {
				alert("error : " + xhr.status);
			},
			success:function(data) {
				allBook();
				$('#book-info').empty(); // 삭제하고 정보 보여주는 부분을 지워줌
			}
		});//ajax
	}
	
</script>
</head>
<body>
	<div align="center"><h1>Welcome To PlayData</h1></div>
	<div style="text-align:right;">
		<a href="#">아이디</a>
		<a href="#">로그아웃</a>
	</div>
	<hr>
	<h2>도 서 관 리</h2>
	<input type="button" value="도서목록조회" id="allBooks">
	<div id="book-list"></div>
	<br>
	<div id="book-info"></div>
</body>
</html>







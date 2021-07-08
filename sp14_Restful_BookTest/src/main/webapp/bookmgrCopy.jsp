<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		width: 800px;
		margin: 0 auto;
		/* font-family: d2Coding; */
	}
	table{
		border:  1px solid gray;
		
	}
	.g{
		background-color: gray;
	}
	.textarea{
		width: 215px;
	}
</style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function() {
	$('#allBooks').click(function() {
		allBook();
	});//click
});//function

function allBook() {
	//비동기 시작...
	$.ajax({
		url:"api/book",
		type:'get',
		contentType:"application/json;charset=utf-8",
		dataType:'json',
		error: function(xhr, status, message){
			alert("error : "+message);
		},
		
		success:function(data){
			//alert(data);
			$('#book-list').empty();
			$('#book-list').append("<ul>");
			for(var i=0; i<data.length; i++){
				$('#book-list').append("<li onclick=bookInfo('"+data[i].isbn+"')>"+ data[i].isbn+"</li>");
			}
			$('#book-list').append("</ul>");		
			
		}//callback
	});//ajax
}//allBook

function bookInfo(isbn) {	
	$.ajax({
		url:"api/book/"+isbn,
		
		type:"get",
		contentType:"application/json;charset=utf-8",
		
		error:function(xhr, status, message){
			alert("error : "+message);
		},
		
		success:function(data){
			console.info(data);
			$('#book-info').empty();
			var temp = "";
			temp +="<input type='button' value='추가' onclick='bookInsert()'>";
			temp +="<input type='button' value='수정' onclick='bookUpdate()'>";
			temp +="<input type='button' value='삭제' onclick=bookDelete('"+data.isbn+"')>";
			temp +="<p></p><table>";
			temp +="<tr><td class=g>ISBN</td><td><input type='text' name='isbn' value='"+data.isbn+"'></td></tr>";
			temp +="<tr><td class=g>제 목</td><td><input type='text' name='title' value='"+data.title+"'></td></tr>";
			temp +="<tr><td class=g>저 자</td><td><input type='text' name='author' value='"+data.author+"'></td></tr>";
			temp +="<tr><td class=g>출판사</td><td><input type='text' name='publisher' value='"+data.publisher+"'></td></tr>";
			temp +="<tr><td colspan=2><textarea name='description' class='textarea'>"+data.description+"</textarea></td></tr></table>";
			
			$('#book-info').append(temp);
		}
	});//ajax
}//bookInfo

//하나의 Book객체를 서버로 전송하는 기능...처음 나왔다...비동기로 보낸다(JSON 타입으로 바꿔서 전송).
function bookInsert() { 
	$.ajax({
		url:"api/book",
		type:"post",
		data:JSON.stringify({
			"isbn":$('input[name=isbn]').val(),
			"title":$('input[name=title]').val(),
			"author":$('input[name=author]').val(),
			"publisher":$('input[name=publisher]').val(),
			"description":$('textarea[name=description]').val(),
		}),
		
		contentType:"application/json;charset=utf-8",
		
		error:function(xhr){
			alert("error "+ xhr.status);
		},		
		success:function(data){		
				alert("INSERT 성공");	
				allBook();
		}		
	});//ajax
}//bookInsert

function bookUpdate() {
	$.ajax({
		url:"api/book",
		type:"put",
		data:JSON.stringify({
			"isbn":$('input[name=isbn]').val(),
			"title":$('input[name=title]').val(),
			"author":$('input[name=author]').val(),
			"publisher":$('input[name=publisher]').val(),
			"description":$('textarea[name=description]').val(),
		}),
		
		contentType:"application/json;charset=utf-8",
				
		error:function(xhr){
			alert("error "+ xhr.status);
		},		
		success:function(data){		
				alert("UPDATE 성공");	
				allBook();
		}		
	});//ajax
}//bookUpdate


function bookDelete(delIsbn) {
	$.ajax({
		url:"api/book/"+delIsbn,
		type:"delete",
		
		error:function(xhr){
			alert("error : "+xhr.status);
		},
		
		success:function(data){
			alert("DELETE 성공");
			allBook();
			$('#book-info').empty();
		}
	});//ajax
}//bookDelete
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
	<input type="button" value="도서목록조회" id="allBooks">  (상세 내용 조회는 목록의 ISBN 아이템을 클릭하세요.)
	<div id="book-list"></div>
	<br>
	<div id="book-info"></div>
</body>
</html>














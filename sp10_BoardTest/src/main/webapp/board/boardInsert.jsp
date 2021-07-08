<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가</title>
<link href="resources/css/basic.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#fileForm").submit(function(){
			var isEmpty = false;
			var form = $("#fileForm").serialize();
			var title = $(this).find('[id=title]').val();
			var id = $(this).find('[id=id]').val();
			var contents = $(this).find('[id=contents]').val();
			var uploadFile = $(this).find('[id=uploadFile]').val();
			
			if(title == ""){
				isEmpty = true;
			}else if(id == ""){
				isEmpty = true;
			}else if(contents == ""){
				isEmpty = true;
			}else if(uploadFile == ""){
				isEmpty = true;
			}
			
			if(isEmpty == true){
				alert("모든 항목을 입력해주세요.");
				return false;
			}
			
		});
	});
</script>
</head>
<body>
	<h2>파일 업로드 테스트</h2>
	<form id="fileForm" method="post" action="boardInsert.do" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목: </td>
				<td><input type="text" id="title" name="title"></td>
			</tr>
			<tr>
				<td>아이디: </td>
				<td><input type="text" id="id" name="id"></td>
			</tr>
			<tr>
				<td>내용: </td>
				<td><textarea rows="15" cols="50" name="contents" id="contents"></textarea></td>
			</tr>
			<tr>
				<td>파일: </td>
				<td><input type="file" name="uploadFile" id="uploadFile"></td>
			</tr>	
		</table>

		<br><br>
		<input type="submit" value="작성"> 
		<input type="reset" id="reset" value="초기화" />
	</form><br>
	<button onClick="location.href='/spring/index.jsp'">메인으로</button >
</body>
</html>
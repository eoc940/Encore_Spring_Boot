<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function content_submit(){
	var f=document.write_form;
	if(f.title.value==""){
		alert("제목을 입력하세요!");
		f.title.focus();
		return; 
	}	
	if(f.content.value==""){
		alert("내용을 입력하세요!");
		f.content.focus();
		return;
	}
	f.submit();
}
</script>
</head>
<font face="HY나무L" size="5"><strong>글쓰기 <br><br></strong></font>
  <form action="../write.do" method="post" name="write_form">
   <table>
    <tr>
     <td>제목</td>
     <td>
     <input type="text" name="title" maxlength="100" size="30">
     </td>
    </tr>
    <tr>
     <td colspan="2">
     <textarea cols="35" rows="10" name="content"></textarea>
     </td>
    </tr> 
    <tr>
     <td colspan="2"  >
      <img src="../img/confirm.gif"  onclick="content_submit()">
     </td>  
    </tr>
   </table>
  </form>
</html>
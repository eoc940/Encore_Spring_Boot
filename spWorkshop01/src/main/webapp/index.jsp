
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8">
	<title>Login Page</title>
	<style>
	    * {
	        margin: 0;
	        padding: 0;
	    }
	    div {
	        float: left;
	        width: 50%;
	        height: 100vh;
	    }
	    .book {
	        background-image: url(https://cdn.pixabay.com/photo/2016/08/24/16/20/books-1617327_1280.jpg);
	    }
	    .main {
	        width: 50%;
	        height: 100vh;
	    }
	    .main h2 {
	        text-align: center;
	        margin-top: 200px;
	        margin-bottom: 40px;
	    }
	    .main form {
	        width: 400px;
	        margin: 0 auto;
	    }
	    .main p {
	        margin-bottom: 20px;
	    }
	    .main input {
	        float: right;
	    }
	    .main input[type=text], .main input[type=password] {
	        width: 280px;
	        padding: 3px;
	    }
	    .main input[type=submit] {
	        clear: both;
	        margin-top: 20px;
	        width: 100%;
	        background: indigo;
	        border: none;
	        color: white;
	        padding: 15px;
	    }
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	    $(function() {
	        $('#frm').submit(function() {
	            if($('#userId').val()=="") {
	                alert("ID를 입력해주세요.");
	                $('#userId').focus();
	                return false;
	            }
	            if($('#userPass').val()=="") {
	                alert("PASSWORD를 입력해주세요.");
	                $('#userPass').focus();
	                return false;
	            }
	        });
	    });
	</script>
</head>
<body>
	<div class="book"></div>
    <div class="main">
        <h2>로그인하여 주세요</h2>
        <form action="login.do" method="post" id="frm">
        	<input type="hidden" name="command" value="login">
            <p><span>ID</span><input type="text" name="userId" id="userId"></p>
            <p><span>PASSWORD</span><input type="password" name="userPass" id="userPass"></p>
            <input type="submit" value="LOGIN">
        </form>
    </div>
</body>
</html>
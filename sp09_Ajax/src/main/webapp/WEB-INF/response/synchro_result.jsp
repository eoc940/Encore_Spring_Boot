<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xhr;
	function startRequest() {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("get", "asynch");
		xhr.send(null);
	}
	
	//응답하는 코드부분 로직..
	function callback() {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				var jsonData = JSON.parse(xhr.responseText);
				//alert(jsonData.person.name + "님이 사는 곳은 " + jsonData.person.address);
				document.getElementById("jsonView").innerHTML = "<h4>" + jsonData.person.name + "의 주소는 "
				+ jsonData.person.address +"</h4>"
			}
		}
	}
</script>
</head>
<body>
${info}
<p></p>
<input type="button" value="비동기 통신" onclick="startRequest()">
<p id="jsonView"></p>

</body>
</html>
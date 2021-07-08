<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		width: 400px;
		margin: 0 auto;
		background-color: lightgray;
		/* font-family: d2Coding; */
	}
	table tr td{
		border:  1px solid black;
		
	}
	.g{
		background-color: gray;
	}
	.textarea{
		width: 215px;
	}
</style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	allPhone();
	
});//function

function allPhone() {
	$.ajax({
		url:"phone",
		type:"get",
		contentType:"application/json;charset=utf-8",
		dataType:'json',
		error: function(xhr){
			alert("error : "+xhr.status);
		},
		success: function(data) {
			$('#phone-list').empty();
			var tmp = "";
			vendorMap = new Map();
			tmp += "<table id='phoneList'>"
			tmp += "<tr><td>모델번호</td><td>모델이름</td><td>가격</td><td>제조사명</td></tr>"
			for(var i=0; i<data.length; i++) {
				tmp += "<tr onclick=phoneInfo('" + data[i].num + "')>";
				tmp += "<td>" + data[i].num + "</td>";
				tmp += "<td>" + data[i].model + "</td>";
				tmp += "<td>" + data[i].price + "</td>";
				tmp += "<td>" + data[i].company.vendor + "</td>";
				tmp += "</tr>";
				vendorMap.set(data[i].vcode, data[i].company.vendor);
			}
			tmp += "</table>"
			$('#phone-list').append(tmp);
			
		}
	})
}//allPhone

function phoneInfo(num) {
	$.ajax({
		url:"phone/" + num,
		type:"get",
		contentType:"application/json;charset=utf-8",
		dataType:'json',
		error: function(xhr){
			alert("error : "+xhr.status);
		},
		success: function(data) {
			$('#phone-info').empty();
			var tmp = "";
			tmp += "<table>";
			tmp += "<tr><td>모델번호</td><td><input type='text' name='num' value='"+data.num+"'></td></tr>";
			tmp += "<tr><td>모델명</td><td><input type='text' name='model' value='"+data.model+"'></td></tr>";
			tmp += "<tr><td>모델가격</td><td><input type='text' name='price'value='"+data.price+"'>원</td></tr>";
			tmp += "<tr><td>제조사</td><td>";
			tmp += "<select id='vendors'>";
			for(let key of vendorMap.keys()) {
				tmp += "<option value="+key+">"+ vendorMap.get(key) +"</option>";
			}
			tmp += "</select>";
			tmp += "</td></tr>";
			tmp +="<input type='button' value='추가하기' onclick='phoneInsert()'>";
			tmp +="<input type='button' value='수정하기' onclick='phoneUpdate()'>";
			tmp +="<input type='button' value='삭제하기' onclick=phoneDelete('"+data.num+"')>";

			$('#phone-info').append(tmp);
		}
	});//ajax
}//phoneInfo

function phoneInsert() {
	$.ajax({
		url:"phone",
		type:"post",
		data:JSON.stringify({
			"num":$('input[name=num]').val(),
			"model":$('input[name=model]').val(),
			"price":$('input[name=price]').val(),
			"vcode":$('select[id=vendors]').val()
		}),
		contentType:"application/json;charset=utf-8",
		
		error:function(xhr){
			alert("error "+ xhr.status);
		},	
		success:function(data){		
			alert("INSERT 성공");	
			allPhone();
		}
	});//ajax
}//phoneInsert

function phoneUpdate() {
	$.ajax({
		url:"phone",
		type:"put",
		data:JSON.stringify({
			"num":$('input[name=num]').val(),
			"model":$('input[name=model]').val(),
			"price":$('input[name=price]').val(),
			"vcode":$('select[id=vendors]').val()
		}),
		contentType:"application/json;charset=utf-8",
		
		error:function(xhr){
			alert("error "+ xhr.status);
		},	
		success:function(data){		
			alert("UPDATE 성공");	
			allPhone();
		}
	});//ajax
}//phoneUpdate

function phoneDelete(num) {
	$.ajax({
		url:"phone/" + num,
		type:"delete",
		error:function(xhr){
			alert("error : "+xhr.status);
		},
		success:function(data){		
			alert("DELETE 성공");	
			allPhone();
		}
	})
}

</script>
</head>
<body>
	<div><h1>휴대전화 목록</h1></div>
	<div id="phone-list"></div>
	<br>
	<div><h1>휴대전화 정보</h1></div>
	<div id="phone-info"></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
	$(function (){
		$("#checkJson").click(function (){
			var jsonStr = '{"name":"박지성","age":25,"gender":"남자","nickname":"날센돌이"}';
			var jsonObj = JSON.parse(jsonStr);
			var output = "회원 정보 <br>";
			output +="======<br>";
			output +="이름 :" +jsonObj.name +"<br>";
			output +="나이 :" +jsonObj.age +"<br>";
			output +="성별 :" +jsonObj.gender +"<br>";
			output +="별명 :" +jsonObj.nickname +"<br>";
			$("#ouput").html(output);
		});
	});
</script>
</head>
<body>
<h1>출력</h1>
<h1 id="output"></h1>
<input type="button" value="보여줘?" id="checkJson" />
</body>
</html>
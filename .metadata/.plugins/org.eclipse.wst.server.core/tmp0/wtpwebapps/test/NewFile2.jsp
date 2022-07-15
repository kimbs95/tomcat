<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

h2{
border-radius:5px;
background-color: wheat;
text-align: center;
padding : 15px 0;
}


#regform{
padding: 15px 20px;
border-radius : 10px;
margin:auto;
width:50%;
background-color : SandyBrown;

}

</style>
<script>

function signUp() {

	alert("정말로 가입하시겠습니까?");
	document.getElementById("regform").style.display ="none";
	document.getElementById("rname").innerHTML=document.form1.name.value;
	document.getElementById("remail").innerHTML = document.form1.email.value;
	document.getElementById("result").setAttribute("style" , "display:block;background-color:Khaki;");
	
	
}
</script>

</head>
<body>
<h2>회원가입</h2>
<hr>
<div id="regform">
	<form name ="form1">
	<label>이름</label> <br>
	<input type="text" name="name" size="40"> <br>
	<hr>
	<label>이메일</label> <br>
	<input type="email" name="email" size="40"> <br>
	<button type="button" onClick="signUp()">가입</button>
	</form>
</div>

<div id="result" class="result" >
<h3>가입 정보</h3>
<hr>
이름: <span id="rname"></span> <br>
이메일: <span id="remail"></span> <br>
</div>


</body>
</html>
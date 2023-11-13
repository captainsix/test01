<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
#container { width: 300px; margin: 10px auto;}
table { width: 100%; border: 1px solid black; border-collapse: collapse;}
tr { height: 50px;}
th, td { border: 1px solid black;}
th { width: 30%; background: orange;}
td { width: 70%;}
h1, .end_row { text-align: center;}
#id, #pwd { margin-left: 5px; width: 185px;}
</style>
</head>
<body>
<div id="container">
	<h1>로그인</h1>
	<hr>
	<form action="login.do" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" id="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd" id="pwd"></td>
		</tr>
		<tr>
			<td colspan="2" class="end_row"><input type="submit" value="로그인"></td>
		</tr>
	</table>
	</form>
	<hr>
</div>
</body>
</html>
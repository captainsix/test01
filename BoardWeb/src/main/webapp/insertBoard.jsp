<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록</title>
<style>
#container { width: 500px; margin: 10px auto;}
h1, .d1 { text-align: center;}
a { text-decoration: none; color: #1e94be;}
table { width: 100%; border: 1px solid black; border-collapse: collapse;}
tr { height: 40px;}
th, td { border: 1px solid black;}
th { background: #e9ecef;}
.end_row { text-align: center;}
.end_row input[type="submit"] { width: 80px; height: 30px; cursor: pointer;}
.sp { margin-left: 5px;}
.content { margin: 5px;}
.btns { text-align: center; margin: 15px 0;}
</style>
</head>
<body>
<div id="container">
	<h1>글등록</h1>
	<div class="d1"><a href="logout.do">로그아웃</a></div>
	<hr>
	<form action="insertBoard.do" method="post">
	<table>
		<tr>
			<th width="20%">제목</th>
			<td width="80%"><input type="text" name="title" value="" class="sp" size="53"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="" class="sp" size="53"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="20" cols="55" class="sp content"></textarea></td>
		</tr>
		<tr class="end_row">
			<td colspan="2"><input type="submit" value="글등록"></td>
		</tr>
	</table>
	<hr>
	<div class="btns">
		<a href="getBoardList.do">글목록</a>
	</div>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<style>
#container { width: 800px; margin: 10px auto;}
h1 { text-align: center;}
h4 { text-align: right;}
a { text-decoration: none; color: #1e94be;}
table { width: 100%; border: 1px solid black; border-collapse: collapse; margin: 5px 0;}
tr { height: 30px;}
th, td { border: 1px solid black;}
th { background: #e9ecef;}
#table1 { text-align: right;}
#table1 select { width: 100px; text-align: center; cursor: pointer;}
#table1 input[type="text"] { width: 225px;}
#table1 input[type="submit"] { width: 80px; cursor: pointer;}
#table2 .center { text-align: center;}
#table2 .left { padding-left: 10px;}
.d1 { text-align: center; margin-top: 10px;}
.s1 { color: #1e94be;}
</style>
</head>
<body>
<div id="container">
	<h1>글목록</h1>
	<h4><span class="s1">${member.id}</span>님 환영합니다. <a href="logout.do">로그아웃</a></h4>
	<%-- 검색 --%>
	<form action="" method="post">
	<table id="table1">
		<tr>
			<td>
				<select name="searchCondition">
					<option value="TITLE">제목</option>
					<option value="CONTENT">내용</option>
				</select>
				<input type="text" name="searchKeyword">
				<input type="submit" value="검색">
			</td>
		</tr>
	</table>
	</form>
	
	<%-- 글목록 --%>
	<table id="table2">
		<tr>
			<th width="10%">번호</th>
			<th width="50%" >제목</th>
			<th width="15%">작성자</th>
			<th width="15%">등록일</th>
			<th width="10%">조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td class="center">${board.seq}</td>
			<td class="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
			<td class="center">${board.writer}</td>
			<td class="center">${board.regDate}</td>
			<td class="center">${board.cnt}</td>
		</tr>
		</c:forEach>
	</table>
	
	<div class="d1"><a href="insertBoard.jsp">글등록</a></div>
</div>
</body>
</html>
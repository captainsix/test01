<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 처리</title>
</head>
<body>
<%
// 세션 삭제
//session.removeAttribute("memberId");

// 화면 이동
response.sendRedirect("login.jsp");
%>
</body>
</html>
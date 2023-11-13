<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.member.*, com.springbook.biz.member.impl.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>

<%
// 1. 멤버 아이디, 비밀번호 획득
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

// 2. 멤버 객체 생성
MemberVO vo = new MemberVO();
vo.setId(id);
vo.setPwd(pwd);

// 3. DB 처리
MemberDAO memberDAO = new MemberDAO();
MemberVO member = memberDAO.getMember(vo);

// 4. 화면 이동
if(member != null) { // 로그인 성공
	session.setAttribute("memberId", id);
	response.sendRedirect("getBoardList.jsp");
} else { // 로그인 실패
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>
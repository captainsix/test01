<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.BoardVO, com.springbook.biz.board.impl.BoardDAO, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제 처리</title>
</head>
<body>
<%
// 번호 데이터 획득
int seq = Integer.parseInt(request.getParameter("seq"));

// 객체 생성
BoardVO vo = new BoardVO();
vo.setSeq(seq);

// DB 연동 처리
BoardDAO boardDAO = new BoardDAO();
boardDAO.deleteBoard(vo);

// 화면 이동
response.sendRedirect("getBoardList.jsp");
%>
</body>
</html>
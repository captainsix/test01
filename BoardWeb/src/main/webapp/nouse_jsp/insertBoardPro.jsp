<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.BoardVO, com.springbook.biz.board.impl.BoardDAO, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록 처리</title>
</head>
<body>
<%
// 한글 인코딩
request.setCharacterEncoding("utf-8");

// 제목, 작성자, 내용 데이터 획득
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");

// 객체 생성
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setWriter(writer);
vo.setContent(content);

// DB 연동 처리
BoardDAO boardDAO = new BoardDAO();
boardDAO.insertBoard(vo);

// 화면 이동
response.sendRedirect("getBoardList.jsp");
%>
</body>
</html>
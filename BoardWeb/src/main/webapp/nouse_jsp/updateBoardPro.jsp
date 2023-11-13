<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.BoardVO, com.springbook.biz.board.impl.BoardDAO, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정 처리</title>
</head>
<body>
<%
// 한글 인코딩
request.setCharacterEncoding("utf-8");

// 번호, 제목, 내용 데이터 획득
int seq = Integer.parseInt(request.getParameter("seq"));
String title = request.getParameter("title");
String content = request.getParameter("content");

// 객체 생성
BoardVO vo = new BoardVO();
vo.setSeq(seq);
vo.setTitle(title);
vo.setContent(content);

// DB 연동 처리
BoardDAO boardDAO = new BoardDAO();
boardDAO.updateBoard(vo);

// 화면 이동
response.sendRedirect("getBoardList.jsp");
%>
</body>
</html>
package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.member.MemberVO;
import com.springbook.biz.member.impl.MemberDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 세션 객체 생성
		HttpSession session = request.getSession();
		
		// 3. path 정보를 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 4. 요청 처리
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
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
				response.sendRedirect("getBoardList.do");
			} else { // 로그인 실패
				response.sendRedirect("login.jsp");
			}
		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			// 모든 세션 삭제
			session.invalidate();

			// 화면 이동
			response.sendRedirect("login.jsp");
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글등록 처리");
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
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글수정 처리");
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
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글삭제 처리");
			// 번호 데이터 획득
			int seq = Integer.parseInt(request.getParameter("seq"));

			// 객체 생성
			BoardVO vo = new BoardVO();
			vo.setSeq(seq);

			// DB 연동 처리
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);

			// 화면 이동
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/getBoard.do")) {
			System.out.println("글상세 처리");
			// 글번호 획득
			int seq = Integer.parseInt(request.getParameter("seq"));

			// 객체 생성
			BoardVO vo = new BoardVO();
			vo.setSeq(seq);

			// DB 연동 처리
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			// BoardVO 객체를 세션으로 저장 화면 이동
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("글목록 처리");
			// 객체 생성
			BoardVO vo = new BoardVO();
			
			// DB 연동 처리
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// BoardList를 세션으로 저장, 화면 이동
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
	}

}

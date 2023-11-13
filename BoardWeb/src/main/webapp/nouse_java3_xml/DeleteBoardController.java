package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("===> DeleteBoardController - 글삭제 처리");
		// 번호 데이터 획득
		int seq = Integer.parseInt(request.getParameter("seq"));

		// 객체 생성
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);

		// DB 연동 처리
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);

		// 화면 이동
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}

}

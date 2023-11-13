package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("===> GetBoardController - 글상세 처리");
		// 글번호 획득
		int seq = Integer.parseInt(request.getParameter("seq"));

		// 객체 생성
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);

		// DB 연동 처리
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// BoardVO 객체를 세션으로 저장 화면 이동
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board); // Model
		mav.setViewName("getBoard");   // View
		return mav;
	}

}

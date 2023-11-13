package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("===> GetBoardListController - 글목록 처리");
		// 객체 생성
		BoardVO vo = new BoardVO();
		
		// DB 연동 처리
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// BoardList를 세션으로 저장, 화면 이동
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model
		mav.setViewName("getBoardList");       // View
		return mav;
	}

}

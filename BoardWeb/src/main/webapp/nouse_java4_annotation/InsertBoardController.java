package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {

	// xml기반의 HandlerMapping의 역할.
	// Command 객체가 동작 - 컨트롤러 메소드의 매개변수를 받아서 사용
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("===> InsertBoardController - 글등록 처리");
		
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}

}

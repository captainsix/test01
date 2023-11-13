package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

//@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOSpring2 boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		// after-returning, after-throwing 테스트
		//if(vo.getSeq() == 0) throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		
		// transaction 테스트 - 에러 발생
		// 100번이 한건은 추가되고, 다음 한건은 추가되지 않음 -> 트랜잭션 처리가 되지 않음.
		// 100번이 모두 추가되지 않음 -> 트랜잭션 처리가 됨.
		/*
		vo.setSeq(100);
		boardDAO.insertBoard(vo);
		vo.setSeq(100);
		boardDAO.insertBoard(vo);
		*/
		
		boardDAO.insertBoard(vo);
	}
	
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	
	@Override 
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}

package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceTest {
	
	public static void main(String[] args) {
		// 1단계 - 스프링 컨테이너를 구동해서 설정 파일을 검색
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2단계 - 서비스 빈을 검색
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		// 3단계 - 글등록, 글수정, 글삭제, 글상세조회(1건), 글목록조회 기능을 테스트
		
		// 글등록
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 글제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 글내용.....");
		boardService.insertBoard(vo);
		
		// 글수정
		/*
		BoardVO vo = new BoardVO();
		vo.setSeq(3);
		vo.setTitle("수정된 글제목");
		vo.setContent("수정된 내용입니다.");
		boardService.updateBoard(vo);
		*/
		
		// 글삭제
		/*
		BoardVO vo = new BoardVO();
		vo.setSeq(4);
		boardService.deleteBoard(vo);
		*/
		
		// 글목록조회 (전체)
		//BoardVO vo = new BoardVO();
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("---> " + board);
		}
				
		// 글상세조회 (1건)
		/*
		//BoardVO vo = new BoardVO();
		vo.setSeq(15);
		System.out.println(boardService.getBoard(vo));
		*/
				
		// 4단계 - 스프링 컨테이너 해제
		container.close();
	}

	
}

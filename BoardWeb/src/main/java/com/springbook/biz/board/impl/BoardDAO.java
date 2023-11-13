package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

// board 테이블의 DB 처리를 위한 클래스
//@Repository("boardDAO")
public class BoardDAO {                 
	// DB 연결, 처리 변수 선언
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// SQL 명령문
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(board_seq.nextval, ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_UPDATE_CNT = "update board set cnt = cnt+1 where seq=?";
	
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> insertBoard() 메소드 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch(Exception e) { 
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> updateBoard() 메소드 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> deleteBoard() 메소드 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 글조회 - 전체
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> getBoardList() 메소드 실행");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardList;
	}
	
	// 글조회 - 상세보기(1건)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> getBoard() 메소드 실행");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
			
			updateBoardCnt(vo);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			JDBCUtil.close(conn, pstmt, rs);
		}
		return board;
	}
	
	// 조회수 증가
	public void updateBoardCnt(BoardVO vo) {
		System.out.println("===> updateBoardCnt() 메소드 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE_CNT);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
}

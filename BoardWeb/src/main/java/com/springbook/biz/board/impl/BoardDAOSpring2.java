package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

//스프링에서 제공하는 JdbcTemplate 객체를 사용하는 방법 2번 - JdbcTemplate 클래스를 빈으로 생성하여 의존성 주입
//@Repository
public class BoardDAOSpring2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL 명령문
	// 트랜잭션 테스트
	//private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?, ?, ?, ?)";
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(board_seq.nextval, ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_GET = "select * from board where seq=?";
	
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring-JDBC2를 활용한 insertBoard() 메소드 실행");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		
		// 트랜잭션 테스트
		//jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring-JDBC2를 활용한  updateBoard() 메소드 실행");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring-JDBC2를 활용한  deleteBoard() 메소드 실행");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	// 글조회 - 전체
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring-JDBC2를 활용한  getBoardList() 메소드 실행");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
	
	// 글조회 - 상세보기(1건)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring-JDBC2를 활용한  getBoard() 메소드 실행");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	// 매퍼 클래스 (Mapper Class)
	class BoardRowMapper implements RowMapper<BoardVO> {
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setRegDate(rs.getDate("regdate"));
			board.setCnt(rs.getInt("cnt"));
			return board;
		}
	}
}

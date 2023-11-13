package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.springbook.biz.board.BoardVO;

// 스프링에서 제공하는 JdbcTemplate 객체를 사용하는 방법 1번 - JdbcDaoSupport 클래스를 상속하는 방법
//@Repository
public class BoardDAOSpring extends JdbcDaoSupport {

	// SQL 명령문
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(board_seq.nextval, ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_GET = "select * from board where seq=?";
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring-JDBC를 활용한 insertBoard() 메소드 실행");
		this.getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring-JDBC를 활용한  updateBoard() 메소드 실행");
		this.getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring-JDBC를 활용한  deleteBoard() 메소드 실행");
		this.getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
	
	// 글조회 - 전체
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring-JDBC를 활용한  getBoardList() 메소드 실행");
		return this.getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}
	
	// 글조회 - 상세보기(1건)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring-JDBC를 활용한  getBoard() 메소드 실행");
		Object[] args = {vo.getSeq()};
		return this.getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
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

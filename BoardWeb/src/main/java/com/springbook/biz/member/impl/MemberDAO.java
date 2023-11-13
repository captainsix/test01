package com.springbook.biz.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.member.MemberVO;

// member 테이블의 DB 처리를 위한 클래스
@Repository("memberDAO")
public class MemberDAO {
	// DB 연결, 처리 변수 선언
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// SQL 명령문
	private final String MEMBER_INSERT = "insert into member(id,pwd,name,email,tel,address) values(?,?,?,?,?,?)";
	private final String MEMBER_UPDATE = "update member set name=?, email=?, tel=?, address=? where id=? and pwd=?";
	private final String MEMBER_DELETE = "delete from member where id=? and pwd=?";
	private final String MEMBER_GET = "select * from member where id=?";
	private final String MEMBER_LIST = "select * from member order by regdate desc";
	
	// 회원 등록
	public void insertMember(MemberVO vo) {
		System.out.println("===> insertMember() 메소드 실행");
		
		try { 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getTel());
			pstmt.setString(6, vo.getAddress());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		
	}
	
	// 회원 수정
	public void updateMember(MemberVO vo) {
		System.out.println("===> updateMember() 메소드 실행");
		
		try { 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getTel());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getId());
			pstmt.setString(6, vo.getPwd());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 회원 삭제(탈퇴)
	public void deleteMember(MemberVO vo) {
		System.out.println("===> deleteMember() 메소드 실행");
		
		try { 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_DELETE);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 회원 정보 조회 (1건)
	public MemberVO getMember(MemberVO vo) {
		System.out.println("===> getMember() 메소드 실행");
		MemberVO member = null;
		
		try { 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_GET);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setTel(rs.getString("tel"));
				member.setAddress(rs.getString("address"));
				member.setRegDate(rs.getDate("regdate"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return member;
	}
	
	// 회원 목록 조회 (전체) - 관리자가 사용
	public List<MemberVO> getMemberList(MemberVO vo) {
		System.out.println("===> getMemberList() 메소드 실행");
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberVO member = null;
		
		try { 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_LIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setTel(rs.getString("tel"));
				member.setAddress(rs.getString("address"));
				member.setRegDate(rs.getDate("regdate"));
				memberList.add(member);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return memberList;
	}
	
}

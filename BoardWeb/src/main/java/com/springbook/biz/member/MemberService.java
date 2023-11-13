package com.springbook.biz.member;

import java.util.List;

public interface MemberService {
	
	// 회원 등록
	void insertMember(MemberVO vo);

	// 회원 수정
	void updateMember(MemberVO vo);
		
	// 회원 삭제(탈퇴)
	void deleteMember(MemberVO vo);
	
	// 회원 정보 조회 (1건)
	MemberVO getMember(MemberVO vo);
	
	// 회원 목록 조회 (전체)
	List<MemberVO> getMemberList(MemberVO vo);
	
}

package com.springbook.biz.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberServiceTest {
	
	public static void main(String[] args) {
		// 1단계 - 스프링 컨테이너를 기동하여 설정 파일을 검색
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2단계 - 서비스 빈을 검색
		MemberService memberService = (MemberService)container.getBean("memberService");
		
		// 3단계 - 회원 등록, 회원 수정, 회원 삭제, 회원 조회 (1건), 회원 목록 조회 (전체) 기능을 테스트
		
		// 회원 등록
		/*
		MemberVO vo = new MemberVO();
		vo.setId("dddd");
		vo.setPwd("1234");
		vo.setName("장주원");
		vo.setEmail("dddd@naver.com");
		vo.setTel("010-7777-7777");
		vo.setAddress("강원도 삼척시 동구 삼척3가 삼척아파트 405동 405호");
		memberService.insertMember(vo);
		*/
		
		// 회원 정보 수정
		/*
		MemberVO vo = new MemberVO();
		vo.setId("bbbb");
		vo.setPwd("1234");
		vo.setName("김봉석");
		vo.setEmail("kim@naver.com");
		vo.setTel("010-2222-2222");
		vo.setAddress("부천시 부천3가 부천아파트 707호");
		memberService.updateMember(vo);
		*/
		
		// 회원 삭제(탈퇴)
		MemberVO vo = new MemberVO();
		vo.setId("cccc");
		vo.setPwd("1234");
		memberService.deleteMember(vo);
		
		// 회원 조회 (1건)
		/*
		MemberVO vo = new MemberVO();
		vo.setId("bbbb");
		System.out.println(memberService.getMember(vo));
		*/
		
		// 회원 목록 조회 (전체)
		//MemberVO vo = new MemberVO();
		List<MemberVO> memberList = memberService.getMemberList(vo);
		for(MemberVO member : memberList) {
			System.out.println(member);
		}
		
		// 4단계 - 스프링 컨테이너 해제
		container.close();
	}

}

package com.springbook.view.member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.member.MemberVO;
import com.springbook.biz.member.impl.MemberDAO;

@Controller
public class MemberController {
	
	// GET 방식
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String loginGet(MemberVO vo) {
		System.out.println("===> MemberController - 로그인 처리 (GET)");
		return "login.jsp";
	}
	
	// POST 방식
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginPost(MemberVO vo, MemberDAO memberDAO, HttpSession session) {
		System.out.println("===> MemberController - 로그인 처리 (POST)");
		MemberVO member = memberDAO.getMember(vo);
		if(member != null) {
			session.setAttribute("member", member);
			return "getBoardList.do";
		}
		return "login.jsp";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		System.out.println("===> MemberController - 로그아웃 처리");
		session.invalidate();
		return "login.jsp";
	}

}

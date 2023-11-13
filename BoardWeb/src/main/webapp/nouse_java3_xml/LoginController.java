package com.springbook.view.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.member.MemberVO;
import com.springbook.biz.member.impl.MemberDAO;

public class LoginController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("===> LoginController - 로그인 처리");
		// 1. 멤버 아이디, 비밀번호 획득
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 2. 멤버 객체 생성
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);

		// 3. DB 처리
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = memberDAO.getMember(vo);

		// 4. 화면 이동
		// redirect: -> ViewResolver를 거치지 않고 바로 이동
		ModelAndView mav = new ModelAndView();
		if(member != null) { // 로그인 성공
			mav.addObject("member", member);
			mav.setViewName("redirect:getBoardList.do");
		} else { // 로그인 실패
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}

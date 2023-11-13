package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;

//@Service
//@Aspect
public class AfterReturningAdvice {

	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		//System.out.println("[사후 처리] 정상적인 비즈니스 로직 수행 후 동작");
		String method = jp.getSignature().getName();
		if(returnObj instanceof BoardVO) {
			BoardVO board = (BoardVO)returnObj;
			if(board.getWriter().equals("김길동")) System.out.println(board.getWriter() + "님 환영합니다.");
		}
		
		System.out.println("[사후 처리] " + method + "() 메소드, 리턴값: " + returnObj);
	}
	
}

package com.springbook.biz.common;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Service 
//@Aspect // Pointcut + Advice
public class LogAdvice {
	
	// 어드바이스 메소드
	@Before("PointcutCommon.allPointcut()")
	public void printLog() {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}

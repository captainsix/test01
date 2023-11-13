package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Service
//@Aspect
public class BeforeAdvice {
	
	@Before("PointcutCommon.getPointcut()")
	public void beforeLog(JoinPoint jp) {
		//System.out.println("[사전 처리] 비즈니스 로직 수행 전에 동작");
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전 처리] " + method + "() 메소드, 매개변수: " + args[0]);
	}

}

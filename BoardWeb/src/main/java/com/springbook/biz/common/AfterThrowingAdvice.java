package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;

//@Service
//@Aspect
public class AfterThrowingAdvice {
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		//System.out.println("[예외 처리] 비즈니스 로직 수행 후 예외 발생 처리");
		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] " + method + "메소드(), 예외 메시지: " + exceptionObj.getMessage());
	}

}

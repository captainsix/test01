package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
		
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//System.out.println("[BEFORE] 비즈니스 메소드 실행 전에 동작");
		
		String method = pjp.getSignature().getName();
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object returnObj = pjp.proceed(); // 비즈니스 메소드 전후로 동작
		
		sw.stop();
		System.out.println("===> " + method + "() 메소드 수행에 걸린 시간: " + sw.getTotalTimeMillis() + "밀리초(ms)");
		
		//System.out.println("[AFTER] 비즈니스 메소드 실행 후에 동작");
		
		return returnObj;
	}

}

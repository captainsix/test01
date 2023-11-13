package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	
	// 포인트컷 설정 - 참조 메소드 : 실제 로직이 없는 포인트컷의 설정만을 위한 메소드
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() { }
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut() { }
	
}

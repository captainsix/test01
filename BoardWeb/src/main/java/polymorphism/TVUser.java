package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
[ TV를 변경했을 때의 문제점 ]
1. 대부분의 소스 코드를 고쳐야 한다. -> 결합도가 높은 프로그램

< 해결책 1번 >
1. 자바의 기능 -> 상속을 사용
2. 소스 코드를 일부분 고쳐야 한다. -> 결합도를 가진 프로그램 -> 문제점

< 해결책 2번 >
1. 해결책 1번 활용 + 팩토리 디자인 패턴 활용
2. 소스 코드를 전혀 고치지 않았다. -> 결합도가 낮은 프로그램

< 해결책 3번 >
1. 해결책 1번 활용 + 해결책 2번 활용 + xml 파일 설정 
2. 스프링 컨테이너를 통해 구동

###########

[ 스피커를 추가했을 때의 문제점 ]
1. 스피커 객체 2개 생성
2. 스피커를 변경하게 되면 소스 코드를 고쳐야 함. -> 결합도가 높아짐.

< 해결책 1번 >
1. 생성자 인젝션을 통해 해결
2. 생성자 오버로딩을 사용
*/

public class TVUser {
	
	public static void main(String[] args) {
		/*
		// 해결책 2번에서 사용
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		*/
		
		// 해결책 3번에서 사용
		// 1단계: Spring 컨테이너를 구동하여 xml 파일을 읽어 들임.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2단계: xml에서 생성된 빈을 찾아서 실행 -> lookup
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3단계: Spring 컨테이너 닫기
		factory.close();
	}

}

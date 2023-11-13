package collection.ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanTest {
	
	public static void main(String[] args) {
		// 1단계 - 스프링 컨테이너에서 xml 파일을 검색
		AbstractApplicationContext factory = new GenericXmlApplicationContext("collectionContext.xml");
		
		// 2단계 - xml 파일에서 빈을 찾아서 생성
		//ListBean bean = (ListBean)factory.getBean("listBean");
		//SetBean bean = (SetBean)factory.getBean("setBean");
		//MapBean bean = (MapBean)factory.getBean("mapBean");
		PropertiesBean bean = (PropertiesBean)factory.getBean("propBean");
		System.out.println(bean);
		
		// 3단계 - 스프링 컨테이너 닫기
		factory.close();
	}

}

package polymorphism;

// 팩토리 디자인 패턴
public class BeanFactory {
	
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}

}

package collection.ioc;

import java.util.Properties;

public class PropertiesBean {
	private Properties addressProp;
	
	public PropertiesBean() { 
		System.out.println("=> PropertiesBean 객체 생성");
	}
	
	// setter -> 세터 인젝션
	public void setAddressProp(Properties addressProp) {
		System.out.println("---> setAddressProp() 호출");
		this.addressProp = addressProp;
	}
	
	// getter
	public Properties getAddressProp() {
		return addressProp;
	}

	@Override
	public String toString() {
		return "PropertiesBean [addressProp=" + addressProp + "]";
	}
	
}

package collection.ioc;

import java.util.Set;

public class SetBean {
	private Set<String> addressSet;
	
	// 기본 생성자
	public SetBean() {
		System.out.println("=> SetBean 객체 생성");
	}
	
	// setter -> 세터 인젝션
	public void setAddressSet(Set<String> addressSet) {
		System.out.println("---> setAddressSet() 호출");
		this.addressSet = addressSet;
	}
	
	// getter
	public Set<String> getAddressSet() {
		return addressSet;
	}

	@Override
	public String toString() {
		return "SetBean [addressSet=" + addressSet + "]";
	}
	
}

package collection.ioc;

import java.util.List;

public class ListBean {
	private List<String> addressList;
	
	// 기본 생성자
	public ListBean() {
		System.out.println("=> ListBean 객체 생성");
	}
	
	// setter -> 세터 인젝션
	public void setAddressList(List<String> addressList) {
		System.out.println("---> setAddressList() 호출");
		this.addressList = addressList;
	}
	
	// getter
	public List<String> getAddressList() {
		return addressList;
	}

	@Override
	public String toString() {
		return "ListBean [addressList=" + addressList + "]";
	}

}

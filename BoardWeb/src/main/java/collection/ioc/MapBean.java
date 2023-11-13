package collection.ioc;

import java.util.Map;

public class MapBean {
	private Map<String, String> addressMap;
	
	public MapBean() {
		System.out.println("=> MapBean 객체 생성");
	}
	
	// setter -> 세터 인젝션
	public void setAddressMap(Map<String, String> addressMap) {
		System.out.println("---> setAddressMap() 호출");
		this.addressMap = addressMap;
	}
	
	// getter
	public Map<String, String> getAddressMap() {
		return addressMap;
	}

	@Override
	public String toString() {
		return "MapBean [addressMap=" + addressMap + "]";
	}
	
}

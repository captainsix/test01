package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	// 생성자
	public SamsungTV() { 
		System.out.println("=> SamsungTV 객체 생성(1)");
	}
	
	// 생성자 오버로딩 -> 생성자 인젝션
	public SamsungTV(Speaker speaker) {
		System.out.println("=> SamsungTV 객체 생성(2)");
		this.speaker = speaker;
	}
	
	// 생성자 오버로딩 -> 생성자 인젝션
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("=> SamsungTV 객체 생성(3)");
		this.speaker = speaker;
		this.price = price;
	}
	
	// 세터 -> 세터 인젝션
	public void setSpeaker(Speaker speaker) {
		System.out.println("---> setSpeaker() 호출");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("---> setPrice() 호출");
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV --- 전원을 켠다. (가격: " + price + ")");
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV --- 전원을 끈다");
	}

	@Override
	public void volumeUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("SamsungTV --- 소리를 올린다.");
	}
	
	@Override
	public void volumeDown() {
		//speaker = new SonySpeaker();
		speaker.volumeDown();
		//System.out.println("SamsungTV --- 소리를 내린다.");
	}
	
	/*
	// 생성자 이후에 호출되는 메소드
	public void initMethod() {
		System.out.println("- 객체 초기화 작업 처리 -");
	}
	
	// 객체 소멸 전에 호출되는 메소드
	public void destroyMethod() {
		System.out.println("- 객체 소멸 전에 처리할 로직 -");
	}
	*/
	
	
}

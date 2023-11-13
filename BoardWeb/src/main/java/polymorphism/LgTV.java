package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV  {
	
	// 어노테이션 기반
	//@Autowired @Qualifier("apple")
	//@Inject @Qualifier("apple")
	//@Resource(name="apple")
	
	// xml과 어노테이션을 병행
	@Autowired
	private Speaker speaker;
	
	// 생성자
	public LgTV() {
		System.out.println("=> LgTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV --- 전원을 켠다.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV --- 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		//System.out.println("LgTV --- 소리를 올린다.");
	}
	
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("LgTV --- 소리를 내린다.");
	}
	
}

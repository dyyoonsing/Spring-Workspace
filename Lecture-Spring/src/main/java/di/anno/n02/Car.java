package di.anno.n02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Car {
	
	
	//required=false는 객체 없으면 그냥 넣지말라는 뜻! 의존 주입이 필수항목이 아님
//	@Autowired(required = false)
//	@Qualifier("kumho")
	private Tire tire;		//의존관계 발생
	
	public Car() {
		System.out.println("anno Car() 호출...");
	} 

	//생성자주입 constructor injection - 생성자주입 qualifier는 여러개일 수 있으니까 parameter에 qualifier를 씀
	@Autowired
	public Car(@Qualifier("kumho") Tire tire) {
		this.tire = tire;
		System.out.println("@Autowird 생성자 호출...");
	}
	
	//속성주입 setter injection
//	@Autowired
//	@Qualifier("kumho")
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("@Autowired setTire() 호출...");
	}
	
	public void prnTireBrand() {
		System.out.println("설정된 타이어 브랜드 : " + tire.getBrand());
	}
}

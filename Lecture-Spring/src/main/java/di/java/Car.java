package di.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired
	@Qualifier("hankook")
	private Tire tire;		//의존관계 발생
	
	public Car() {
		System.out.println("anno Car() 호출...");
	} 

	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("@Autowird 생성자 호출...");
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("@Autowired setTire() 호출...");
	}
	
	public void prnTireBrand() {
		System.out.println("설정된 타이어 브랜드 : " + tire.getBrand());
	}
}

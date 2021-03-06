package di.anno.n03;

import javax.annotation.Resource;

public class Car {
	
	@Resource
	private Tire tire;		//의존관계 발생
	
	public Car() {
		System.out.println("anno Car() 호출...");
	} 

	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("@resource 생성자 호출...(사용불가)");
	}
	
//	@Resource
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("@resource 호출...");
	}
	
	public void prnTireBrand() {
		System.out.println("설정된 타이어 브랜드 : " + tire.getBrand());
	}
}

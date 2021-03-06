package di.anno.n01;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
//	@Autowired
	//@Autowired하면 	--> private Tire tire = new HankookTire();처럼 작동함
//	@Resource
	private Tire tire;		//의존관계 발생
	
	public Car() {
		System.out.println("anno Car() 호출...");
	} 

	//생성자주입 constructor injection
//	@Autowired
////@Resource - resource annotation은 생성자에는 붙일 수 없다~~!
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("@Autowird 생성자 호출...");
	}
	
	//속성주입 setter injection
//	@Autowired
//	@Resource
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("@Autowired setTire() 호출...");
	}
	
	public void prnTireBrand() {
		System.out.println("설정된 타이어 브랜드 : " + tire.getBrand());
	}
}

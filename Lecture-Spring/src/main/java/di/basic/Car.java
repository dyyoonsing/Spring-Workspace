package di.basic;

public class Car {
	
	private Tire tire;		//의존관계 발생
	
	public Car() {
		//의존관계 설정
		//tire = new HankookTire();
		//tire = new KumhoTire();
	}
	
	//생성자주입 constructor injection
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	//속성주입 setter injection
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void prnTireBrand() {
		System.out.println("설정된 타이어 브랜드 : " + tire.getBrand());
	}
}

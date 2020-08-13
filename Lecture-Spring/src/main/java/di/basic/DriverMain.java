package di.basic;

public class DriverMain {
	
	public static void main(String[] args) {
		//타이어를 car 객체가 아닌 main에서 정의함
		//Tire tire = new KumhoTire();
		Tire tire = new HankookTire();
		
		//생성자 주입 코드
		//Car car = new Car(tire);
		
		Car car = new Car();
		car.setTire(tire);
		car.prnTireBrand();
		
	}

}

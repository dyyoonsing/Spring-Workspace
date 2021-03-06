package di.xml.n02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//생성자를 통한 속성 주입
public class DriverMain {
	
	public static void main(String[] args) {
		/*
		Tire tire = new HankookTire();
		Car car = new Car(tire);
		car.prnTireBrand();
		*/
		ApplicationContext context = new GenericXmlApplicationContext("di-xml02.xml");
		
		Car car = context.getBean("car", Car.class);
		car.prnTireBrand();
		//생성자 주입이 일어남
		
		
		
	}
}

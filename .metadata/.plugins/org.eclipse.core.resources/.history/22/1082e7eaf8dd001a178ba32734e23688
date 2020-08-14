package di.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverMain {

	public static void main(String[] args) {
		
		//어노테이션으로 구성되어 있는 config 파일을 읽음(xml이 아님~)
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Car car = context.getBean("car", Car.class);
		car.prnTireBrand();
	}
}

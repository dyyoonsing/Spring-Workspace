package hw.calculator02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculateMain {
	
	public static void main(String[] args) {
		
		
		//생성자주입, setter 주입 같이 씀
		ApplicationContext context = new GenericXmlApplicationContext("ditest02/hw-calculator.xml");
		MyCalculator my = context.getBean("mycal", MyCalculator.class);
		
		
		my.add();
		my.sub();
		my.mul();
		my.div();
		
	}
	
	
}

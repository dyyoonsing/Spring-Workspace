package hw.calculator01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculateMain {
	
	public static void main(String[] args) {
		
//		ApplicationContext context = new GenericXmlApplicationContext("ditest01/hw-calculator01.xml");
		
		//생성자주입, setter 주입 같이 씀
		ApplicationContext context = new GenericXmlApplicationContext("ditest01/hw-calculator03.xml");
		MyCalculator my = context.getBean("mycal", MyCalculator.class);
		
//		my.setFirstNum(15);
//		my.setSecondNum(4);
		
		my.add();
		my.sub();
		my.mul();
		my.div();
		
		
		/*
		MyCalculator myCal = context.getBean("mycal", MyCalculator.class);
		MyCalculator myCal = context.getBean("mycal2", MyCalculator.class);
		
		myCal.prnCalculator();
		*/
	}
	
	
}

package hw.calculator01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculateMain04 {
	
	public static void main(String[] args) {
		
		//숫자까지 다 생성자로 넣기
		ApplicationContext context = new GenericXmlApplicationContext("ditest01/hw-calculator04.xml");
		MyCalculator my = context.getBean("mycal", MyCalculator.class); 
		
		my.add();
		my.sub();
		my.mul();
		my.div();
		
	}
	

}

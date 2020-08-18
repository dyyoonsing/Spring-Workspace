package aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 	SPRING AOP 특징
 	1. Runtime 기반
 	2. Proxy 기반
 	3. 인터페이스 기반
 */
public class EmpMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("aop-xml.xml");
		//인터페이스 형태로 받아야함(프록시) 
		//Programmer programmer = (Programmer)context.getBean("programmer")가 아닌~~~~
		Employee e = (Employee)context.getBean("programmer");
		e.work();
		
		e = context.getBean("designer", Employee.class);
		e.work();
		
		e = context.getBean("manager", Employee.class);
		e.work();
		
	}
}

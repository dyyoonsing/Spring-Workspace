package basic;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args) {
		
		//ClassPath? src/main/resources를 의미함
//		ApplicationContext context = new ClassPathXmlApplicationContext("beanContainer.xml");
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml");
		//classpath 밑에 있는 beancontainer.xml을 의미함 (classpath:beanContainer.xml)
		ApplicationContext context = new GenericXmlApplicationContext("classpath:beanContainer.xml");
		
		//뒤에다가 타입을 적으면 명시적형변환 안해도됨
		HelloSingle obj3 = context.getBean("hs", HelloSingle.class);
		HelloSingle obj4 = (HelloSingle)context.getBean("hs2");
		obj3.prnMsg();
		System.out.println(obj3);
		System.out.println(obj4);
		
		
		
		Hello obj = (Hello)context.getBean("hello");
		obj.prnMsg();
		
		Hello obj2 = (Hello)context.getBean("hello2");
		obj2.prnMsg();
		
		System.out.println(obj);
		System.out.println(obj2);
		
	}
}

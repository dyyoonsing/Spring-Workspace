package hw.shape;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShapeMain {
	
	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);
		
		MyShapes myShapes = container.getBean("MyShapes", MyShapes.class);
		myShapes.prnShapeArea();
		
	}
	

}
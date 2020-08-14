package hw.shape;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("MyShapes")
public class MyShapes {
	
	@Value("13")
	private int height;
	
	@Value("11")
	private int width;
	
	@Value("4")
	private int radius;
	
	@Autowired
	private Shapes shapes;
	
	public MyShapes() {
		super();
	}
	
	public void prnShapeArea() {
		shapes.rectangleArea(width, height);
		shapes.squareArea(width);
		shapes.triangleArea(width, height);
		shapes.circleArea(radius);
	}
	

}

package hw.shape02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape {
	
	@Value("12")
	protected int width;
	@Value("5")
	protected int height;
	
	@Override
	public String getShape() {
		return "직사각형";
	}

	@Override
	public double getArea() {
		
		return width * height;
	}
	
	
	
}

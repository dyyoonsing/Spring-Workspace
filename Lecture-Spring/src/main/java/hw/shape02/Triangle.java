package hw.shape02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape{

	
	@Value("12")
	protected int width;
	@Value("5")
	protected int height;
	
	@Override
	public String getShape() {
		return "삼각형";
	}

	@Override
	public double getArea() {
		
		return width * height * 0.5;
	}
}

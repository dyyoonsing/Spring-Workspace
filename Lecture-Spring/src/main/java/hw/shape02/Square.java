package hw.shape02;

import org.springframework.stereotype.Component;

@Component
public class Square extends Rectangle{
	
	@Override
	public String getShape() {
		return "정사각형";
	}
	
	@Override
	public double getArea() {
		
		return width * width;
	}
	
}

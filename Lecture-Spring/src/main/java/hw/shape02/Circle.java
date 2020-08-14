package hw.shape02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape{
	
	@Value("6")
	protected int radius;
	
	@Override
	public String getShape() {
		return "원";
	}

	@Override
	public double getArea() {
		
		return radius * radius * 3.14;
	}

}

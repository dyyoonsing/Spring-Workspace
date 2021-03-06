package hw.shape02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Area {
	
	@Autowired
	@Qualifier("circle")
	private Shape shape;
	
	public void printArea() {
		System.out.printf("%s의 넓이는 : %.2f", shape.getShape(), shape.getArea());
	}

}

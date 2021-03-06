package hw.shape;

import org.springframework.stereotype.Component;

@Component
public class Shapes {
	
	public void rectangleArea(int width, int height) {
		System.out.printf("(가로 %d, 세로 %d) 직사각형의 넓이 : %d\n", width, height, width * height);
	}
	
	public void squareArea(int width) {
		System.out.printf("(한 변의 길이 %d) 정사각형의 넓이 : %d\n", width, width * width);
	}
	
	public void triangleArea(int width, int height) {
		System.out.printf("(밑변 %d, 높이 %d) 삼각형의 넓이 : %.1f\n", width, height, width * height * 0.5);
	}
	
	public void circleArea(int radius) {
		System.out.printf("(반지름 %d) 원의 넓이 : %.2f\n", radius, radius * radius * 3.14);
	}

}

package hw.calculator01;

public class Calculator {
	
	public void addition(int firstNum, int secondNum) {
		System.out.printf("덧셈결과 : %d + %d = %d\n", firstNum, secondNum, (firstNum + secondNum));
	}

	public void substraction(int firstNum, int secondNum) {
		System.out.printf("뺄셈결과 : %d - %d = %d\n", firstNum, secondNum, (firstNum - secondNum));
	}
	
	public void multiply(int firstNum, int secondNum) {
		System.out.printf("곱셈결과 : %d * %d = %d\n", firstNum, secondNum, (firstNum * secondNum));
	}
	
	public void division(int firstNum, int secondNum) {
		System.out.printf("나눗셈결과 : %d / %d = %.2f\n", firstNum, secondNum, ((double)firstNum / (double)secondNum));
	}
	
	
	/*
	public int addition(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}

	public int minus(int firstNum, int secondNum) {
		return firstNum - secondNum;
	}
	
	public int multiply(int firstNum, int secondNum) {
		return firstNum * secondNum;
	}
	
	public int division(int firstNum, int secondNum) {
		return firstNum / secondNum;
	}
	*/
	
}

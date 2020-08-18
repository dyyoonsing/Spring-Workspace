package aop.xml;

public class Manager implements Employee {

	@Override
	public void work() {
		System.out.println("사원 관리와 운영을 합니다");
	}

}

package aop.anno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * 공통코드 (출근, 퇴근)
 */
@Aspect
public class Action {
	
	@Before("execution(* work())")
	public void gotoOffice() {
		System.out.println("출근합니다...");
	}
	
	@After("execution(* aop.anno.*.work())")
	public void getoffOffice() {
		System.out.println("퇴근합니다...");
	}
	
}

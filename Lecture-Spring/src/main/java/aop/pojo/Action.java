package aop.pojo;
/*
 * 공통코드 (출근, 퇴근)
 */
public class Action {
	
	public static void gotoOffice() {
		System.out.println("출근합니다...");
	}
	
	public static void getoffOffice() {
		System.out.println("퇴근합니다...");
	}
	
}

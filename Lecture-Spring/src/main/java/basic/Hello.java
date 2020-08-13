package basic;

public class Hello {
	
	private String msg;

	public Hello() {
		System.out.println("hello 객체 로딩...");
		msg = "hello";
	}
	
	public void prnMsg() {
		System.out.println("msg : " + msg);
	}
	
}

package lecture0714;

public class Main {

	public static void main(String[] args) {
		System.out.println("프로그램 시작!");
		
//		int result = 10 / 0;	
//		// javascript에서는 infinity가 존재하기 때문에 가능
//		// java에서는 error 발생
//		// => Exception 생성 (에러에 대한 정보를 담은 instance)
//		
//		System.out.println("프로그램 종료!");
//		// 에러로 인해 프로그램이 종료되어 실행되지 않음

		try {
			Object obj = null;
			System.out.println(obj.toString());
		} catch(ArithmeticException a) {
			// Exception 처리
			System.out.println("에러 발생!");
		} catch(NullPointerException e) {
			
		} finally {
			// 무조건 실행되는 구문
		}
	}

}

package lecture0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {

	public static void main(String[] args) {
		System.out.println("키보드로 한 줄을 입력하세요.");
		// 키보드(표준 입력 = System.in)를 통해 데이터 1 line을 입력받음
		
		// System.in이라는 제공된 Stream은 사용하기 힘듦
		// byte 단위로 입력받아야 하기 때문에 어려움
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String input = br.readLine();	// 한 줄씩 읽어오는 기능 (try-catch로 묶어야 함)
			System.out.println("입력받은 문자열 : " + input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

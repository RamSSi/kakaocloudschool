package lecture0718.exam01;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Exam01_DateServer {

	public static void main(String[] args) {
		try {
			// ServerSocket은 client가 접근할 수 있는 Port번호를 가지고 있어야 한다.
			ServerSocket serverSocket = new ServerSocket(5678);
			System.out.println("Date Server 동작 - 포트번호(5678)");
			// accept()가 호출되면 ServerSocket이 Client의 접근을 기다리기 시작
			Socket socket = serverSocket.accept();	// blocking
			// 접근 성공
			// 왜 socket에 assign하죠???
			PrintWriter pr = new PrintWriter(socket.getOutputStream());	
			// getOutputStream() : 문자열로 내보내지지 않음
			// PrintWriter 객체를 새로 만들어 문자열로 쉽게 보낼 수 있음
			
			// 현재 날짜
			Date date = new Date();
			pr.println(date.toLocaleString());	// 현재 접속된 지역의 날짜를 문자열로 만들어 보냄
			
			// 버퍼 안에 들어있는 데이터를 스트림을 통해 내보내는 시점은
			// 1. 스트림이 강제로 종료될 경우 (close)
			// 2. 버퍼의 공간이 다 찰 경우
			// 3. method를 이용해서 flush() 시킬 경우
			pr.flush();
			pr.close();
			socket.close();
			serverSocket.close();
			// 자원을 사용한 후 모두 닫아주어야 함
			System.out.println("Date Server 종료");
		} catch (Exception e) {
			
		}

	}

}

package lecture0718.exam02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Exam02_EchoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter pr = null;
		BufferedReader br = null;
		try {
			// ServerSocket은 client가 접근할 수 있는 Port번호를 가지고 있어야 한다.
			serverSocket = new ServerSocket(5678);
			System.out.println("Echo Server 기동 - 클라이언트 접속 대기");
			// accept()가 호출되면 ServerSocket이 Client의 접근을 기다리기 시작
			socket = serverSocket.accept();	// blocking
			
			// 접근 성공
			// 왜 socket에 assign하죠???
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pr = new PrintWriter(socket.getOutputStream());	
			// getInputStream() : 문자열로 내보내지지 않음
			// PrintWriter 객체를 새로 만들어 문자열로 쉽게 보낼 수 있음
			
			String msg = null;
			
			while(true) {
				msg = br.readLine();
				if((msg.equals("/exit")) || (msg == null)) {
					break;
				}
				pr.println(msg);
				pr.flush();	// buffer를 이용한 통신이기 때문에 원하는 시점에 데이터를 전송하기 위해 꼭 flush()를 호출해주어야 함
			}
			
		} catch (Exception e) {
			
		} finally {
			// 사용된 resource를 해제
			try {
				if (br != null) br.close();
				if (pr != null) pr.close();
				if (socket != null) socket.close();
				if (serverSocket != null) serverSocket.close();

				System.out.println("Echo Server 종료");
			} catch (Exception e2) {
				
			}
		}

	}


}

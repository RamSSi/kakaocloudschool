package lecture0714;

import javax.swing.JOptionPane;

class ThreadExam04_1 extends Thread {
	@Override
	public void run() {
		int i = 10;
		while(i != 0 && !isInterrupted()) {	// interrupt로 프로그램을 제어
			// i가 0이 아니고 interrupt가 걸려있지 않으면
			System.out.println(--i);
			
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				interrupt();
				// thread가 sleep 상태에 있을 때 interrupt가 발생하면 
				// thread가 깨어남과 동시에 isInterrupted 값을 false로 바꾼다.
				// 따라서 while문 밖으로 나가지 않기 때문에
				// interrupt()를 다시 발생시켜주어야 한다.
			}
//			for(long k = 0; k < 750000000000000000L; k++);	// 시간 지연 (but CPU가 계속 일을 하면서 부하 발생)
			
		}
		System.out.println("카운트 종료");
	}
}

public class ThreadExam04 {
	public static void main(String[] args) {
		Thread t = new ThreadExam04_1();
		
		t.start();
		
		String input = JOptionPane.showInputDialog("값을 입력하세요.");	// 창이 뜨면 main Thread가 blocking
	
		System.out.println("입력값 : " + input);
		

		t.interrupt();	
		// Thread t의 내부 상태정보를 변경함 (interrupted = true;)
		System.out.println("Thread 상태값 : " + t.isInterrupted());
	
	}	
}

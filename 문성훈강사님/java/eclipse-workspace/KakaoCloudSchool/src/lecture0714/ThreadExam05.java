package lecture0714;

class ThreadExam05_1 implements Runnable {
	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());	// Runnable interface를 구현했기 때문에
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				
			}
		}
	}
}

public class ThreadExam05 {
	public static void main(String[] args) {
		ThreadExam05_1 r = new ThreadExam05_1();
		Thread t1 = new Thread(r, "*");	// 두 번째 인자 : Thread의 이름
		Thread t2 = new Thread(r, "**");
		Thread t3 = new Thread(r, "***");

		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(3000);	// main Thread 2초 sleep
			System.out.println("t1 일시중지");
			t1.suspend();	// t1 일시중지
			Thread.sleep(3000);
			System.out.println("t2 일시중지");
			t2.suspend();	// t2 일시중지
			Thread.sleep(3000);
			System.out.println("t1 다시 동작");
			t1.resume();	// t1을 다시 동작
			Thread.sleep(3000);
			t1.stop();
			t2.stop();
			Thread.sleep(3000);
			t3.stop();
		} catch (Exception e) {
			
		}
	}
}

package lecture0714;

class ThreadExam06_1 implements Runnable {

	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	
	@Override
	public void run() {
		while(!stopped) {	// busy waiting : 멈춰있는 것처럼 보이나 실제로는 계속해서 반복문을 실행하고 있음
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					
				}
			} else {
				Thread.yield(); // 따라서 CPU를 사용하지 않기 위해 다른 Thread에게 양보함
			}
		}
	}
	
	public void suspend() {
		suspended = true;
	}
	
	public void stop() {
		stopped = true;
	}
	
	public void resume() {
		suspended = false;
	}
}

public class ThreadExam06 {
	public static void main(String[] args) {
		ThreadExam06_1 r1 = new ThreadExam06_1();
		ThreadExam06_1 r2 = new ThreadExam06_1();
		ThreadExam06_1 r3 = new ThreadExam06_1();
		
		Thread t1 = new Thread(r1, "*");	// 두 번째 인자 : Thread의 이름
		Thread t2 = new Thread(r2, "**");
		Thread t3 = new Thread(r3, "***");

		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(3000);	// main Thread 2초 sleep
			System.out.println("t1 일시중지");
			r1.suspend();	// t1 일시중지
			Thread.sleep(3000);
			System.out.println("t2 일시중지");
			r2.suspend();	// t2 일시중지
			Thread.sleep(3000);
			System.out.println("t1 다시 동작");
			r1.resume();	// t1을 다시 동작
			Thread.sleep(3000);
			System.out.println("t1 강제종료");
			r1.stop();
			System.out.println("t2 강제종료");
			r2.stop();
			Thread.sleep(3000);
			System.out.println("t3 강제종료");
			r3.stop();
		} catch (Exception e) {
			
		}
	}
}
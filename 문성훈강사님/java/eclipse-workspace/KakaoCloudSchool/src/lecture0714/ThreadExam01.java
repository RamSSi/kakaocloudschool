package lecture0714;

class ThreadExam01_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName());	// getName() : Thread class에 정의된 클래스, Thread 객체의 이름을 반환
		}
	}
}

class ThreadExam01_2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());	// getName() : Thread class의 static method, 현재 코드를 실행시키고 있는 Thread(ThreadEx_01_2 instance) 의 이름 반환
		}
	}
}

public class ThreadExam01 {

	public static void main(String[] args) {
		ThreadExam01_1 t1 = new ThreadExam01_1();
		ThreadExam01_2 r = new ThreadExam01_2();
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
		System.out.println("main thread 종료");
	}

}

package lecture0715;

class ThreadExam07_1 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
	}
}

class ThreadExam07_2 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
		}
	}
}

public class ThreadExam07 {
	public static void main(String[] args) {
		Thread t1 = new ThreadExam07_1();
		Thread t2 = new ThreadExam07_2();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();	
			t2.join();
			// main Thread에서 실행했으므로 main Thread를 block시키고 t1, t2를 종료한 후 실행시켜라!
		
		} catch (Exception e) {
			
		}
		
		System.out.println("<<main>> 종료");
	}
}
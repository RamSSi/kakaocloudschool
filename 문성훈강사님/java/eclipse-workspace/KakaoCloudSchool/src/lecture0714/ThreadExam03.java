package lecture0714;
class ThreadExam03_1 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
			}
			System.out.print("-");
			if (i%20 == 0) {
				System.out.println();
			}
		}
		System.out.println("<<Thread 1 종료>>");
	}
}

class ThreadExam03_2 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
			if (i%20 == 0) {
				System.out.println();
			}
		}
		System.out.println("<<Thread 2 종료>>");
	}
}

public class ThreadExam03 {
	public static void main(String[] args) {
		ThreadExam03_1 t1 = new ThreadExam03_1();
		ThreadExam03_2 t2 = new ThreadExam03_2();

		t1.start();
		t2.start();
		
		System.out.println("<<main Thread 종료>>");
	}
}

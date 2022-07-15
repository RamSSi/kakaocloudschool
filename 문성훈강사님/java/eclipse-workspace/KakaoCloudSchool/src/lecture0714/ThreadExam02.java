package lecture0714;

public class ThreadExam02 implements Runnable {
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadExam02());
		t.setDaemon(true);	
		// main thread에서 생성된 daemon thread는 main thread가 종료되면 함께 종료됨
		// daemon thread로 지정되어 있지 않으면 무한반복됨 (thread가 종료되지 않기 때문)
		t.start();	// main thread, t thread가 시작됨
		
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);	// static method "sleep()" : main thread를 재움
			} catch (Exception e) {
				
			}
			System.out.println(i);
			
			if(i == 5) {
				autoSave = true;
			}
		}
	}
	
	@Override
	public void run() {
		while(true) {
			
			try {
				Thread.sleep(3000);	// 해당 코드를 수행하는 thread를 재움
			} catch (InterruptedException e) {
				
			}
			
			if(autoSave) {
				System.out.println("자동저장 완료");
			}
		}
	}
}

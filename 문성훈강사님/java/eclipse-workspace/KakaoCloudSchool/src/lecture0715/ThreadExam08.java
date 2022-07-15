package lecture0715;

class ThreadExam08_1 extends Thread {
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("interrupt()에 의해 깨어났어요.");
			}
			gc();
			System.out.println("메모리 청소 완료!\n현재 사용 가능한 메모리는 : " + freeMemory());
		}
	}
	
	public void gc() {
		// 현재 사용되고 있는 memory 양을 줄여줌
		usedMemory -= 300;
		if (usedMemory < 0) {
			usedMemory = 0;
		}
	}
	
	public int totalMemory() { return MAX_MEMORY; }
	
	public int freeMemory() { return MAX_MEMORY - usedMemory; }
	// 사용가능한 memory 양
}

public class ThreadExam08 {
	public static void main(String[] args) {
		ThreadExam08_1 t = new ThreadExam08_1();
		t.setDaemon(true);
		t.start();
		System.out.println("1");
		int requiredMemory = 0;
		
		for(int i = 0; i < 20; i++) {
			requiredMemory = (int)(Math.random() * 10) * 20;
			// 0.0보다 같거나 크고 200보다 작은 정수
			// 필요한 memory가 사용할 수 있는 양보다 크거나
			// 현재 전체 메모리의 60% 이상을 사용하고 있을 때 gc 실행
			if((requiredMemory > t.freeMemory()) || 
					(t.freeMemory() < t.totalMemory() * 0.4)) {
				t.interrupt();	// gc() 실행이 끝날 때까지 기다리지 않음
//				try {
//					t.join(10);	// gc()가 먼저 돌아가게끔 join() 호출
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
			}
			t.usedMemory += requiredMemory;
			System.out.println("사용된 메모리 양 : " + t.usedMemory);
		}
	}
}

package lecture0715;

// Thread에 의해서 공유되는 공유객체를 생성하기 위한 class
class Account {
	private int balance = 1000;	// 계좌 잔액

	public int getBalance() {
		return balance;
	}

// 출금 => 동기화 처리 필요 (synchronized) : 먼저 호출한 Thread가 lock을 얻고 나머지 Thread는 대기 상태

// method 전체가 동기화 처리되면 비효율적일 수 있음	
//	public synchronized void withdraw(int money) {
	
	public void withdraw(int money) {
		
		// 동기화 블록 (공유 객체인 Account instance를 동기화 해야한다. -> this 사용)
		synchronized (this) {
			if (balance >= money) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				balance -= money;
			}
		}
	}
}

class ThreadExam09_1 implements Runnable {
	Account acc = new Account();	// 공용 account를 한 번 생성해서 Thread들이 공유
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int) (Math.random() * 3 + 1) * 100; // (100 ~ 300)
			acc.withdraw(money);
			System.out.println("잔액 : " + acc.getBalance());
		}
	}
}

public class ThreadExam09 {
	public static void main(String[] args) {
		ThreadExam09_1 r = new ThreadExam09_1();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

package lecture0715;

class Thread_instance implements Runnable {
	int i = 0;
	public synchronized void printName() {
		
		System.out.println(Thread.currentThread().getName() + " : " + ++i);
		try {
			notify();
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			printName();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

public class ThreadQuestion1 {

	public static void main(String[] args) {
		Thread_instance r = new Thread_instance();
		Thread t1 = new Thread(r, "Thread t1");
		Thread t2 = new Thread(r, "Thread t2");
		
		t1.start();
		t2.start();
	}

}

package others.threadlocal;

public class ThreadLocalTest extends Thread {

	@Override
	public void run() {
		for(int i = 0;i < 3;i ++) {
			System.out.println(Thread.currentThread().getName() + " " + Counter.next());
		}
	}
	
	public static void main(String[] args) {
		ThreadLocalTest t1 = new ThreadLocalTest();
		ThreadLocalTest t2 = new ThreadLocalTest();
		ThreadLocalTest t3 = new ThreadLocalTest();
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}

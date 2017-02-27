package something.storage;

import java.util.concurrent.CountDownLatch;

/**
 * 测试
 * @author skywalker
 *
 */
public class Test {

	public static void main(String[] args) {
		int[] storage = new int[11];
		final CountDownLatch latch = new CountDownLatch(5);
		long begin = System.currentTimeMillis();
		new Thread(new Producer(1, storage, latch)).start();
		new Thread(new Producer(2, storage, latch)).start();
		new Thread(new Producer(3, storage, latch)).start();
		new Thread(new Producer(4, storage, latch)).start();
		new Thread(new Consumer(storage, latch)).start();
		try {
			latch.await();
			System.out.println("\n耗时" + (System.currentTimeMillis() - begin + "毫秒"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

package something.storage;

import java.util.concurrent.CountDownLatch;

/**
 * 消费者线程
 * @author skywalker
 *
 */
public class Consumer implements Runnable {

	private int[] storage;
	private int count = 0;
	private CountDownLatch latch;

	public Consumer(int[] storage, CountDownLatch latch) {
		this.storage = storage;
		this.latch = latch;
	}

	@Override
	public void run() {
		while (count < 400) {
			synchronized (storage) {
				if (storage[0] == 0) {
					continue;
				}
				System.out.print(storage[0]);
				if (storage[1] == 0) {
					storage[0] = 0;
				} else {
					//整体前移
					for (int i = 1;i < 11; ++i) {
						if (storage[i] > 0) {
							storage[i - 1] = storage[i];
							storage[i] = 0;
						}
					}
				}
				++count;
			}
		}
		latch.countDown();
	}
	
}

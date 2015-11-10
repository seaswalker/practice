package something.storage;

import java.util.concurrent.CountDownLatch;

/**
 * 生产者线程
 * @author skywalker
 *
 */
public class Producer implements Runnable {
	
	//生产什么类型的产品
	private int seed;
	//插入次数
	private int count = 0;
	private int[] storage;
	private CountDownLatch latch;
	//上一次执行存放的线程
	private static int last = 4;
	
	public Producer(int seed, int[] storage, CountDownLatch latch) {
		this.seed = seed;
		this.storage = storage;
		this.latch = latch;
	}

	@Override
	public void run() {
		int pre = seed == 1 ? 4 : seed - 1;
		while (count < 100) {
			synchronized (storage) {
				synchronized (Producer.class) {
					if (last != pre) {
						continue;
					} else {
						int index = 0;
						while (index < 11 && storage[index] > 0) {
							++index;
						}
						if (index == 10) {
							continue;
						} else {
							storage[index] = seed;
							last = seed;
							++count;
						}
					}
				}
			}
		}
		latch.countDown();
	}

}

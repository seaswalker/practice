package something;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Random有一些让人迷惑的地方
 * @author skywalker
 *
 */
public class RandomTest {

	/**
	 * 实验结果:
	 * qyc564
	 * qyc564
	 * qyc564
	 * qyc564
	 * qyc564
	 * 可以发现，ThreadLocalRandom根本不适合多个线程产生不同的id的情况
	 * 而使用private static Random random = new Random();
	 * 每次获得都是不同的，注意这个问题
	 */
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i = 0;i < 5;i ++) {
			service.execute(new Task());
		}
		service.shutdown();
	}
	
}

class Task implements Runnable {
	
	private static Random random = ThreadLocalRandom.current();
	
	public static String generateId() {
		int c = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < 3; ++i) {
			c = 96 + random.nextInt(27);
			sb.append((char) c);
		}
		for(int i = 0;i < 3;++ i) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	
	@Override
	public void run() {
		System.out.println(generateId());
	}
}

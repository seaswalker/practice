package something;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用多线程实现赛马游戏，要求如下:
 * 赛程长1000米，红马速度为0-20米/秒之间的随机数，黑马速度为0-19米/秒之间的随机数，
 * 白马速度为0-18米/秒之间的随机数。每10秒马匹速度更新，并刷新显示每匹马完成的距离，直到所有马到达终点，给出名次及各自的完成时间。
 * @author skywalker
 *
 */
public class HorseRacing {
	
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(1);
		new Thread(new Horse(21, "红马", latch)).start();
		new Thread(new Horse(20, "黑马", latch)).start();
		new Thread(new Horse(19, "白马", latch)).start();
		latch.countDown();
	}

	/**
	 * 一匹马
	 * @author skywalker
	 */
	private static class Horse implements Runnable {
		
		//此马的最高速度
		private int maxSpeed;
		private String name;
		private final CountDownLatch latch;
		private Random random = new Random();
		//跑过的距离
		private int meters = 0;
		//用时
		private double time = 0;
		//距离
		private static final int distance = 1000;
		//名次计数器
		private static final AtomicInteger counter = new AtomicInteger(1);
		
		public Horse(int maxSpeed, String name, CountDownLatch latch) {
			this.maxSpeed = maxSpeed;
			this.name = name;
			this.latch = latch;
		}

		@Override
		public void run() {
			int speed;
			try {
				latch.await();
				while (true) {
					speed = random.nextInt(maxSpeed);
					if (meters + speed * 10 > distance) {
						time += ((double) (distance - meters)) / speed;
						System.out.println(name + "获得第" + counter.getAndIncrement() + "名，耗时:" + time + "秒");
						break;
					} else {
						meters += speed * 10;
						time += 10;
						TimeUnit.SECONDS.sleep(10);
						//实时显示每匹马完成的距离
						System.out.println(name + "完成" + meters + "米");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

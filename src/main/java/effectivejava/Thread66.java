package effectivejava;

import java.util.concurrent.TimeUnit;

/**
 * 66条线程同步
 * @author skywalker
 *
 */
public class Thread66 {
	
	//volatile关键字可以
	private static boolean flag = true;
	
	/**
	 * 同步也可以
	 */
	public synchronized static boolean getFlag() {
		return flag;
	}
	
	public synchronized static void setFlag(boolean flag) {
		Thread66.flag = flag;
	}
	
	private static int i = 0;

	/**
	 * 如果没有惊醒任何操作，那么此程序不会停止，因为boolean类型虽然是院子的，但是虚拟机并不会保证一个线程的修改
	 * 对于其它线程马山就是可见的
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				while(getFlag()) {
					i ++;
				}
			}
		};
		new Thread(thread).start();
		TimeUnit.SECONDS.sleep(1);
		setFlag(false);
		System.out.println(i);
	}
	
}

package offer;

import java.util.concurrent.TimeUnit;

/**
 * 四个线程顺序打印数字问题.
 *
 * @author skywalker
 */
public class PrintNumber {

    public static void main(String[] args) throws InterruptedException {
        PrintNumber pn = new PrintNumber();
        pn.start();
    }

    private void start() throws InterruptedException {
        Object[] monitors = new Object[]{new Object(), new Object(), new Object(), new Object()};
        new Thread(new Printer(1, monitors)).start();
        new Thread(new Printer(2, monitors)).start();
        new Thread(new Printer(3, monitors)).start();
        new Thread(new Printer(4, monitors)).start();
        //等待所有打印线程完成启动(等待)
        TimeUnit.SECONDS.sleep(5);
        final Object start = monitors[0];
        synchronized (start) {
            start.notifyAll();
        }
    }

    private class Printer implements Runnable {

        private final int number;
        private final Object[] monitors;

        private Printer(int number, Object[] monitors) {
            this.number = number;
            this.monitors = monitors;
        }

        @Override
        public void run() {
            final Object curMonitor = monitors[number - 1];
            while (true) {
                synchronized (curMonitor) {
                    try {
                        curMonitor.wait();
                        System.out.print(number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //sleep
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //唤醒下一个
                int next = (number == 4 ? 0 : number);
                final Object nextMonitor = monitors[next];
                synchronized (nextMonitor) {
                    nextMonitor.notifyAll();
                }
            }
        }
    }

}

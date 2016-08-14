package disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用WorkPool的方式实现多消费者处理
 * 参考: https://github.com/LMAX-Exchange/disruptor/wiki/Frequently-Asked-Questions
 * Created by skywalker on 2016/8/14.
 */
public class Bootstrap {

    public static void main(String[] agrs) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Disruptor disruptor = new Disruptor(new StringEventFactory(), 64, threadPool, ProducerType.SINGLE, new YieldingWaitStrategy());
        //handler的数量和线程的数量严格对应
        disruptor.handleEventsWithWorkerPool(new StringEventHandler(), new StringEventHandler(), new StringEventHandler());
        RingBuffer ringBuffer = disruptor.start();

        for (int i = 0; i < 10; i++) {
            long next = 0;
            try {
                next = ringBuffer.tryNext();
                StringEvent event = (StringEvent) ringBuffer.get(next);
                event.setStr(String.valueOf(i));
            } catch (InsufficientCapacityException e) {
                e.printStackTrace();
            } finally {
                ringBuffer.publish(next);
            }
        }
    }

}

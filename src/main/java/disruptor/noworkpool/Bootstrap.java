package disruptor.noworkpool;

import com.lmax.disruptor.InsufficientCapacityException;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import disruptor.StringEvent;
import disruptor.StringEventFactory;
import disruptor.StringEventHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 不用WorkPool实现多消费者处理
 * Created by skywalker on 2016/8/14.
 */
public class Bootstrap {

    public static void main(String[] agrs) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Disruptor disruptor = new Disruptor(new StringEventFactory(), 64, threadPool, ProducerType.SINGLE, new YieldingWaitStrategy());
        //handler的数量和线程的数量严格对应
        disruptor.handleEventsWith(new StringEventHandlerWithoutWorkPool(0, 3), new StringEventHandlerWithoutWorkPool(1, 3), new StringEventHandlerWithoutWorkPool(2, 3));
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

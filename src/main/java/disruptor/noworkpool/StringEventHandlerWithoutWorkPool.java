package disruptor.noworkpool;

import com.lmax.disruptor.EventHandler;
import disruptor.StringEvent;

/**
 * 不用WorkPool实现多消费者同时消费
 * Created by skywalker on 2016/8/14.
 */
public class StringEventHandlerWithoutWorkPool implements EventHandler<StringEvent> {

    //此事件处理器的序号
    private final long ordinal;
    //消费者线程数量
    private final long consumers;

    public StringEventHandlerWithoutWorkPool(long ordinal, long consumers) {
        this.ordinal = ordinal;
        this.consumers = consumers;
    }

    @Override
    public void onEvent(StringEvent event, long sequence, boolean endOfBatch) throws Exception {
        if ((sequence % consumers) == ordinal) {
            System.out.println("event: " + event.getStr() + " by thread " + Thread.currentThread().getName());
        }
    }
}

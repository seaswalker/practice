package disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * Created by skywalker on 2016/8/14.
 */
public class StringEventHandler implements WorkHandler<StringEvent> {

    @Override
    public void onEvent(StringEvent event) throws Exception {
        System.out.println("event: " + event.getStr() + " by thread " + Thread.currentThread().getName());
    }
}

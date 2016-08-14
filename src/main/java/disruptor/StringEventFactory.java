package disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 事件工厂
 * Created by skywalker on 2016/8/14.
 */
public class StringEventFactory implements EventFactory<StringEvent> {

    @Override
    public StringEvent newInstance() {
        return new StringEvent();
    }
}

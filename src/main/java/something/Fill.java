package something;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Collections.fill()到底是什么鬼
 * @author skywalker
 *
 */
public class Fill {

	@Test
	public void testA() {
		List<String> list = new ArrayList<String>();
		Collections.fill(list, "str");
		//[]
		System.out.println(list);
	}
	
	@Test
	public void testB() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		Collections.fill(list, "str");
		//[str, str]
		//查看源码可以发现，此方法的作用是replace
		System.out.println(list);
	}
	
}

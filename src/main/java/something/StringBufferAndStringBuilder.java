package something;

import beanchmark.BenchMark;
import beanchmark.TimeBenchMark;

/**
 * 两者究竟谁快
 * @author skywalker
 *
 */
public class StringBufferAndStringBuilder {

	@BenchMark(times = 100)
	public static void testStringBuilder() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < 10000;i ++) {
			sb.append("a");
		}
	}
	
	@BenchMark(times = 100)
	public static void testStringBuffer() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < 10000;i ++) {
			sb.append("a");
		}
	}
	
	public static void main(String[] args) {
		TimeBenchMark.run(StringBufferAndStringBuilder.class);
	}
	
}

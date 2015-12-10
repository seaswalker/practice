package others;

import beanchmark.BenchMark;
import beanchmark.TimeBenchMark;

/**
 * 单精度很双精度的速度
 * @author skywalker
 *
 */
public class DoubleFloat {

	@BenchMark(times = 50)
	public void doubleTest() {
		@SuppressWarnings("unused")
		double d = 3.45343;
		for (int i = 0;i < 100; i++) {
			d *= 1.4234;
		}
	}
	
	@BenchMark(times = 50)
	public void floatTest() {
		@SuppressWarnings("unused")
		float f = 3.45343f;
		for (int i = 0;i < 100; i++) {
			f *= 1.4234;
		}
	}
	
	public static void main(String[] args) {
		TimeBenchMark.run(DoubleFloat.class);
	}
	
}

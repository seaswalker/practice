package others.threadlocal;

public class Counter {

	private static ThreadLocal<Integer> context = new ThreadLocal<Integer>() {
		protected synchronized Integer initialValue() {
			return 10;
		};
	};
	
	public static int get() {
		return context.get();
	}
	
	public static void set(Integer value) {
		context.set(value);
	}
	
	public static int next() {
		context.set(context.get() + 1);
		return context.get();
	}
	
}

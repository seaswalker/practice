package others;

/**
 * 方法覆盖
 * @author skywalker
 *
 */
public class ExtendTest extends Child {
	
	@Override
	public int sum(int a, int b) {
		//父类的实例方法
		fun();
		//父类的类方法
		shit();
		return super.sum(a, b);
	}
	
}

class Child {
	protected int sum(int a, int b) {
		return a + b;
	}
	
	protected void fun() {
		
	}
	
	protected static void shit() {
		
	}
}

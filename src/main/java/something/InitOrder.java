package something;

/**
 * 加载顺序
 * @author skywalker
 *
 */
public class InitOrder extends Parent {

	public InitOrder() {
		System.out.println("initOrder");
	}
	
	{
		System.out.println("I am initOrder");
	}
	
	static {
		System.out.println("static initOrder");
	}
	
	public static void main(String[] args) {
		new InitOrder();
	}
	
}

class Parent {
	
	public Parent() {
		System.out.println("Parent");
	}
	
	{
		System.out.println("I am parent");
	}
	
	static {
		System.out.println("static parent");
	}
	
}

package offer;

/**
 * 再看单例模式
 * 以下这两种相较于双重检查的方法，更加优雅
 * 双重检查有两个if判断，比较复杂，容易出错?，这是剑指offer的解释
 * @author skywalker
 *
 */
public class Singleton {

	private static Singleton singleton;
	
	static {
		singleton = new Singleton();
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	private Singleton() {}
	
}

/**
 * 貌似是最好的单例模式实现方式
 * 这样解决了上面的"饥汉模式"的提前加载的问题
 * @author skywalker
 *
 */
class SingletonBest {
	
	private SingletonBest() {}
	
	public static SingletonBest getInstance() {
		return Nested.singleton;
	}
	
	/**
	 * 使用内部类
	 * 必须是嵌套类，非嵌套类内部不能有静态代码块
	 */
	static class Nested {
		
		static SingletonBest singleton;
		
		static {
			singleton = new SingletonBest();
		}
	}
	
}

package spring;

/**
 * 测试bean
 * @author skywalker
 *
 */
public class Bean {

	private String name;
	private int age;
	
	public Bean() {
		System.out.println("构造器被调用");
	}
	
	/**
	 * 初始化方法
	 */
	public void init() {
		System.out.println("初始化");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName被调用");
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("setAge被调用");
		this.age = age;
	}
	
}

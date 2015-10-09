package aop.base;

/**
 * 业务类
 * @author skywalker
 *
 */
public class Business implements IBusiness {

	@Override
	public void doSomething() {
		System.out.println("do something");
	}

	@Override
	public void doAnotherthing() {
		System.out.println("do anotherthing");
	}

}

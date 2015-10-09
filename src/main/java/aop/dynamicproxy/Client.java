package aop.dynamicproxy;

import aop.base.Business;
import aop.base.IBusiness;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * AOP的实现方式之一:动态代理,但是有三个缺点:
 * 1. 目标类必须实现一个接口
 * 2. 使用反射技术，速度肯定比正常的方法调用慢
 * 3. 代理生产大量的代理类，加载后存放在jvm的方法去，多了以后可能会引起Full GC
 */
public class Client {

	/**
	 * 运行结果:
	 * do something
	 * 我是doSomething的日志
	 * do anotherthing
	 */
	public static void main(String[] args) {
		ClassLoader loader = Client.class.getClassLoader();
		InvocationHandler handler = new LogHandler(new Business());
		IBusiness proxy = (IBusiness) Proxy.newProxyInstance(loader, new Class[] {IBusiness.class}, handler);
		proxy.doSomething();
		proxy.doAnotherthing();
	}
	
}

package aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 加日志
 * @author skywalker
 *
 */
public class LogHandler implements InvocationHandler {
	
	//被代理对象
	private Object target;
	
	public LogHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(target, args);
		//只在doSomething方法上加日志代理
		if (method.getName().equals("doSomething")) {
			System.out.println("我是doSomething的日志");
		}
		return result;
	}

}

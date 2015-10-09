package aop.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 日志记录拦截器
 * Created by skywalker on 2015/10/9.
 */
public class LogIntecepter implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //执行父类的原有方法
        Object result = methodProxy.invokeSuper(o, objects);
        //日志逻辑
        if (method.getName().equals("doSomething")) {
            System.out.println("doSomething日志");
        }
        return result;
    }
}

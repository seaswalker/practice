package aop.cglib;

import aop.base.Business;
import aop.base.IBusiness;
import org.springframework.cglib.proxy.Enhancer;


/**
 * AOP实现方式之二:Cglib动态字节码技术
 * (由于已经引入spring aop包，所以直接利用了spring aop，没有单独引入cglib)
 *
 * cglib应用于那些没有实现接口的类，为目标类创建一个子类来实现代理，其中，从调用父类的方法的代码可以看出
 * Object result = methodProxy.invokeSuper(o, objects);
 * cglib只能应用于为一个类做代理，为接口是不行的，动态代理之所以可以代理接口，是因为你在创建InvocationHandler对象时需要传递一个同样实现了此接口的
 * 对象进去，不是吗?
 * cglib的缺点其实和动态代理是一样的
 * Created by skywalker on 2015/10/9.
 * 运行结果:
 * do something
 * doSomething日志
 * do anotherthing
 */
public class Client {

    public static void main(String[] args) {
        //创建一个织入器
        Enhancer enhancer = new Enhancer();
        //设置父类,不能是接口!
        enhancer.setSuperclass(Business.class);
        //需要织入的逻辑
        enhancer.setCallback(new LogIntecepter());
        //创建子类
        IBusiness child = (IBusiness) enhancer.create();
        //方法调用
        child.doSomething();
        child.doAnotherthing();
    }

}

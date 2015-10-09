package aop.classloader;

import javassist.ClassPool;
import javassist.Loader;

/**
 * 使用自定义类加载器的方式实现aop，其原理:
 * 实现一个自定义类加载器，在类加载到JVM之前直接修改某些类的方法，并将切入逻辑织入到这个方法里，然后将修改后的字节码文件交给虚拟机运行
 * 在此借助框架javassist实现
 * 这样做的优点就是性能优于动态代理的cglib，但是缺点在于如果使用其它的类加载器就完了
 * Created by skywalker on 2015/10/9.
 */
public class Client {

    public static void main(String[] args) throws Throwable {
        ClassPool cp = ClassPool.getDefault();
        //创建一个类加载器
        Loader loader = new Loader();
        loader.addTranslator(cp, new MyTranslator());
        //此方法会调用指定类的main函数
        loader.run("aop.classloader.MyTranslator", args);
    }

}

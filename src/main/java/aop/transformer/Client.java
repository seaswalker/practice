package aop.transformer;

import aop.base.Business;

/**
 * 单纯使用javassist的方式只能拦截由自己的类加载器加载的类，对于其它的就无能为力了
 * 采用jdk1.5加入的Instrumentation可以构建一个字节码转换器，在字节码加载前进行转换
 * java.lang.instrument包的作用:
 * java Instrumentation指的是可以用独立于应用程序之外的代理（agent）程序来监测和协助运行在JVM上的应用程序。
 * 这种监测和协助包括但不限于获取JVM运行时状态，替换和修改类定义等。
 *
 * 实验方式:
 * 由于不知道如何利用ide只把一个class打包为jar，所以采用手动打包的方式:
 * 1. 在MyClassFileTransformer.class所在目录建立文件META-INF\MANIFEST.MF文件(夹)，内容为:
 *  Manifest-Version: 1.0
 *  Premain-Class: aop.transformer.MyClassFileTransformer
 * 2.使用WinRAR直接把class文件和META-INF文件夹用zip算法压缩为transformer.jar(示例)
 * 3. 配置运行jvm参数:-javaagent:D:\java\idea\practice\target\classes\aop\transformer\transformer.jar
 * 3. 执行main函数，便可以看到结果:
 * do something
 * 日志记录
 * do anotherthing
 * Created by skywalker on 2015/10/9.
 */
public class Client {

    public static void main(String[] args) {
        Business business = new Business();
        business.doSomething();
        business.doAnotherthing();
    }

}

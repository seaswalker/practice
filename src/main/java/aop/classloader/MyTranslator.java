package aop.classloader;

import aop.base.Business;
import javassist.*;

/**
 * 自定义类加载监听器
 * Created by skywalker on 2015/10/9.
 */
public class MyTranslator implements Translator {

    @Override
    public void start(ClassPool classPool) throws NotFoundException, CannotCompileException {}

    @Override
    public void onLoad(ClassPool classPool, String s) throws NotFoundException, CannotCompileException {
        //只拦截Business类
        if ("aop.base.Business".equals(s)) {
            //获取类对象
            CtClass c = classPool.get(s);
            //获取指定的方法
            CtMethod method = c.getDeclaredMethod("doSomething");
            //插入代码
            method.insertBefore("{System.out.println(\"记录日志\");}");
        }
    }

    public static void main(String[] args) {
        Business business = new Business();
        business.doSomething();
    }
}

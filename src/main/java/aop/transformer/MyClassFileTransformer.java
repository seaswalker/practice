package aop.transformer;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * 自定义字节码转换器
 * Created by skywalker on 2015/10/9.
 */
public class MyClassFileTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        //此处的类名以/分割
        if (className.equals("aop/base/Business")) {
            //javassist的包名以.分割，先进行转换
            className = className.replaceAll("/", ".");
            //插入代码
            try {
                CtClass c = ClassPool.getDefault().get(className);
                CtMethod method = c.getDeclaredMethod("doSomething");
                method.insertAfter("{System.out.println(\"日志记录\");}");
                //返回经过javassist处理的字节码
                return c.toBytecode();
            } catch (NotFoundException e) {
                e.printStackTrace();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    /**
     * 此方法是java.instrument API约定的方法，JVM启动时从启动指定的代理类，而此方法类似main正式代理的入口
     * @param options 代理选项
     * @param ins
     */
    public static void premain(String options, Instrumentation ins) {
        ins.addTransformer(new MyClassFileTransformer());
    }

}

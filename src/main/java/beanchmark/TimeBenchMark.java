package beanchmark;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 时间基准测试
 * @author skywalker
 *
 */
public class TimeBenchMark {

	/**
	 * 运行测试
	 * @param clazz需要运行的类
	 */
	public static void run(Class<?> clazz) {
		//不支持private方法
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			Annotation annotation = method.getAnnotation(BenchMark.class);
			if(annotation != null) {
				BenchMark benchMark = (BenchMark) annotation;
				//获取次数
				int times = benchMark.times();
				execute(times, method, clazz);
			}
		}
	}
	
	/**
	 * 执行测试
	 * @param times 次数
	 * @param method方法
	 * @param clazz 所在的类对象
	 */
	private static void execute(int times, Method method, Class<?> clazz) {
		try {
			Object obj = clazz.newInstance();
			long begin = System.currentTimeMillis();
			for(int i = 0;i < times;i ++) {
				method.invoke(obj, new Object[] {});
			}
			long end = System.currentTimeMillis();
			System.out.println();
			System.out.println(method.getName() + "共运行" + times + "次， 耗时" + (end - begin) + "毫秒");
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println("请确保所在类有public无参构造方法");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}

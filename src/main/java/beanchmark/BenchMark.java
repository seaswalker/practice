package beanchmark;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 时间基准测试注解
 * @author skywalker
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BenchMark {

	/**
	 * 运行次数，默认20次
	 */
	public int times() default 20;
	
}
